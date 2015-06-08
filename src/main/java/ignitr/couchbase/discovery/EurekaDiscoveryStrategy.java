package ignitr.couchbase.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EurekaDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "eureka";
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaDiscoveryStrategy.class);

    @Override
    public List<String> discoverClusterNodes() {
        return null;
    }
}
