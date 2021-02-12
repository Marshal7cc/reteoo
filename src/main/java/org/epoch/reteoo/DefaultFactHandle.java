package org.epoch.reteoo;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class DefaultFactHandle implements InternalFactHandle {
    private Object object;

    public DefaultFactHandle(Object object) {
        this.object = object;
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "FactHandle{" + "object=" + object + '}';
    }
}
