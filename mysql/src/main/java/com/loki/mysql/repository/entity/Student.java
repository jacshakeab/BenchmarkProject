package com.loki.mysql.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@EqualsAndHashCode( of = "id" )
@Data
@RequiredArgsConstructor
@ToString
public class Student
{
    private @Id @GeneratedValue Long id;

    private String name;
    private Integer age;

}