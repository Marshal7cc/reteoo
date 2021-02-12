package org.epoch.reteoo;

import java.util.HashMap;
import java.util.Map;

import org.epoch.reteoo.rhs.Agenda;
import org.epoch.reteoo.rhs.DefaultAgenda;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class WorkingMemoryImpl implements WorkingMemory {
    private Agenda agenda = new DefaultAgenda();
    private Rete rete;
    private Map<Object, Object> assertStore;

    public WorkingMemoryImpl() {
        rete = new Rete(this);
        assertStore = new HashMap<Object, Object>();
    }


    public Agenda getAgenda() {
        return this.agenda;
    }

    public int fireAllRules() {
        return this.agenda.fireAllRules();
    }

    public Rete getRete() {
        return rete;
    }

    public InternalFactHandle insert(Object object) {
        InternalFactHandle internalFactHandle = createHandle(object);
        rete.assertObject(internalFactHandle, null, this);
        return internalFactHandle;
    }

    private InternalFactHandle createHandle(Object object) {
        DefaultFactHandle defaultFactHandle = new DefaultFactHandle(object);
        assertStore.put(defaultFactHandle, object);
        return defaultFactHandle;
    }

    public Object getObjectForFactHandle(InternalFactHandle internalFactHandle) {
        return assertStore.get(internalFactHandle);
    }

    public Map<Object, Object> getAssertedFacts() {
        return assertStore;
    }


}
