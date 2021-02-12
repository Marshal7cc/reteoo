package org.epoch.reteoo.rhs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public class DefaultAgenda implements Agenda {

    private List<Activation> activations = new ArrayList<Activation>();

    public void addActivation(Activation activation) {
        activations.add(activation);
    }

    public Activation getFirstActivation() {
        return activations.remove(0);
    }

    public int size() {
        return activations.size();
    }

    public int fireAllRules() {
        int counter = 0;
        while (size() != 0) {
            getFirstActivation().execute();
            counter++;
        }
        return counter;
    }

}
