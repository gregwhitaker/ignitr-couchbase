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
                IgnitrCouchbaseConfig.DISCOVERY_STRATEGY_PROP, EurekaDiscoveryStrategy.NAME).get();

        switch (strategy.toLowerCase()) {
            case EurekaDiscoveryStrategy.NAME:
                LOGGER.debug("Creating EurekaDiscoveryStrategy");
                return new EurekaDiscoveryStrategy();
            case PropertyDiscoveryStrategy.NAME:
                LOGGER.debug("Creating EurekaDiscoveryStrategy");
                return new PropertyDiscoveryStrategy();
            case LocalhostDiscoveryStrategy.NAME:
                LOGGER.debug("Creating LocalhostDiscoveryStrategy");
                return new LocalhostDiscoveryStrategy();
            default:
                throw new RuntimeException("Invalid discovery strategy");
        }
    }
}
