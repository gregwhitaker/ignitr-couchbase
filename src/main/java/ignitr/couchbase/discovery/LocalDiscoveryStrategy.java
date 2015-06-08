package ignitr.couchbase.discovery;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LocalDiscoveryStrategy implements IgnitrDiscoveryStrategy {
    public static final String NAME = "local";

    @Override
    public List<String> discoverClusterNodes() {
        List<String> nodes = new ArrayList<>(1);
        nodes.add("127.0.0.1");

        return nodes;
    }
}
