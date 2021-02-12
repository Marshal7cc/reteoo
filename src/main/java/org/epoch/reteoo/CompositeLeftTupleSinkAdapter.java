package org.epoch.reteoo;

import java.util.ArrayList;
import java.util.List;

import org.epoch.reteoo.tuple.LeftTuple;
import org.epoch.reteoo.tuple.LeftTupleSink;
import org.epoch.reteoo.tuple.LeftTupleSinkPropagator;
import org.epoch.reteoo.tuple.RightTuple;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class CompositeLeftTupleSinkAdapter implements LeftTupleSinkPropagator {
    private List<LeftTupleSink> sinks = new ArrayList<LeftTupleSink>();

    public void propagateAssertLeftTuple(LeftTuple tuple, PropagationContext context, WorkingMemory wm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createAndPropagateAssertLeftTuple(InternalFactHandle factInternalFactHandle, PropagationContext context, WorkingMemory wm) {
        for (LeftTupleSink sink : sinks) {
            this.doPropagateAssertLeftTuple(context, sink, new LeftTuple(factInternalFactHandle, sink), wm);
        }
    }


    protected void doPropagateAssertLeftTuple(PropagationContext context,
                                              LeftTupleSink sink,
                                              LeftTuple leftTuple,
                                              WorkingMemory wm) {

        sink.assertLeftTuple(leftTuple,
                context, wm);

    }

    protected void doPropagateAssertLeftTuple(PropagationContext context,
                                              LeftTupleSink sink,
                                              LeftTuple leftTuple,
                                              RightTuple rightTuple,
                                              WorkingMemory wm) {


        sink.assertLeftTuple(leftTuple,
                context, wm);

    }

    public void addTupleSink(final LeftTupleSink sink) {
        this.sinks.add((LeftTupleSink) sink);
    }

}
