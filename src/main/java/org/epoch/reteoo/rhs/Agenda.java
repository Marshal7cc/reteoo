package org.epoch.reteoo.rhs;

/**
 * @author Marshal
 * @date 2021/2/12
 */
public interface Agenda {
    void addActivation(Activation activation);

    Activation getFirstActivation();

    /**
     * Fires all activations currently in agenda that match the given agendaFilter
     * until the fireLimit is reached or no more activations exist.
     *
     * @return the number of rules that were actually fired
     */
    int fireAllRules();

    int size();
}
