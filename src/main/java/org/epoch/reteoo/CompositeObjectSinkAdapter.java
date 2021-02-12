package org.epoch.reteoo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class CompositeObjectSinkAdapter implements ObjectSinkPropagator {
    private List<ObjectSink> sinks = new ArrayList<ObjectSink>();

    public void propagateAssertObject(InternalFactHandle factInternalFactHandle, PropagationContext context, WorkingMemory wm) {
        for (ObjectSink sink : sinks) {
            sink.assertObject(factInternalFactHandle, context, wm);
        }
    }

    public void addObjectSink(ObjectSink sink) {
        sinks.add(sink);
    }

    public List<ObjectSink> getSinks() {
        return sinks;
    }

    public void addSinks(List<ObjectSink> sinks) {
        for (ObjectSink sink : sinks) {
            this.addObjectSink(sink);
        }
    }
}
