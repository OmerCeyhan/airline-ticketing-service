package com.airline.ticketservice.base.mapper;

import java.util.List;

/**
 * DTO-Entity-Resource Converter Interface.
 */
public interface Converter<DTO, Entity, Resource> {

    Resource toResource(Entity entity);

    List<Resource> toResource(List<Entity> entityList);

    Entity toEntity(DTO dto);


}
