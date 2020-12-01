package com.groot.mongodb.repository;

import org.springframework.data.repository.CrudRepository;

import com.groot.mongodb.repository.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>
{
    Iterable<Student> findByName(String name);
}
