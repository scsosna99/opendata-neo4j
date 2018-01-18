package com.buddhadata.sandbox.neo4j;

import com.buddhadata.sandbox.neo4j.entity.DummyNode;
import com.buddhadata.sandbox.neo4j.entity.DummyRelationship;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import uk.gov.tfl.api.client.client.api.LineApi;
import uk.gov.tfl.api.client.client.model.RouteSequence;

/**
 * Created by scsosna on 1/5/18.
 */
public class HelloWorld {

    public static void main (String[] args) {
        try {
            Configuration configuration = new Configuration.Builder().uri("bolt://localhost").credentials("neo4j", "password").build();
            SessionFactory factory = new SessionFactory(configuration, "com.buddhadata.sandbox.neo4j.node", "com.buddhadata.sandbox.neo4j.relationship");

            Session session = factory.openSession();
            session.purgeDatabase();
            Transaction txn = session.beginTransaction();
            DummyNode start = new DummyNode();
            start.name = "StartNode";
            start.labels.add("SpecialNode");
            session.save(start);
            DummyNode end = new DummyNode();
            end.name = "EndNode";
            end.labels.add("SpecialNode");
            session.save(end);
            DummyRelationship rel = new DummyRelationship();
            rel.start = start;
            rel.end = end;
            session.save(rel);
            txn.commit();
        } catch (Throwable t) {
            System.out.println (t);
            t.printStackTrace();
        }
    }
}
