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
package io.aklivity.zilla.specs.binding.mqtt.streams.application;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import io.aklivity.k3po.runtime.junit.annotation.Specification;
import io.aklivity.k3po.runtime.junit.rules.K3poRule;

public class UnsubscribeIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("app", "io/aklivity/zilla/specs/binding/mqtt/streams/application");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${app}/unsubscribe.after.subscribe/client",
        "${app}/unsubscribe.after.subscribe/server"})
    public void shouldAcknowledge() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/unsubscribe.aggregated.topic.filters.both.exact/client",
        "${app}/unsubscribe.aggregated.topic.filters.both.exact/server"})
    public void shouldAcknowledgeAggregatedTopicFiltersBothExact() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/unsubscribe.topic.filter.single/client",
        "${app}/unsubscribe.topic.filter.single/server"})
    public void shouldAcknowledgeSingleTopicFilters() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/unsubscribe.publish.unfragmented/client",
        "${app}/unsubscribe.publish.unfragmented/server"})
    public void shouldAcknowledgeAndPublishUnfragmented() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/unsubscribe.topic.filters.non.successful/client",
        "${app}/unsubscribe.topic.filters.non.successful/server"})
    public void shouldAcknowledgeNonSuccessful() throws Exception
    {
        k3po.finish();
    }
}
