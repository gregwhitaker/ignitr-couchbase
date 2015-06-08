package ignitr.couchbase.discovery;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.netflix.config.DynamicPropertyFactory;
import ignitr.couchbase.config.IgnitrConfigurationProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class ConfigDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "config";

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigDiscoveryStrategy.class);

    @Override
    public List<String> discoverClusterNodes() {
        String propertyValue = DynamicPropertyFactory.getInstance().getStringProperty(
                IgnitrConfigurationProperties.PROPERTY_CONFIG_NODES, null).get();

        if (StringUtils.isNotEmpty(propertyValue)) {
            return Lists.transform(Arrays.asList(propertyValue.split(",")), new Function<String, String>() {
                @Nullable
                @Override
                public String apply(String input) {
                    return input.trim();
                }
            });
        } else {
            LOGGER.warn("Discovery strategy 'config' specified, but no nodes were configured in '{}' property!",
                    IgnitrConfigurationProperties.PROPERTY_CONFIG_NODES);
            return Lists.newArrayList();
        }
    }
}
