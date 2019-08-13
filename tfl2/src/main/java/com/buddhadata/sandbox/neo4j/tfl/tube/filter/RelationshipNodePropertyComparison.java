/*
 * Copyright (c) 2018  Scott C. Sosna  ALL RIGHTS RESERVED
 */

package com.buddhadata.sandbox.neo4j.tfl.tube.filter;

import com.buddhadata.sandbox.neo4j.tfl.tube.enums.RelationshipNodeType;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.function.FilterFunction;

import java.util.HashMap;
import java.util.Map;

import static org.neo4j.ogm.cypher.ComparisonOperator.*;

/**
 * Filter for filtering based on the start or end node of a relationship.
 *
 * Extension of the base PropertyComparison class
 * @author Jasper Blues
 * @author Scott C Sosna
 */
public class RelationshipNodePropertyComparison implements FilterFunction<Object> {

    /**
     * Identifies either the start or end node of the relationship
     */
    private final RelationshipNodeType nodeType;

    /**
     * The operator to apply in the generated Cypher query fragment
     */
    private final ComparisonOperator operator;

    /**
     * The object/value compared against the operator
     */
    private final Object value;

    /**
     * The overarching filter that uses this filter function
     */
    private Filter filter;


    /**
     * Constructor
     * @param nodeType start or end node of the relationship
     * @param operator what operator to apply to the property of interest
     * @param value the property value to use when applying the operator
     */
    public RelationshipNodePropertyComparison(RelationshipNodeType nodeType,
                                              ComparisonOperator operator,
                                              Object value) {
        this.nodeType = nodeType;
        this.operator = operator;
        this.value = value;
    }

    /**
     * getter
     * @return the object/value compared against the operator
     */
    @Override
    public Object getValue() {
        return this.value;
    }

    /**
     * getter
     * @return the overarching filter that uses this filter function instance
     */
    @Override
    public Filter getFilter() {
        return filter;
    }

    /**
     * setter
     * @param filter the overarching filter that uses this filter function instance
     */
    @Override
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * Generates the Cypher query fragment
     * @param nodeIdentifier the specific property name
     * @return query fragment
     */
    @Override
    public String expression(String nodeIdentifier) {
        if (operator.equals(IS_NULL)) {
            return String.format("%s(%s).`%s` IS NULL ", nodeType.getFunctionName(), nodeIdentifier, filter.getPropertyName());
        } else if (operator.equals(EXISTS)) {
            return String.format("EXISTS(%s(%s).`%s`) ", nodeType.getFunctionName(), nodeIdentifier, filter.getPropertyName());
        } else if (operator.equals(IS_TRUE)) {
            return String.format("%s(%s).`%s` = true ", nodeType.getFunctionName(), nodeIdentifier, filter.getPropertyName());
        } else {
            return String.format("%s(%s).`%s` %s { `%s` } ", nodeType.getFunctionName(), nodeIdentifier, filter.getPropertyName(),
                    operator.getValue(), filter.uniqueParameterName());
        }
    }

    /**
     * getter
     * @return parameters to plug into the query fragment
     */
    @Override
    public Map<String, Object> parameters() {
        Map<String, Object> map = new HashMap<>();
        if (!operator.isOneOf(IS_NULL, EXISTS, IS_TRUE)) {
            map.put(filter.uniqueParameterName(), filter.getTransformedPropertyValue());
        }
        return map;
    }
}
