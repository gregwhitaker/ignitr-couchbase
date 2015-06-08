package ignitr.couchbase.discovery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PropertyDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "property";

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyDiscoveryStrategy.class);

    @Override
    public List<String> discoverClusterNodes() {
        return null;
    }
}
