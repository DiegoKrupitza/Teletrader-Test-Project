package com.diegokrupitza.teletradertestproject.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

/**
 * Project: teletrader-test-project
 * Document: BaseModel.java
 * Author: Diego Krupitza
 * Created: 03.07.18
 */
@MappedSuperclass
@Data
public abstract class BaseModel<T extends BaseModel> extends AbstractPersistable<Long>
        implements Comparable<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Override
    public int compareTo(T o) {
        return this.getId().compareTo(o.getId());
    }
}