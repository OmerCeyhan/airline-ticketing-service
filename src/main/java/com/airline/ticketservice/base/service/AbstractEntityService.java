package com.airline.ticketservice.base.service;

import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.base.data.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractEntityService<T extends BaseEntity, PK extends Serializable> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractEntityService.class);

    public abstract BaseRepository<T, PK> getRepository();

    protected T verifySave(T entity) {
        return entity;
    }

    protected T verifyPut(T theReal, T forSave) {
        return forSave;
    }

    protected T verifyDelete(T entity) {
        return entity;
    }

    @Transactional
    public T save(T entity) {
        verifySave(entity);
        entity = getRepository().save(entity);
        LOGGER.info("Record saved: " + entity.toString());
        return entity;
    }

    @Transactional
    public T put(PK id, T forSave) {
        T theReal = getEntity(id);
        forSave.setId(theReal.getId());
        forSave.setCreatedDate(theReal.getCreatedDate());
        forSave.setRowVersion(theReal.getRowVersion());
        verifyPut(theReal, forSave);
        forSave = getRepository().save(forSave);
        LOGGER.info("Record updated: " + forSave.toString());
        return forSave;
    }

    @Transactional
    public void delete(PK id) {
        T entity = getEntity(id);
        verifyDelete(entity);
        LOGGER.info("Deleting record: " + entity.toString());
        getRepository().delete(entity);
    }

    public T getEntity(PK id) {

        Optional<T> entity = getRepository().findById(id);
        return entity.orElse(null);
    }

    public List<T> all() {
        return getRepository().findAll();
    }

    public Page<T> pageable(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

}
