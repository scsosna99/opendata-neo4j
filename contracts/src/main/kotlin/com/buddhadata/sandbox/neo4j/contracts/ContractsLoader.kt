/*
 * Copyright (c) 2019  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.contracts

import com.buddhadata.sandbox.neo4j.contracts.data.*
import com.buddhadata.sandbox.neo4j.contracts.node.*
import com.opencsv.CSVReaderBuilder
import com.opencsv.enums.CSVReaderNullFieldIndicator
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    ContractLoader().process()
    exitProcess(0)
}

/**
 * Loading contracts for the City of Chicago, https://data.cityofchicago.org/Administration-Finance/Contracts/rsxa-ify5
 */
class ContractLoader() {

    fun process() {

        //  Connect to the database (implicitly by referencing) and purge the existing data.
        neo4jSession.purgeDatabase()

        //  Open up the file as a resource stream and create a CSV reader
        var stream = InputStreamReader(this::class.java.classLoader.getResourceAsStream(DATA_FILE_NAME))
        stream.use {
            var reader = CSVReaderBuilder(stream).withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS).build()

            //  One header line, so throw away.
            reader.skip(1)

            //  Read lines until there are no more.
            var i = 0
            var line: Array<String>? = reader.readNext();
            while (!line.isNullOrEmpty() && i++ < 50000) {
                var ct: ContractType? = contTypes.get(line[FIELD_CONTRACT_TYPE])
                var dept: Department? = depts.get(line[FIELD_DEPARTMENT])
                var procurement: ProcurementType? = procurements.get(line[FIELD_PROCUREMENT])
                val state = states.get(line[FIELD_VENDOR_STATE])
                val vendor = vendors.get(line[FIELD_VENDOR_ID], line[FIELD_VENDOR_NAME], line[FIELD_VENDOR_ADDR1],
                        line[FIELD_VENDOR_ADDR2], line[FIELD_VENDOR_CITY], state)

                val contract = Contract (line[FIELD_PO_NBR], line[FIELD_PO_DESC], line[FIELD_REVISION], dept, procurement, ct,
                        vendor, parseDate(line[FIELD_APPROVE_DATE]), parseDate(line[FIELD_START_DATE]),
                        parseDate(line[FIELD_END_DATE]), parseAmount(line[FIELD_CONTRACT_AMT]))
                neo4jSession.save(contract)

                //  Attempt to read the next line
                line = reader.readNext()
            }
        }
    }

    /**
     * Convert the amount of the contract from a text string to a floating point value, truncating to the full dollar
     * amount to avoid problems with inexact decimal values when storing floats
     */
    fun parseAmount (textAmount: String?) : Float? {

        if (!textAmount.isNullOrEmpty()) {
            return textAmount.replace("$", "").toFloat().toInt().toFloat()
        } else {
            return null
        }
    }

    /**
     * Attempt to parse the date string in the raw data, which may be null
     */
    fun parseDate (textDate: String?): LocalDate? {
        if (!textDate.isNullOrEmpty()) {
            return LocalDate.parse(textDate, dateFormatter);
        } else {
            return null;
        }
    }


    companion object {

        //  Connection information for Neo4J session
        private var SERVER_URI = "bolt://localhost"
        private var SERVER_USERNAME = "neo4j"
        private var SERVER_PASSWORD = "password"

        /**
         * Input file as streamed class resource.
         */
        val file: InputStream by lazy {
            this.javaClass::class.java.getResourceAsStream(DATA_FILE_NAME)
        }

        /**
         * Neo4J session created the first time referenced.
         */
        val neo4jSession: Session by lazy {
            val configuration = Configuration.Builder().uri(SERVER_URI).credentials(SERVER_USERNAME, SERVER_PASSWORD).build();
            val sessionFactory = SessionFactory(configuration, "com.buddhadata.sandbox.neo4j.contracts.node")
            sessionFactory.openSession()
        }

        /**
         * Pattern of the dates used in the raw data
         */
        val dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")

        /**
         * Factory for creating contract types as needed
         */
        val contTypes = ContractTypeFactory(neo4jSession)

        /**
         * Factory for creating departments as needed
         */
        val depts = DepartmentFactory(neo4jSession)

        /**
         * Factory for creating procurement types as needed
         */
        val procurements = ProcurementTypeFactory(neo4jSession)

        /**
         * Factory for creating the states as needed
         */
        val states = StateFactory(neo4jSession)

        /**
         * Factory for creating vendors as needed
         */
        val vendors = VendorFactory(neo4jSession)


        //  Field positions from the parsed CSV line
        var FIELD_APPROVE_DATE = 7
        var FIELD_CONTRACT_AMT = 16
        var FIELD_CONTRACT_PDF = 18
        var FIELD_CONTRACT_TYPE = 4
        var FIELD_DEPARTMENT = 8
        var FIELD_END_DATE = 6
        var FIELD_PO_DESC = 0
        var FIELD_PO_NBR = 1
        var FIELD_PROCUREMENT = 17
        var FIELD_REVISION = 2
        var FIELD_SPECIFICATION = 3
        var FIELD_START_DATE = 5
        var FIELD_VENDOR_ADDR1 = 11
        var FIELD_VENDOR_ADDR2 = 12
        var FIELD_VENDOR_CITY = 13
        var FIELD_VENDOR_ID = 10
        var FIELD_VENDOR_NAME = 9
        var FIELD_VENDOR_STATE = 14
        var FIELD_VENDOR_ZIP = 15

        //  Name of the file as a resource
        var DATA_FILE_NAME = "Contracts.csv"
    }
}

