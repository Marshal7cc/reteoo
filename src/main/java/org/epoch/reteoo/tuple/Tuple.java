package org.epoch.reteoo.tuple;

import org.epoch.reteoo.InternalFactHandle;

/**
 * <p>
 * Partial matches are propagated through the Rete network as <code>Tuple</code>s. Each <code>Tuple</code>
 * Is able to return the <code>FactHandleImpl</code> members of the partial match for the requested pattern.
 * The pattern refers to the index position of the <code>FactHandleImpl</code> in the underlying implementation.
 * <p>
 * <p>
 * 部分匹配以元组(Tuple)的形式通过Rete网络传播
 * 每个元组都能够为指定的requested pattern返回FactHandler(members of the partial match)
 *
 * @author Marshal
 * @date 2021/2/12
 */
public interface Tuple {
    /**
     * Returns the <code>FactHandle</code> for the given pattern index. If the pattern is empty
     * It returns null.
     *
     * @param pattern The index of the pattern from which the <code>FactHandleImpl</code> is to be returned
     * @return The <code>FactHandle</code>
     */
    InternalFactHandle get(int pattern);


    /**
     * Returns the size of this tuple in number of elements (patterns)
     */
    int size();
}
