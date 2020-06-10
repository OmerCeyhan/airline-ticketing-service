package com.airline.ticketservice.base.controller;

import com.airline.ticketservice.base.constant.PageableConstants;
import com.airline.ticketservice.base.resource.AbstractResource;
import com.airline.ticketservice.base.data.entity.BaseEntity;
import com.airline.ticketservice.base.dto.AbstractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

@Component
public abstract class AbstractReadEntityController<Dto extends AbstractDto, Entity extends BaseEntity, Resource extends AbstractResource, PK extends Serializable>
        extends AbstractController<Dto, Entity, Resource, PK> {

    @GetMapping("/all")
    public List<Resource> all() {
        List<Entity> all = getService().all();
        return toResource(all);
    }


    @RequestMapping(path = "/pageable", method = RequestMethod.GET)
    public Page<Resource> pageable(@RequestParam(defaultValue = PageableConstants.PAGE_NO_DEFAULT_VALUE) Integer pageNo,
                                        @RequestParam(defaultValue = PageableConstants.PAGE_SIZE_DEFAULT_VALUE) Integer pageSize,
                                        @RequestParam(defaultValue = PageableConstants.SORT_BY_DEFAULT_VALUE) String sortBy,
                                        @RequestParam(name = "direction", required = false, defaultValue = PageableConstants.DIRECTION_BY_DEFAULT_VALUE) String direction) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.valueOf(direction), sortBy);
        Page<Resource> map = getService().pageable(pageable).map(m -> getConverter().toResource(m));
        return map;
    }

    @GetMapping("/{id}")
    public Resource get(@PathVariable("id") PK id) {
        return getConverter().toResource(getService().getEntity(id));
    }

}