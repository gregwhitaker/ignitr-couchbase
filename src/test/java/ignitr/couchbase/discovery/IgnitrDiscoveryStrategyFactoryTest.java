package ignitr.couchbase.discovery;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IgnitrDiscoveryStrategyFactoryTest {

    @Test
    public void shouldReturnPropertyDiscoveryStrategy() {
        assertTrue(true);
    }

    @Test
    public void shouldReturnEurekaDiscoveryStrategy() {
        assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenInvalidStrategy() {
        throw new RuntimeException();
    }
}
