/*
 * Copyright 2015 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ignitr.couchbase.discovery;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LocalDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "local";

    private static final String LOCALHOST = "127.0.0.1";

    @Override
    public List<String> discoverClusterNodes() {
        List<String> nodes = new ArrayList<>(1);
        nodes.add(LOCALHOST);

        return nodes;
    }
}
