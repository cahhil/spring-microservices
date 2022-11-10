package com.shareat.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //example of dynamic filtering
    @GetMapping(path ="/filtering")
    public MappingJacksonValue filtering(){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new SomeBean("bullshit", "cock", "pussy"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping(path ="/filtering-list")
    public List<SomeBean> filteringList(){
        List asList = new ArrayList<SomeBean>();
        asList.set(0, new SomeBean("bullshit", "cock", "pussy"));
        asList.set(1, new SomeBean("fuck", "walk", "fly"));
        return asList;
    }
}
