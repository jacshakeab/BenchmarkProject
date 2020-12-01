package com.groot.mongodb.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import lombok.Data;

@Data
@Document
public class Student
{
    private String id, name;
    private Integer age;

    public Student( String name, Integer age ) {
        Assert.hasText( name, "Name must not be null or empty" );
        Assert.notNull( age, "Age must not be null" );

        this.name = name;
        this.age = age;
    }
}