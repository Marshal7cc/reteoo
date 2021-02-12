package org.epoch.reteoo.node;

import org.epoch.reteoo.*;
import org.epoch.reteoo.tuple.LeftTupleSink;
import org.epoch.reteoo.tuple.LeftTupleSource;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class LeftInputAdapterNode extends LeftTupleSource implements ObjectSink {
    //HardCoded composite
    CompositeLeftTupleSinkAdapter sinkAdapter = new CompositeLeftTupleSinkAdapter();

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void assertObject(InternalFactHandle factInternalFactHandle, PropagationContext propagationContext, WorkingMemory wm) {

        sinkAdapter.createAndPropagateAssertLeftTuple(factInternalFactHandle, propagationContext, wm);


    }

    @Override
    public void addTupleSink(final LeftTupleSink tupleSink) {
        sinkAdapter.addTupleSink(tupleSink);
    }


}
