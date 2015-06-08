package ignitr.couchbase.discovery;

import com.netflix.config.DynamicPropertyFactory;
import ignitr.couchbase.config.IgnitrCouchbaseConfig;
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
                IgnitrCouchbaseConfig.DISCOVERY_STRATEGY_PROPERTY, EurekaDiscoveryStrategy.NAME).get();

        if (strategy.equalsIgnoreCase(EurekaDiscoveryStrategy.NAME)) {
            LOGGER.debug("Creating EurekaDiscoveryStrategy");
            return new EurekaDiscoveryStrategy();
        } else if (strategy.equalsIgnoreCase(PropertyDiscoveryStrategy.NAME)) {
            LOGGER.debug("Creating PropertyDiscoveryStrategy");
            return new PropertyDiscoveryStrategy();
        } else {
            // Invalid discovery strategy was specified
            throw new RuntimeException();
        }
    }
}
