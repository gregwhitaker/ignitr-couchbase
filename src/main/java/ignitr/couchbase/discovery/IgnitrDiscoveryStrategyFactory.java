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

import com.netflix.config.DynamicPropertyFactory;
import ignitr.couchbase.config.IgnitrConfigProperties;
import ignitr.couchbase.exception.IgnitrCouchbaseException;

/**
 *
 */
public class IgnitrDiscoveryStrategyFactory {

    /**
     *
     * @return
     */
    public static IgnitrDiscoveryStrategy getInstance() {
        String strategy = DynamicPropertyFactory.getInstance().getStringProperty(
                IgnitrConfigProperties.PROP_DISCOVERY_STRATEGY, EurekaDiscoveryStrategy.NAME).get();

        switch (strategy.toLowerCase()) {
            case EurekaDiscoveryStrategy.NAME:
                return new EurekaDiscoveryStrategy();
            case ConfigDiscoveryStrategy.NAME:
                return new ConfigDiscoveryStrategy();
            case LocalDiscoveryStrategy.NAME:
                return new LocalDiscoveryStrategy();
            default:
                throw new IgnitrCouchbaseException(String.format("Discovery strategy '%s' is invalid.", strategy));
        }
    }
}
