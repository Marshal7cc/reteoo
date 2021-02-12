package org.epoch.reteoo.rhs;

import org.epoch.reteoo.PropagationContext;
import org.epoch.reteoo.tuple.Tuple;

/**
 * rhs的动作
 *
 * @author Marshal
 * @date 2021/2/12
 */
public interface Action {
    void execute(Tuple tuple, PropagationContext context);
}
