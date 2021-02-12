package org.epoch.reteoo.tuple;

import org.epoch.reteoo.InternalFactHandle;
import org.epoch.reteoo.PropagationContext;
import org.epoch.reteoo.WorkingMemory;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public interface LeftTupleSinkPropagator {
    void propagateAssertLeftTuple(LeftTuple tuple,
                                  PropagationContext context, WorkingMemory wm);

    void createAndPropagateAssertLeftTuple(InternalFactHandle factInternalFactHandle,
                                           PropagationContext context, WorkingMemory wm);
}
