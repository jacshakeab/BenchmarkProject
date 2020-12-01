package com.hawkeye.cassandra.repository;

import org.springframework.data.repository.CrudRepository;

import com.hawkeye.cassandra.repository.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>
{}
