/*
 * Copyright 2021-2021 Aklivity Inc.
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
package io.aklivity.zilla.runtime.cog.tls.internal.vault;

import java.net.URL;
import java.util.function.Function;

import io.aklivity.zilla.runtime.cog.tls.internal.vault.config.FileSystemOptions;
import io.aklivity.zilla.runtime.engine.cog.Axle;
import io.aklivity.zilla.runtime.engine.cog.AxleContext;
import io.aklivity.zilla.runtime.engine.cog.Configuration;
import io.aklivity.zilla.runtime.engine.cog.vault.BindingVault;
import io.aklivity.zilla.runtime.engine.config.Vault;

final class FileSystemAxle implements Axle
{
    private final Function<String, URL> resolvePath;

    FileSystemAxle(
        Configuration config,
        AxleContext context)
    {
        this.resolvePath = context::resolvePath;
    }

    @Override
    public BindingVault attach(
        Vault vault)
    {
        FileSystemOptions fsOptions = (FileSystemOptions) vault.options;
        return new FileSystemVault(fsOptions, resolvePath);
    }
}
