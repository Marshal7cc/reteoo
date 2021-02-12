package org.epoch.reteoo;

/**
 * A source of <code>FactHandle</code>s for an <code>ObjectSink</code>.
 *
 * <p>
 * Nodes that propagate <code>FactHandleImpl</code> extend this class.
 * </p>
 * 通过ObjectSinkPropagator间接持有一组ObjectSink,并为其提供FactHandler
 *
 * @see ObjectSource
 * @see DefaultFactHandle
 */
public class ObjectSource {
    //Hard Coded Composite Object Sink
    protected ObjectSinkPropagator sinkPropagator = new CompositeObjectSinkAdapter();
    protected ObjectSource source;

    public void addObjectSink(ObjectSink sink) {
        //Composite Sink for multiple propagations
        ((CompositeObjectSinkAdapter) sinkPropagator).addObjectSink(sink);
    }
}
