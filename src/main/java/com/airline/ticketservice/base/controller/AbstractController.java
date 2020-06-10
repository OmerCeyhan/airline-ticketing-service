package com.airline.ticketservice.base.controller;

import com.airline.ticketservice.base.mapper.Converter;
import com.airline.ticketservice.base.resource.AbstractResource;
import com.airline.ticketservice.base.service.AbstractEntityService;
import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.base.dto.AbstractDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public abstract class AbstractController<DTO extends AbstractDto, Entity extends BaseEntity, Resource extends AbstractResource, PK extends Serializable> {

    protected abstract AbstractEntityService<Entity, PK> getService();

    protected abstract Converter<DTO, Entity, Resource> getConverter();

    protected List<Resource> toResource(List<Entity> all) {
        if (CollectionUtils.isNotEmpty(all)) {
            return all.stream().map(e -> getConverter().toResource(e)).collect(Collectors.toList());
        }
        return null;
    }

    protected Resource toResource(Entity entity) {
        if (entity != null) {
            return getConverter().toResource(entity);
        }
        return null;
    }

    protected Resource toResource(Optional<Entity> entity) {
        return entity.map(this::toResource).orElse(null);
    }

}
