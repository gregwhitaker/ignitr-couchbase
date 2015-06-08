package ignitr.couchbase.discovery;

import java.util.List;

public class LocalhostDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "localhost";

    @Override
    public List<String> discoverClusterNodes() {
        return null;
    }
}
