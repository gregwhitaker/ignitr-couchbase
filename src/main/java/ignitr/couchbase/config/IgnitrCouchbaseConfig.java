package ignitr.couchbase.config;

import com.netflix.governator.annotations.AutoBindSingleton;

@AutoBindSingleton
public class IgnitrCouchbaseConfig {

    /**
     *
     */
    public static final String DISCOVERY_STRATEGY_PROP = "ignitr.couchbase.discovery.strategy";

    // Property Discovery Strategy Properties

    /**
     *
     */
    public static final String DISCOVERY_STRATEGY_PROPERTY_NODES_PROP = "ignitr.couchbase.discovery.strategy.property.nodes";

    // Eureka Discovery Strategy Properties
}
