package org.epoch.reteoo.tuple;

import java.util.LinkedList;
import java.util.List;

import org.epoch.reteoo.InternalFactHandle;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class LeftTuple implements Tuple {
    private LinkedList<InternalFactHandle> internalFactHandles = new LinkedList<InternalFactHandle>();
    private LeftTupleSink sink;

    public LeftTuple(InternalFactHandle internalFactHandle, LeftTupleSink sink) {
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
        return "LeftTuple{" + "handles=" + internalFactHandles + ", sink=" + sink + '}';
    }
}

