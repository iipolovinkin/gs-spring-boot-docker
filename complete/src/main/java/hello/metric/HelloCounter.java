package hello.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public final class HelloCounter {
    private final Counter successCounter;

    public HelloCounter(MeterRegistry meterRegistry) {
        successCounter = Counter.builder("hello_success")
                .description("Number of successful requests")
                .register(meterRegistry);

    }

    public void incSuccess() {
        successCounter.increment();
    }

}
