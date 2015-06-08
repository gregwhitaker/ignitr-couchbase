package ignitr.couchbase.discovery;

import org.junit.Test;

public class IgnitrDiscoveryStrategyFactoryTest {

    @Test
    public void shouldReturnPropertyDiscoveryStrategy() {
        IgnitrDiscoveryStrategy strategy = IgnitrDiscoveryStrategyFactory.getInstance();
    }

    @Test
    public void shouldReturnEurekaDiscoveryStrategy() {
        IgnitrDiscoveryStrategy strategy = IgnitrDiscoveryStrategyFactory.getInstance();
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenInvalidStrategy() {
        IgnitrDiscoveryStrategy strategy = IgnitrDiscoveryStrategyFactory.getInstance();
    }
}
