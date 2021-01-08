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
package esa.httpclient.core.metrics;

import java.util.List;

public interface IoThreadGroupMetric {

    /**
     * Whether current group is shutdown or not.
     *
     * @return shutdown or not
     */
    boolean isShutdown();

    /**
     * Whether current group is terminated or not.
     *
     * @return terminated or not
     */
    boolean isTerminated();

    /**
     * Obtains the {@link IoThreadMetric}.
     *
     * @return ioThread metric
     */
    List<IoThreadMetric> childExecutors();

    /**
     * Obtains the id of current thread group.
     *
     * @return identify
     */
    String groupId();

}
