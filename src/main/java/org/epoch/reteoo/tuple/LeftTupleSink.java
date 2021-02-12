package org.epoch.reteoo.tuple;

import org.epoch.reteoo.PropagationContext;
import org.epoch.reteoo.WorkingMemory;

/**
 * Receiver of propagated <code>ReteTuple</code>s from a
 * <code>TupleSource</code>.
 * <p>
 * 从元组source传播元组的接收者
 *
 * @see LeftTupleSource
 */
public interface LeftTupleSink {
    void assertLeftTuple(LeftTuple leftTuple,
                         PropagationContext context, WorkingMemory wm);
}
