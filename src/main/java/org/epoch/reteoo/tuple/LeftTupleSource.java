package org.epoch.reteoo.tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * A source of <code>ReteTuple</code> s for a <code>TupleSink</code>.
 *
 * <p>
 * Nodes that propagate <code>Tuples</code> extend this class.
 * </p>
 * <p>
 * 元组槽的source
 * 传播元组的node继承该类
 */
public class LeftTupleSource {
    protected List<LeftTupleSink> sinks = new ArrayList<LeftTupleSink>();

    public LeftTupleSource() {
    }


    public void addTupleSink(final LeftTupleSink tupleSink) {
        sinks.add(tupleSink);
    }

}
