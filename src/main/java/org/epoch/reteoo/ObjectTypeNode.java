package org.epoch.reteoo;

/**
 * <code>ObjectTypeNodes<code> are responsible for filtering and propagating the matching
 * fact assertions propagated from the <code>Rete</code> node using <code>ObjectType</code> interface.
 * <p/>
 * The assert and retract methods do not attempt to filter as this is the role of the <code>Rete</code>
 * node which builds up a cache of matching <code>ObjectTypdeNodes</code>s for each asserted object, using
 * the <code>matches(Object object)</code> method. Incorrect propagation in these methods is not checked and
 * will result in <code>ClassCastExpcections</code> later on in the network.
 * <p/>
 * Filters <code>Objects</code> coming from the <code>Rete</code> using a
 * <code>ObjectType</code> semantic module.
 *
 * @see Rete
 */
public class ObjectTypeNode extends ObjectSource implements ObjectSink {
    private String type;

    public ObjectTypeNode(String type) {
        this.type = type;
    }

    public void assertObject(InternalFactHandle factInternalFactHandle, PropagationContext propagationContext, WorkingMemory wm) {
        if (this.type.equals(factInternalFactHandle.getObject().getClass().getCanonicalName())) {
            sinkPropagator.propagateAssertObject(factInternalFactHandle, propagationContext, wm);
        }
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
