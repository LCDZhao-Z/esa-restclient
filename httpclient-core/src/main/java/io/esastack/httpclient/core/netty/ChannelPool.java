/*
 * Copyright 2020 OPPO ESA Stack Project
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
package io.esastack.httpclient.core.netty;

import esa.commons.Checks;
import io.esastack.httpclient.core.config.ChannelPoolOptions;

import java.util.concurrent.atomic.AtomicInteger;

final class ChannelPool {

    final boolean ssl;
    private final io.netty.channel.pool.ChannelPool[] shardingChannelPools;
    final ChannelPoolOptions options;
    private final AtomicInteger idx = new AtomicInteger();
    private final int mask;

    ChannelPool(boolean ssl, io.netty.channel.pool.ChannelPool[] shardingChannelPools, ChannelPoolOptions options) {
        Checks.checkNotNull(shardingChannelPools, "shardingChannelPools");
        Checks.checkNotNull(options, "options");
        this.ssl = ssl;
        this.shardingChannelPools = shardingChannelPools;
        this.mask = shardingChannelPools.length - 1;
        this.options = options;
    }

    io.netty.channel.pool.ChannelPool next() {
        return shardingChannelPools[idx.getAndIncrement() & mask];
    }
}
