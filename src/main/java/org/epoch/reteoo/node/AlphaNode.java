package org.epoch.reteoo.node;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.epoch.reteoo.*;

/**
 * <code>AlphaNodes</code> are nodes in the <code>Rete</code> network used
 * to apply <code>FieldConstraint<.code>s on asserted fact
 * objects where the <code>FieldConstraint</code>s have no dependencies on any other of the facts in the current <code>Rule</code>.
 * <p>
 * alphaNode用来对field做match
 * </p>
 */
public class AlphaNode extends ObjectSource implements ObjectSink {

    private Comparator comparator;
    private String fieldName;
    private String value;

    public AlphaNode(Comparator comparator, String fieldName, String value) {
        this.comparator = comparator;
        this.fieldName = fieldName;
        this.value = value;
    }

    public void assertObject(InternalFactHandle factInternalFactHandle, PropagationContext propagationContext, WorkingMemory wm) {
        try {
            Object object = factInternalFactHandle.getObject();
            Class clazz = object.getClass();
            Method method = clazz.getMethod("get" + fieldName);
            Object result = method.invoke(object);
            if (((String) result).equals(value)) {
                sinkPropagator.propagateAssertObject(factInternalFactHandle, propagationContext, wm);
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AlphaNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AlphaNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AlphaNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AlphaNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AlphaNode.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
