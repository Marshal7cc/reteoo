package org.epoch.reteoo;

/**
 * An handle to a fact inserted into the working memory
 */
public interface InternalFactHandle {
    long getId();

    Object getObject();
}
