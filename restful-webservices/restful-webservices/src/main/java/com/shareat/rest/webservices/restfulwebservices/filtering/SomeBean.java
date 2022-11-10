package com.shareat.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;

//it is possible to filter the result at class level
@JsonIgnoreProperties("field1")

@JsonFilter("SomeBeanFilter")
//to define dynamic filtering it is
//needed to do so at the restAPI level
public class SomeBean {



    private String field1;

    //let's pretend this field is a password
    //with JSON ignore it will not be returned by a get call
    private String field2;
    private String filed3;


    public SomeBean(String field1, String field2, String filed3) {

        this.field1 = field1;
        this.field2 = field2;
        this.filed3 = filed3;
    }


    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;

    }

    public String getFiled3() {
        return filed3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", filed3='" + filed3 + '\'' +
                '}';
    }
}
