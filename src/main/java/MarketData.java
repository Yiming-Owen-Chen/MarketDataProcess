import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public class MarketData {
    private String symbol;
    private double bid;
    private double ask;
    private double last;
    private LocalDateTime updateTime;

    public MarketData(String symbol, double bid, double ask, double last, LocalDateTime updateTime) {
        this.symbol = symbol;
        this.bid = bid;
        this.ask = ask;
        this.last = last;
        this.updateTime = updateTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getLast() {
        return last;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
}
