package ignitr.couchbase.discovery;

import java.util.List;

/**
 *
 */
public interface IgnitrDiscoveryStrategy {

    /**
     *
     * @return
     */
    List<String> discoverClusterNodes();
}
