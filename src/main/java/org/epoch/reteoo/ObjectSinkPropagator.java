package org.epoch.reteoo;

import java.util.List;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public interface ObjectSinkPropagator {
    void propagateAssertObject(InternalFactHandle factInternalFactHandle,
                               PropagationContext context, WorkingMemory wm);

    List<ObjectSink> getSinks();

    void addSinks(List<ObjectSink> sinks);
}
