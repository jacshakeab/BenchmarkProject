DROP KEYSPACE IF EXISTS benchmark;

CREATE KEYSPACE benchmark WITH replication = {
    'class': 'SimpleStrategy',
    'replication_factor': 1
    };

USE benchmark;

CREATE TABLE students (
                           student_id int primary key,
                           name text,
                           age int
);