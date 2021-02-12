package org.epoch;

import static org.junit.Assert.assertEquals;

import org.epoch.fact.Address;
import org.epoch.fact.Person;
import org.epoch.reteoo.*;
import org.epoch.reteoo.node.AlphaNode;
import org.epoch.reteoo.node.JoinNode;
import org.epoch.reteoo.node.LeftInputAdapterNode;
import org.epoch.reteoo.rhs.Action;
import org.epoch.reteoo.tuple.Tuple;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class Test {
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void simpleReteTest() {
        WorkingMemory wm = new WorkingMemoryImpl();
        Rete rete = wm.getRete();

        // network
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(Person.class.getCanonicalName());
        AlphaNode alphaNode = new AlphaNode(Comparator.EQUAL, "Name", "Marshal");
        LeftInputAdapterNode leftInputAdapter = new LeftInputAdapterNode();
        RuleTerminalNode terminalNode = new RuleTerminalNode("matches a person and execute an action", new Action() {
            public void execute(Tuple tuple, PropagationContext context) {
                // no action
            }
        });

        objectTypeNode.addObjectSink(alphaNode);
        alphaNode.addObjectSink(leftInputAdapter);
        leftInputAdapter.addTupleSink(terminalNode);
        rete.addObjectSink(objectTypeNode);

        // assert and verify agenda (no firing...)
        rete.assertFact(new Person("Marshal"));
        assertEquals(1, wm.getAgenda().size());
    }

    @org.junit.Test
    public void reteOneSimpleRuleActivationAndFireTest() {

        //Create Working Memory
        WorkingMemory wm = new WorkingMemoryImpl();
        //Get the Root/Rete Node
        Rete rete = wm.getRete();

        //Create one Object Type Node: Person()
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(Person.class.getCanonicalName());
        //Create one AlpaNode for Person(name == "Marshal")
        AlphaNode alphaNode = new AlphaNode(Comparator.EQUAL, "Name", "Marshal");
        objectTypeNode.addObjectSink(alphaNode);
        LeftInputAdapterNode leftInputAdapter = new LeftInputAdapterNode();
        alphaNode.addObjectSink(leftInputAdapter);
        RuleTerminalNode terminalNode = new RuleTerminalNode("matches a person and execute an action", new Action() {

            public void execute(Tuple tuple, PropagationContext context) {
                System.out.println("My Tuple = " + tuple);
            }
        });
        leftInputAdapter.addTupleSink(terminalNode);

        //Add OTN Person() to the Network
        rete.addObjectSink(objectTypeNode);


        //Let's use the network

        wm.insert(new Person("Marshal"));

        assertEquals(1, wm.getAgenda().size());

        int fired = wm.fireAllRules();

        assertEquals(1, fired);

        assertEquals(0, wm.getAgenda().size());

        assertEquals(1, wm.getAssertedFacts().size());

    }

    @org.junit.Test
    public void joinNodeTest() {
        //Create Working Memory
        WorkingMemory wm = new WorkingMemoryImpl();
        //Get the Root/Rete Node
        Rete rete = wm.getRete();

        //Create one Object Type Node: Person()
        ObjectTypeNode objectTypeNode = new ObjectTypeNode(Person.class.getCanonicalName());
        //Create one AlpaNode for Person(name == "Marshal")
        AlphaNode alphaNode = new AlphaNode(Comparator.EQUAL, "Name", "Marshal");
        objectTypeNode.addObjectSink(alphaNode);
        LeftInputAdapterNode leftInputAdapter = new LeftInputAdapterNode();
        alphaNode.addObjectSink(leftInputAdapter);


        //JoinNode joinNode = new JoinNode(new SingleValueRestrictionConstraint("Address.addressLine1", "Person.address", COMPARATOR.EQUAL));
        JoinNode joinNode = new JoinNode(new EmptyBetaConstraints());

        RuleTerminalNode terminalNode = new RuleTerminalNode("matches a person and execute an action", new Action() {

            public void execute(Tuple tuple, PropagationContext context) {
                System.out.println("My Tuple = " + tuple);
            }
        });
        leftInputAdapter.addTupleSink(joinNode);

        //Add OTN Person() to the Network
        rete.addObjectSink(objectTypeNode);


        //Create one Object Type Node: Address()
        objectTypeNode = new ObjectTypeNode(Address.class.getCanonicalName());
        //Create one AlpaNode for Address(addressLine1 == "nowhere")
        alphaNode = new AlphaNode(Comparator.EQUAL, "AddressLine1", "nowhere");
        objectTypeNode.addObjectSink(alphaNode);

        alphaNode.addObjectSink(joinNode);

        joinNode.addTupleSink(terminalNode);

        //Add OTN Address() to the Network
        rete.addObjectSink(objectTypeNode);

        //Let's use the network

        wm.insert(new Person("Marshal"));
        //Nothing happens until here.. let's add another Fact
        assertEquals(0, wm.getAgenda().size());


        wm.insert(new Address("nowhere"));
        assertEquals(1, wm.getAgenda().size());

        int fired = wm.fireAllRules();
        assertEquals(1, fired);

    }

}
