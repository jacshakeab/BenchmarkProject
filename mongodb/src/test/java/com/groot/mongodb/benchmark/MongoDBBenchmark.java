package com.groot.mongodb.benchmark;

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

import com.groot.mongodb.repository.StudentRepository;
import com.groot.mongodb.repository.entity.Student;

@SpringBootTest
@State( Scope.Benchmark )
@BenchmarkMode( Mode.AverageTime )
@OutputTimeUnit( TimeUnit.MILLISECONDS )
@RunWith( SpringRunner.class )
public class MongoDBBenchmark extends AbstractMySQLBenchmark
{
    private static StudentRepository studentRepository;

    @Autowired
    private void setStudentRepository( StudentRepository studentRepository )
    {
        MongoDBBenchmark.studentRepository = studentRepository;
    }

    @Setup( Level.Trial )
    public void setupBenchmark()
    {
        final Student student0 = new Student("Steve Rogers", 33);
        studentRepository.save( student0 );

        final Student student1 = new Student("Tony Stark", 104);
        studentRepository.save( student1 );

        final Student student2 = new Student("Bruce Banner", 8);
        studentRepository.save( student2 );

        final Student student3 = new Student("Natasha Romanoff", 55);
        studentRepository.save( student3 );

        final Student student4 = new Student("Clint Barton", 60);
        studentRepository.save( student4 );

        final Student student5 = new Student("Nick Fury", 72);
        studentRepository.save( student5 );

        final Student student6 = new Student("Pepper Potts", 98);
        studentRepository.save( student6 );

        final Student student7 = new Student("Jarvis", 29);
        studentRepository.save( student7 );

        final Student student8 = new Student("Thor Odinson", 42);
        studentRepository.save( student8 );

        final Student student9 = new Student("Phil Coulson", 12);
        studentRepository.save( student9 );
    }

    @Benchmark
    public void benchmarkFetchAll()
    {
        studentRepository.findAll();
    }

    @Benchmark
    public void benchmarkFetchOne()
    {
        studentRepository.findByName( "Thor Odinson" );
    }
}
