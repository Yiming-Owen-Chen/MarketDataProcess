import reactor.core.publisher.Sinks;

import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;

public class MarketDataProcessor {
    private final Sinks.Many<MarketData> marketDataSinks = Sinks.many().unicast().onBackpressureBuffer();

    public MarketDataProcessor(){
        this.init();
    }

    private void init(){
        marketDataSinks.asFlux()
                .window(Duration.of(1, SECONDS))
                .subscribe(consumer -> consumer
                        .distinct(MarketData::getSymbol)
                        .take(100)
                        .subscribe(this::publishAggregatedMarketData));
    }

    // Receive incoming market data
    public void onMessage(MarketData data) {
        // do something
        marketDataSinks.emitNext(data, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    // do something
    // Publish aggregated and throttled market data
    public void publishAggregatedMarketData(MarketData data) {
        // Do Nothing, assume implemented.
        System.out.println(data.getSymbol() + " " + data.getLast());
    }
}
