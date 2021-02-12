package org.epoch.reteoo;

import java.util.ArrayList;
import java.util.List;

import org.epoch.reteoo.tuple.LeftTuple;
import org.epoch.reteoo.tuple.RightTuple;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class BetaMemory {
    private List<LeftTuple> leftTupleMemory = new ArrayList<LeftTuple>();
    private List<RightTuple> rightTupleMemory = new ArrayList<RightTuple>();

    public BetaMemory() {
    }


    public void addLeftTuple(LeftTuple tuple) {
        leftTupleMemory.add(tuple);
    }

    public void addRightTuple(RightTuple tuple) {
        rightTupleMemory.add(tuple);
    }

    public List<LeftTuple> getLeftTupleMemory() {
        return leftTupleMemory;
    }

    public List<RightTuple> getRightTupleMemory() {
        return rightTupleMemory;
    }

}
