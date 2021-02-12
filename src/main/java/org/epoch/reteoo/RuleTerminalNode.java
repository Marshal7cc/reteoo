package org.epoch.reteoo;

import org.epoch.reteoo.rhs.Action;
import org.epoch.reteoo.rhs.Activation;
import org.epoch.reteoo.rhs.Agenda;
import org.epoch.reteoo.tuple.LeftTuple;
import org.epoch.reteoo.tuple.LeftTupleSink;

/**
 * Leaf Rete-OO node responsible for enacting <code>Action</code> s on a
 * matched <code>Rule</code>.
 */
public class RuleTerminalNode extends ObjectSource implements LeftTupleSink {

    private String rule;
    private Action action;

    public RuleTerminalNode(String rule, Action action) {
        this.rule = rule;
        this.action = action;
    }


    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void assertLeftTuple(LeftTuple leftTuple, PropagationContext context, WorkingMemory wm) {
        //Create ActivationItem and place it into the agenda that should be contained inside the working memory
        Agenda agenda = wm.getAgenda();
        agenda.addActivation(new Activation(this.rule, action, leftTuple));

    }

}
