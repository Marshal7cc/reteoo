package org.epoch.reteoo.node;

/**
 * Interface used to expose generic information on Rete nodes outside of he package. It is used
 * for exposing information events.
 */
public interface NetworkNode {
    /**
     * Returns the unique id that represents the node in the Rete network
     */
    int getId();
}
