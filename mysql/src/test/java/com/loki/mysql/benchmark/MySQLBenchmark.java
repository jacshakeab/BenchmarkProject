package com.loki.mysql.benchmark;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.loki.mysql.repository.StudentRepository;
import com.loki.mysql.repository.entity.Student;

@SpringBootTest
@State( Scope.Benchmark)
@BenchmarkMode( Mode.AverageTime)
@OutputTimeUnit( TimeUnit.MILLISECONDS)
@RunWith( SpringRunner.class)
public class MySQLBenchmark extends AbstractMySQLBenchmark
{
    private static StudentRepository studentRepository;

    @Autowired
    private void setStudentRepository(StudentRepository studentRepository) {
        MySQLBenchmark.studentRepository = studentRepository;
    }

    @Setup( Level.Trial)
    public void setupBenchmark() {
        final Student student0 = new Student();
        student0.setName( "Steve Rogers" );
        student0.setAge( 33 );
        studentRepository.save( student0 );

        final Student student1 = new Student();
        student1.setName( "Tony Stark" );
        student1.setAge( 104 );
        studentRepository.save( student1 );

        final Student student2 = new Student();
        student2.setName( "Bruce Banner" );
        student2.setAge( 8 );
        studentRepository.save( student2 );

        final Student student3 = new Student();
        student3.setName( "Natasha Romanoff" );
        student3.setAge( 55 );
        studentRepository.save( student3 );

        final Student student4 = new Student();
        student4.setName( "Clint Barton" );
        student4.setAge( 60 );
        studentRepository.save( student4 );

        final Student student5 = new Student();
        student5.setName( "Nick Fury" );
        student5.setAge( 72 );
        studentRepository.save( student5 );

        final Student student6 = new Student();
        student6.setName( "Pepper Potts" );
        student6.setAge( 98 );
        studentRepository.save( student6 );

        final Student student7 = new Student();
        student7.setName( "Jarvis" );
        student7.setAge( 29 );
        studentRepository.save( student7 );

        final Student student8 = new Student();
        student8.setName( "Thor Odinson" );
        student8.setAge( 42 );
        studentRepository.save( student8 );

        final Student student9 = new Student();
        student9.setName( "Phil Coulson" );
        student9.setAge( 12 );
        studentRepository.save( student9 );
    }


    @Benchmark
    public void benchmarkFetchAll() {
        studentRepository.findAll();
    }

    @Benchmark
    public void benchmarkFetchOne() {
        studentRepository.findByName("Thor Odinson");
    }
}
