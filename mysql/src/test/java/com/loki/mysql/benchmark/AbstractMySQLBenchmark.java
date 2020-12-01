package com.loki.mysql.benchmark;

import org.junit.Test;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

abstract class AbstractMySQLBenchmark
{
    private final static Integer MEASUREMENT_ITERATIONS = 9;
    private final static Integer WARMUP_ITERATIONS = 3;

    @Test
    public void executeJmhRunner() throws RunnerException
    {
        Options opt = new OptionsBuilder()
                // set the class name regex for benchmarks to search for to the current class
                .include("\\." + this.getClass().getSimpleName() + "\\.")
                .warmupIterations(WARMUP_ITERATIONS)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                // do not use forking or the benchmark methods will not see references stored within its class
                .forks(0)
                // do not use multiple threads
                .threads(1)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .resultFormat( ResultFormatType.TEXT )
                .result("./report.txt") // set this to a valid filename if you want reports
                .shouldFailOnError(true)
                .jvmArgs("-server",
                         "-XX:+HeapDumpOnOutOfMemoryError",
                         "-XX:HeapDumpPath=heapdump.hprof",
                         "-XX:StartFlightRecording=" +
                                 "disk=true," +
                                 "dumponexit=true," +
                                 "filename=recording-test.jfr," +
                                 "maxsize=1024m," +
                                 "maxage=1d," +
                                 "settings=profile," +
                                 "path-to-gc-roots=true")
                .build();

        new Runner( opt).run();
    }
}
