package org.epoch.reteoo.rhs;

import org.epoch.reteoo.tuple.Tuple;

/**
 * When a <code>Tuple</code> fully matches a rule it is added to the <code>Agenda</code>
 * As an <code>Activation</code>. Each <code>Activation</code> is assigned a number, this
 * number is determined by the <code>WorkingMemory</code> all <code>Activations</code> created
 * from a single insert, update, retract are assgigned the same Activation number.
 * <p>
 * 当一个元组完全匹配一个规则，它将作为一个Activation被添加到agenda
 * Activation被指定一个数字，这个数字由wm中所有Activation决定
 * </p>
 *
 * @author Marshal
 * @date 2021/2/12
 */
public class Activation {
    private String ruleName;
    private Action action;
    private Tuple tuple;

    public Activation(String ruleName, Action action, Tuple tuple) {
        this.ruleName = ruleName;
        this.action = action;
        this.tuple = tuple;
    }

    public Action getAction() {
        return action;
    }

    public String getRuleName() {
        return ruleName;
    }

    public Tuple getTuple() {
        return tuple;
    }

    @Override
    public String toString() {
        return "Activation{" + "ruleName=" + ruleName + ", action=" + action + ", tuple=" + tuple + '}';
    }

    public void execute() {
        action.execute(tuple, null);
    }
}
