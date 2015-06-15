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

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.netflix.config.DynamicPropertyFactory;
import ignitr.couchbase.exception.IgnitrCouchbaseException;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class ConfigDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "config";

    private static final String PROP_CONFIG_NODES = "ignitr.couchbase.discovery.config.nodes";

    @Override
    public List<String> discoverClusterNodes() {
        String propertyValue = DynamicPropertyFactory.getInstance().getStringProperty(PROP_CONFIG_NODES, null).get();

        if (StringUtils.isNotEmpty(propertyValue)) {
            return Lists.transform(Arrays.asList(propertyValue.split(",")), new Function<String, String>() {
                @Nullable
                @Override
                public String apply(String input) {
                    return input.trim();
                }
            });
        } else {
            throw new IgnitrCouchbaseException(String.format("Discovery strategy 'config' specified, but no nodes were " +
                    "configured in '%s' property!", PROP_CONFIG_NODES));
        }
    }
}
