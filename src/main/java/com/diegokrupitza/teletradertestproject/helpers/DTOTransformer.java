package com.diegokrupitza.teletradertestproject.helpers;

/**
 * Project: teletrader-test-project
 * Document: DTOTransformer.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
public interface DTOTransformer<T, K> {

    /**
     * T local object
     * K remote object
     *
     * @param object
     * @return
     */
    T toLocal(K object);

    /**
     * T local object
     * K remote object
     *
     * @param object
     * @return
     */
    K toRemote(T object);
}
