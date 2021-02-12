package org.epoch.reteoo.node;

import java.util.List;

import org.epoch.reteoo.BetaConstraints;
import org.epoch.reteoo.BetaMemory;
import org.epoch.reteoo.ObjectSink;
import org.epoch.reteoo.ObjectSource;
import org.epoch.reteoo.tuple.*;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public abstract class BetaNode extends LeftTupleSource implements ObjectSink, LeftTupleSink, RightTupleSink {
    /**
     * The left input <code>TupleSource</code>.
     */
    protected LeftTupleSource leftInput;

    /**
     * The right input <code>TupleSource</code>.
     */
    protected ObjectSource rightInput;

    protected BetaConstraints constraint;

    protected BetaMemory memory;

    public BetaNode(BetaConstraints constraint) {
        this.constraint = constraint;
        this.memory = new BetaMemory();
    }

    public BetaConstraints getConstraint() {
        return constraint;
    }

    public void setConstraint(BetaConstraints constraint) {
        this.constraint = constraint;
    }

    public LeftTupleSource getLeftInput() {
        return this;
    }

    public ObjectSource getRightInput() {
        return rightInput;
    }

    public void setRightInput(ObjectSource rightInput) {
        this.rightInput = rightInput;
    }

    public BetaMemory getMemory() {
        return memory;
    }

    public List<LeftTuple> getLeftTuples() {
        return getMemory().getLeftTupleMemory();
    }

    public List<RightTuple> getRightTuples() {
        return getMemory().getRightTupleMemory();
    }

}
