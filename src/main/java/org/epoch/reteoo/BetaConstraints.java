package org.epoch.reteoo;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public interface BetaConstraints {
    Object getField();

    Object getRestriction();

    Comparator getComparator();
}
