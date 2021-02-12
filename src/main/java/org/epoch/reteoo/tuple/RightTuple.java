package org.epoch.reteoo.tuple;

import java.util.LinkedList;
import java.util.List;

import org.epoch.reteoo.InternalFactHandle;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class RightTuple {
    protected RightTupleSink sink;
    private LinkedList<InternalFactHandle> internalFactHandles = new LinkedList<InternalFactHandle>();

    public RightTuple(InternalFactHandle internalFactHandle, RightTupleSink sink) {
        this.sink = sink;
        internalFactHandles.add(internalFactHandle);
    }

    public InternalFactHandle get(int pattern) {
        return internalFactHandles.get(pattern);
    }

    public List<InternalFactHandle> getFactHandles() {

        return internalFactHandles;
    }

    public int size() {
        return internalFactHandles.size();
    }

    @Override
    public String toString() {
        return "RightTuple{" + "handles=" + internalFactHandles + ", sink=" + sink + '}';
    }

}
