package ignitr.couchbase.discovery;

import com.netflix.config.DynamicPropertyFactory;
import ignitr.couchbase.config.IgnitrConfigurationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class IgnitrDiscoveryStrategyFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(IgnitrDiscoveryStrategyFactory.class);

    /**
     *
     * @return
     */
    public static IgnitrDiscoveryStrategy getInstance() {
        String strategy = DynamicPropertyFactory.getInstance().getStringProperty(
                IgnitrConfigurationProperties.PROPERTY_DISCOVERY_STRATEGY, EurekaDiscoveryStrategy.NAME).get();

        switch (strategy.toLowerCase()) {
            case EurekaDiscoveryStrategy.NAME:
                LOGGER.debug("Creating EurekaDiscoveryStrategy");
                return new EurekaDiscoveryStrategy();
            case ConfigDiscoveryStrategy.NAME:
                LOGGER.debug("Creating ConfigDiscoveryStrategy");
                return new ConfigDiscoveryStrategy();
            case LocalDiscoveryStrategy.NAME:
                LOGGER.debug("Creating LocalDiscoveryStrategy");
                return new LocalDiscoveryStrategy();
            default:
                throw new RuntimeException("Invalid discovery strategy");
        }
    }
}
