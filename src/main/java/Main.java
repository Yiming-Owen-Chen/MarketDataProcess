import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MarketDataProcessor processor = new MarketDataProcessor();

        TimeUnit.SECONDS.sleep(1);

        for(int i=0; i<1000; i++){
            processor.onMessage(new MarketData("ABC", 1, 2,i+1, LocalDateTime.now()));
            processor.onMessage(new MarketData("XYZ", 1, 2,i+1, LocalDateTime.now()));
        }
        TimeUnit.SECONDS.sleep(1);
        for(int i=0; i<1000; i++){
            processor.onMessage(new MarketData("ABC", 1, 2,i+100, LocalDateTime.now()));
            processor.onMessage(new MarketData("XYZ", 1, 2,i+100, LocalDateTime.now()));
        }
    }
}
