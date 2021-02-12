package org.epoch.reteoo;

import java.util.Map;

import org.epoch.reteoo.rhs.Agenda;

/**
 * A knowledge session for a <code>RuleBase</code>.
 * <p>
 * While this object can be serialised out, it cannot be serialised in. This is because
 * the RuleBase reference is transient. Please see the RuleBase interface for serializing
 * in WorkingMemories from an InputStream.
 */
public interface WorkingMemory {
    Agenda getAgenda();

    int fireAllRules();

    Rete getRete();

    InternalFactHandle insert(Object fact);

    Map<Object, Object> getAssertedFacts();
}
