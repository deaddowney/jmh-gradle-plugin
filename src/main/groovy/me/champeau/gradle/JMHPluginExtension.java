/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.champeau.gradle;

import org.gradle.api.Project;
import org.gradle.api.file.DuplicatesStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JMHPluginExtension {
    private final Project project;

    private String jmhVersion = "1.15";
    private boolean includeTests = true;

    private List<String> include = new ArrayList<String>();
    private List<String> exclude = new ArrayList<String>();
    private List<String> benchmarkMode;
    private Integer iterations;
    private Integer batchSize;
    private Integer fork;
    private Boolean failOnError;
    private Boolean forceGC;
    private String jvm;
    private List<String> jvmArgs;
    private List<String> jvmArgsAppend;
    private List<String> jvmArgsPrepend;
    private File humanOutputFile;
    private File resultsFile;
    private Integer operationsPerInvocation;
    private Map<String, Collection<String>> benchmarkParameters;
    private List<String> profilers;
    private String timeOnIteration;
    private String resultExtension;
    private String resultFormat;
    private Boolean synchronizeIterations;
    private Integer threads;
    private List<Integer> threadGroups;
    private String timeUnit;
    private String verbosity;
    private String timeout;
    private String warmup;
    private Integer warmupBatchSize;
    private Integer warmupForks;
    private Integer warmupIterations;
    private String warmupMode;
    private List<String> warmupBenchmarks;
    private boolean zip64 = false;
    private DuplicatesStrategy duplicateClassesStrategy = DuplicatesStrategy.FAIL;

    public JMHPluginExtension(final Project project) {
        this.project = project;
    }

    public String getJmhVersion() {
        return jmhVersion;
    }

    public void setJmhVersion(final String jmhVersion) {
        this.jmhVersion = jmhVersion;
    }

    void resolveArgs() {
        resolveResultExtension();
        resolveResultFormat();
        resolveResultsFile();
    }

    private void resolveResultsFile() {
        resultsFile = resultsFile != null ? resultsFile : project.file(String.valueOf(project.getBuildDir()) + "/reports/jmh/results." + resultExtension);
    }

    private void resolveResultExtension() {
        resultExtension = resultFormat != null ? parseResultFormat() : "txt";
    }

    private void resolveResultFormat() {
        resultFormat = resultFormat != null ? resultFormat : "text";
    }

    private String parseResultFormat() {
        return ResultFormatType.translate(resultFormat);
    }

    public List<String> getInclude() {
        return include;
    }

    @Deprecated
    public void setInclude(String include) {
        this.include = Collections.singletonList(include);
    }

    public void setInclude(List<String> include) {
        this.include = include;
    }

    public List<String> getExclude() {
        return exclude;
    }

    @Deprecated
    public void setExclude(String exclude) {
        this.exclude = Collections.singletonList(exclude);
    }

    public void setExclude(List<String> exclude) {
        this.exclude = exclude;
    }

    public List<String> getBenchmarkMode() {
        return benchmarkMode;
    }

    public void setBenchmarkMode(List<String> benchmarkMode) {
        this.benchmarkMode = benchmarkMode;
    }

    public Integer getIterations() {
        return iterations;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public Integer getFork() {
        return fork;
    }

    public void setFork(Integer fork) {
        this.fork = fork;
    }

    public Boolean getFailOnError() {
        return failOnError;
    }

    public void setFailOnError(Boolean failOnError) {
        this.failOnError = failOnError;
    }

    public Boolean getForceGC() {
        return forceGC;
    }

    public void setForceGC(Boolean forceGC) {
        this.forceGC = forceGC;
    }

    public String getJvm() {
        return jvm;
    }

    public void setJvm(String jvm) {
        this.jvm = jvm;
    }

    public List<String> getJvmArgs() {
        return jvmArgs;
    }

    @Deprecated
    public void setJvmArgs(String jvmArgs) {
        this.jvmArgs = Arrays.asList(jvmArgs.split(" "));
    }

    public void setJvmArgs(List<String> jvmArgs) {
        this.jvmArgs = jvmArgs;
    }

    public List<String> getJvmArgsAppend() {
        return jvmArgsAppend;
    }

    @Deprecated
    public void setJvmArgsAppend(String jvmArgsAppend) {
        this.jvmArgsAppend = Arrays.asList(jvmArgsAppend.split(" "));
    }

    public void setJvmArgsAppend(List<String> jvmArgsAppend) {
        this.jvmArgsAppend = jvmArgsAppend;
    }

    public List<String> getJvmArgsPrepend() {
        return jvmArgsPrepend;
    }

    @Deprecated
    public void setJvmArgsPrepend(String jvmArgsPrepend) {
        this.jvmArgsPrepend = Arrays.asList(jvmArgsPrepend.split(" "));
    }

    public void setJvmArgsPrepend(List<String> jvmArgsPrepend) {
        this.jvmArgsPrepend = jvmArgsPrepend;
    }

    public File getHumanOutputFile() {
        return humanOutputFile;
    }

    public void setHumanOutputFile(File humanOutputFile) {
        this.humanOutputFile = humanOutputFile;
    }

    public File getResultsFile() {
        return resultsFile;
    }

    public void setResultsFile(File resultsFile) {
        this.resultsFile = resultsFile;
    }

    public Integer getOperationsPerInvocation() {
        return operationsPerInvocation;
    }

    public void setOperationsPerInvocation(Integer operationsPerInvocation) {
        this.operationsPerInvocation = operationsPerInvocation;
    }

    public Map<String, Collection<String>> getBenchmarkParameters() {
        return benchmarkParameters;
    }

    public void setBenchmarkParameters(Map<String, Collection<String>> benchmarkParameters) {
        this.benchmarkParameters = benchmarkParameters;
    }

    public List<String> getProfilers() {
        return profilers;
    }

    public void setProfilers(List<String> profilers) {
        this.profilers = profilers;
    }

    public String getTimeOnIteration() {
        return timeOnIteration;
    }

    public void setTimeOnIteration(String timeOnIteration) {
        this.timeOnIteration = timeOnIteration;
    }

    public String getResultFormat() {
        return resultFormat;
    }

    public void setResultFormat(String resultFormat) {
        this.resultFormat = resultFormat;
    }

    public Boolean getSynchronizeIterations() {
        return synchronizeIterations;
    }

    public void setSynchronizeIterations(Boolean synchronizeIterations) {
        this.synchronizeIterations = synchronizeIterations;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public List<Integer> getThreadGroups() {
        return threadGroups;
    }

    public void setThreadGroups(List<Integer> threadGroups) {
        this.threadGroups = threadGroups;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getVerbosity() {
        return verbosity;
    }

    public void setVerbosity(String verbosity) {
        this.verbosity = verbosity;
    }

    public String getWarmup() {
        return warmup;
    }

    public void setWarmup(String warmup) {
        this.warmup = warmup;
    }

    public Integer getWarmupBatchSize() {
        return warmupBatchSize;
    }

    public void setWarmupBatchSize(Integer warmupBatchSize) {
        this.warmupBatchSize = warmupBatchSize;
    }

    public Integer getWarmupForks() {
        return warmupForks;
    }

    public void setWarmupForks(Integer warmupForks) {
        this.warmupForks = warmupForks;
    }

    public Integer getWarmupIterations() {
        return warmupIterations;
    }

    public void setWarmupIterations(Integer warmupIterations) {
        this.warmupIterations = warmupIterations;
    }

    public String getWarmupMode() {
        return warmupMode;
    }

    public void setWarmupMode(String warmupMode) {
        this.warmupMode = warmupMode;
    }

    public List<String> getWarmupBenchmarks() {
        return warmupBenchmarks;
    }

    public void setWarmupBenchmarks(List<String> warmupBenchmarks) {
        this.warmupBenchmarks = warmupBenchmarks;
    }

    public boolean isZip64() {
        return zip64;
    }

    public void setZip64(final boolean zip64) {
        this.zip64 = zip64;
    }

    public boolean isIncludeTests() {
        return includeTests;
    }

    public void setIncludeTests(boolean includeTests) {
        this.includeTests = includeTests;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }


    public DuplicatesStrategy getDuplicateClassesStrategy() {
        return duplicateClassesStrategy;
    }

    public void setDuplicateClassesStrategy(DuplicatesStrategy duplicateClassesStrategy) {
        this.duplicateClassesStrategy = duplicateClassesStrategy;
    }

    private enum ResultFormatType {
        TEXT("txt"),
        CSV("csv"),
        SCSV("scsv"),
        JSON("json"),
        LATEX("tex");

        private String extension;

        ResultFormatType(String extension) {
            this.extension = extension;
        }

        public static String translate(String resultFormat) {
            return ResultFormatType.valueOf(resultFormat.toUpperCase()).extension;
        }
    }
}
