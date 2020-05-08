package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubType {
    private SubtypeObject label1;
    private SubtypeObject label2;
    private SubtypeObject label3;
    private SubtypeObject label4;
    private SubtypeObject label5;
    private SubtypeObject label6;
    private SubtypeObject label7;
    private SubtypeObject label8;
    private SubtypeObject label9;
    private SubtypeObject label10;
    private SubtypeObject label11;
    private SubtypeObject label12;
    private SubtypeObject label13;
@JsonCreator
    public SubType(@JsonProperty("0") SubtypeObject label1,
                   @JsonProperty("132")SubtypeObject label2,
                   @JsonProperty("133")SubtypeObject label3,
                   @JsonProperty("176")SubtypeObject label4,
                   @JsonProperty("201")SubtypeObject label5,
                   @JsonProperty("202")SubtypeObject label6,
                   @JsonProperty("203")SubtypeObject label7,
                   @JsonProperty("204")SubtypeObject label8,
                   @JsonProperty("205")SubtypeObject label9,
                   @JsonProperty("206")SubtypeObject label10,
                   @JsonProperty("207")SubtypeObject label11,
                   @JsonProperty("262")SubtypeObject label12,
                   @JsonProperty("274")SubtypeObject label13) {
        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;
        this.label4 = label4;
        this.label5 = label5;
        this.label6 = label6;
        this.label7 = label7;
        this.label8 = label8;
        this.label9 = label9;
        this.label10 = label10;
        this.label11 = label11;
        this.label12 = label12;
        this.label13 = label13;
    }

    @Override
    public String toString() {
        return "SubType{" +
                "label1=" + label1 +
                ", label2=" + label2 +
                ", label3=" + label3 +
                ", label4=" + label4 +
                ", label5=" + label5 +
                ", label6=" + label6 +
                ", label7=" + label7 +
                ", label8=" + label8 +
                ", label9=" + label9 +
                ", label10=" + label10 +
                ", label11=" + label11 +
                ", label12=" + label12 +
                ", label13=" + label13 +
                '}';
    }

    public SubtypeObject getLabel1() {
        return label1;
    }

    public SubtypeObject getLabel2() {
        return label2;
    }

    public SubtypeObject getLabel3() {
        return label3;
    }

    public SubtypeObject getLabel4() {
        return label4;
    }

    public SubtypeObject getLabel5() {
        return label5;
    }

    public SubtypeObject getLabel6() {
        return label6;
    }

    public SubtypeObject getLabel7() {
        return label7;
    }

    public SubtypeObject getLabel8() {
        return label8;
    }

    public SubtypeObject getLabel9() {
        return label9;
    }

    public SubtypeObject getLabel10() {
        return label10;
    }

    public SubtypeObject getLabel11() {
        return label11;
    }

    public SubtypeObject getLabel12() {
        return label12;
    }

    public SubtypeObject getLabel13() {
        return label13;
    }
}

