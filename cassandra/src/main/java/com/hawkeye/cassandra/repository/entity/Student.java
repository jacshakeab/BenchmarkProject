package com.hawkeye.cassandra.repository.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table( value = "students")
public class Student
{
    @PrimaryKey( "student_id" ) private Integer id;
    @Column( "name" ) private String name;
    @Column( "age" ) private Integer age;

    public Student( Integer id )
    {
        this.id = id;
    }
}