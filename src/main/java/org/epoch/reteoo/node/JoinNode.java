package org.epoch.reteoo.node;

import org.epoch.reteoo.*;
import org.epoch.reteoo.tuple.LeftTuple;
import org.epoch.reteoo.tuple.LeftTupleSink;
import org.epoch.reteoo.tuple.RightTuple;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class JoinNode extends BetaNode {

    public JoinNode(BetaConstraints constraint) {
        super(constraint);
    }

    public void assertObject(InternalFactHandle factInternalFactHandle, PropagationContext propagationContext, WorkingMemory wm) {
        RightTuple rightTuple = new RightTuple(factInternalFactHandle, this);
        getMemory().addRightTuple(rightTuple); //?? this to the rightTupleSink????
        for (LeftTuple leftTuple : getMemory().getLeftTupleMemory()) {
            if (constraint instanceof EmptyBetaConstraints) {
                System.out.println("Left Tuple = " + leftTuple);
                System.out.println("Right Tuple = " + rightTuple);
                for (LeftTupleSink sink : sinks) {
                    sink.assertLeftTuple(leftTuple, propagationContext, wm);
                }
            }

            //if it matches with the rigth tuple propagate
//            for (LeftTupleSink sink : sinks) {
//                sink.assertLeftTuple(leftTuple, propagationContext, wm);
//            }
        }
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void assertLeftTuple(LeftTuple leftTuple, PropagationContext propagationContext, WorkingMemory wm) {
        getMemory().addLeftTuple(leftTuple);

        for (RightTuple rightTuple : getMemory().getRightTupleMemory()) {
            if (constraint instanceof EmptyBetaConstraints) {
                System.out.println("Left Tuple = " + leftTuple);
                System.out.println("Right Tuple = " + rightTuple);
                for (LeftTupleSink sink : sinks) {
                    sink.assertLeftTuple(leftTuple, propagationContext, wm);
                }
            }


        }
        //if it matches with the left tuple propagate
//        for (LeftTupleSink sink : sinks) {
//            sink.assertLeftTuple(leftTuple, context, wm);
//        }
    }
}
