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
import com.netflix.appinfo.AmazonInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.shared.Application;
import ignitr.couchbase.exception.IgnitrCouchbaseException;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Discovery strategy that uses <a href="https://github.com/Netflix/eureka">Netflix's Eureka</a> to discover Couchbase cluster nodes.
 */
public class EurekaDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "eureka";

    private static final String PROP_EUREKA_APP_ID = "ignitr.couchbase.discovery.eureka.appid";

    @Override
    public List<String> discoverClusterNodes() {
        String appId = DynamicPropertyFactory.getInstance().getStringProperty(PROP_EUREKA_APP_ID, null).get();

        if (appId == null) {
            throw new IgnitrCouchbaseException(String.format("Discovery strategy 'eureka' specified, but no application " +
                    " identifier is configured in '%s' property!", PROP_EUREKA_APP_ID));
        }

        Application application = DiscoveryManager.getInstance().getDiscoveryClient().getApplication(appId);

        return Lists.transform(application.getInstancesAsIsFromEureka(), new Function<InstanceInfo, String>() {
            @Nullable
            @Override
            public String apply(@Nullable InstanceInfo input) {
                if (input != null) {
                    String localIpAddress = input.getIPAddr();

                    if (input.getDataCenterInfo() instanceof AmazonInfo) {
                        AmazonInfo amazonInfo = (AmazonInfo) input.getDataCenterInfo();
                        localIpAddress = amazonInfo.get(AmazonInfo.MetaDataKey.localIpv4);
                    }

                    return localIpAddress;
                }

                return null;
            }
        });
    }
}
