package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
    private String symbol;
    private String code;
@JsonCreator
    public Currency(@JsonProperty("Symbol") String symbol,
                    @JsonProperty("Code") String code) {
        this.symbol = symbol;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "symbol='" + symbol + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }
}
