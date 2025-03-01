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
package io.aklivity.zilla.runtime.vault.filesystem.config;

import static java.util.function.Function.identity;

public final class FileSystemStoreConfig
{
    public final String store;
    public final String type;
    public final String password;

    public static FileSystemStoreConfigBuilder<FileSystemStoreConfig> builder()
    {
        return new FileSystemStoreConfigBuilder<>(identity());
    }

    FileSystemStoreConfig(
        String store,
        String type,
        String password)
    {
        this.store = store;
        this.type = type;
        this.password = password;
    }
}
