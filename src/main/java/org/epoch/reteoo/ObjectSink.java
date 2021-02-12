package org.epoch.reteoo;

/**
 * Receiver of propagated <code>FactHandleImpl</code>s from a
 * <code>ObjectSource</code>.
 * <p>
 * 接收ObjectSource传播的FactHandle
 *
 * @see ObjectSource
 */
public interface ObjectSink {
    void assertObject(InternalFactHandle factInternalFactHandle,
                      PropagationContext propagationContext,
                      WorkingMemory wm);
}
