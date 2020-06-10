package com.airline.ticketservice.base.controller;

import com.airline.ticketservice.base.resource.AbstractResource;
import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.base.dto.AbstractDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;

@Component
public abstract class AbstractEntityController<DTO extends AbstractDto, Entity extends BaseEntity, Resource extends AbstractResource, PK extends Serializable>
        extends AbstractReadEntityController<DTO, Entity, Resource, PK> {

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") PK id) {
        getService().delete(id);
    }

    @PostMapping
    public Resource save(@RequestBody @Valid DTO dto) {
        Entity entity = getService().save(getConverter().toEntity(dto));
        Resource resource = getConverter().toResource(entity);
        return resource;
    }

    @PutMapping("/{id}")
    public Resource put(@PathVariable("id") PK id, @RequestBody @Valid DTO dto) {
        Entity forSave = getConverter().toEntity(dto);
        Entity entity = getService().put(id, forSave);
        Resource resource = getConverter().toResource(entity);
        return resource;
    }


}
