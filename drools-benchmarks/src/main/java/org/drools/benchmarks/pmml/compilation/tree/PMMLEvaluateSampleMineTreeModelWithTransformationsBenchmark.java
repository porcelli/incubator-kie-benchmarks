/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
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

package org.drools.benchmarks.pmml.compilation.tree;

import org.drools.benchmarks.common.AbstractBenchmark;
import org.drools.benchmarks.common.ProviderException;
import org.kie.api.pmml.PMML4Result;
import org.kie.api.pmml.PMMLRequestData;
import org.kie.memorycompiler.KieMemoryCompiler;
import org.kie.pmml.api.runtime.PMMLRuntime;
import org.kie.pmml.api.runtime.PMMLRuntimeContext;
import org.kie.pmml.evaluator.core.PMMLRuntimeContextImpl;
import org.kie.pmml.evaluator.core.service.PMMLRuntimeInternalImpl;
import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.drools.benchmarks.pmml.util.PMMLUtil.compileModel;
import static org.drools.benchmarks.pmml.util.PMMLUtil.getPMMLFile;

@State(Scope.Benchmark)
@Warmup(iterations = 300)
@Measurement(iterations = 50)
public class PMMLEvaluateSampleMineTreeModelWithTransformationsBenchmark extends AbstractBenchmark {

    public static final String FILE_NAME_NO_SUFFIX = "SampleMineTreeModelWithTransformations";
    public static final String FILE_NAME = FILE_NAME_NO_SUFFIX + ".pmml";
    public static final String FILE_PATH = "pmml/" + FILE_NAME;

    private static final File pmmlFile;

    static {
        // Retrieve pmmlFile
        pmmlFile = getPMMLFile(FILE_PATH);
    }

    @Setup
    public void setupResource() throws IOException {
        // noop
    }

    @Override
    public void setup() throws ProviderException {
        // noop
    }

    @Benchmark
    public KieMemoryCompiler.MemoryCompilerClassLoader evaluatePrediction() {
        return compileModel(pmmlFile);
    }
}
