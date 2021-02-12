package org.epoch.reteoo;

/**
 * The Rete-OO network.
 * <p>
 * The Rete class is the root <code>Object</code>. All objects are asserted into
 * the Rete node where it propagates to all matching ObjectTypeNodes.
 * <p>
 * The first time an  instance of a Class type is asserted it does a full
 * iteration of all ObjectTyppeNodes looking for matches, any matches are
 * then cached in a HashMap which is used for future assertions.
 * <p>
 * While Rete  extends ObjectSource nad implements ObjectSink it nulls the
 * methods attach(), remove() and  updateNewNode() as this is the root node
 * they are no applicable
 *
 * @see ObjectTypeNode
 */
public class Rete extends ObjectSource implements ObjectSink {
    private WorkingMemory wm;

    public Rete(WorkingMemory wm) {
        this.wm = wm;
    }

    public void assertObject(InternalFactHandle factInternalFactHandle, PropagationContext propagationContext, WorkingMemory wm) {
        sinkPropagator.propagateAssertObject(factInternalFactHandle, propagationContext, wm);
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void assertFact(Object fact) {
        this.assertObject(new DefaultFactHandle(fact), null, this.wm);
    }

    public WorkingMemory getWm() {
        return wm;
    }
}
