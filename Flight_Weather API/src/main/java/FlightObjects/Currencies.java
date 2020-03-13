package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Currencies {
    private char decimalSeparator;
    private char thousandsSeparator;
    private boolean symbolOnLeft;
    private boolean spaceBetweenAmountAndSymbol;
    private char symbol;
    private int decimalDigits;
    private String code;
    private int roundingCoefficient;

    @JsonCreator
    public Currencies(@JsonProperty("DecimalSeparator")char decimalSeparator,
                      @JsonProperty("ThousandsSeparator") char thousandsSeparator,
                      @JsonProperty("SymbolOnLeft") boolean symbolOnLeft,
                      @JsonProperty("SpaceBetweenAmountAndSymbol") boolean spaceBetweenAmountAndSymbol,
                      @JsonProperty("Symbol") char symbol,
                      @JsonProperty("DecimalDigits") int decimalDigits,
                      @JsonProperty("Code") String code,
                      @JsonProperty("RoundingCoefficient")int roundingCoefficient) {
        this.decimalSeparator = decimalSeparator;
        this.thousandsSeparator = thousandsSeparator;
        this.symbolOnLeft = symbolOnLeft;
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
        this.symbol = symbol;
        this.decimalDigits = decimalDigits;
        this.code = code;
        this.roundingCoefficient = roundingCoefficient;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "decimalSeparator=" + decimalSeparator +
                ", thousandsSeparator=" + thousandsSeparator +
                ", symbolOnLeft=" + symbolOnLeft +
                ", spaceBetweenAmountAndSymbol=" + spaceBetweenAmountAndSymbol +
                ", symbol=" + symbol +
                ", decimalDigits=" + decimalDigits +
                ", code='" + code + '\'' +
                ", roundingCoefficient=" + roundingCoefficient +
                '}';
    }

    public char getDecimalSeparator() {
        return decimalSeparator;
    }

    public char getThousandsSeparator() {
        return thousandsSeparator;
    }

    public boolean isSymbolOnLeft() {
        return symbolOnLeft;
    }

    public boolean isSpaceBetweenAmountAndSymbol() {
        return spaceBetweenAmountAndSymbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public String getCode() {
        return code;
    }

    public int getRoundingCoefficient() {
        return roundingCoefficient;
    }
}
