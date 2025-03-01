/*
 * Copyright 2021-2024 Aklivity Inc.
 *
 * Aklivity licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.aklivity.zilla.runtime.engine.test.internal.exporter;

import java.util.List;
import java.util.function.LongFunction;

import io.aklivity.zilla.runtime.engine.EngineContext;
import io.aklivity.zilla.runtime.engine.config.AttributeConfig;
import io.aklivity.zilla.runtime.engine.config.ExporterConfig;
import io.aklivity.zilla.runtime.engine.config.KindConfig;
import io.aklivity.zilla.runtime.engine.exporter.ExporterContext;
import io.aklivity.zilla.runtime.engine.exporter.ExporterHandler;
import io.aklivity.zilla.runtime.engine.metrics.Collector;

public class TestExporterContext implements ExporterContext
{
    private final EngineContext context;

    public TestExporterContext(
        EngineContext context)
    {
        this.context = context;
    }

    @Override
    public ExporterHandler attach(
        ExporterConfig exporter,
        List<AttributeConfig> attributes,
        Collector collector,
        LongFunction<KindConfig> resolveKind)
    {
        return new TestExporterHandler(context, exporter);
    }

    @Override
    public void detach(
        long exporterId)
    {
    }
}
