package LocationObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    private Search_explanations search_explanations;
    private String result_type;
    private Result_object result_object;
    private String scope;

    @JsonCreator
    public Data(@JsonProperty("search_explanations") Search_explanations search_explanations,
                @JsonProperty("result_type") String result_type,
                @JsonProperty("result_object") Result_object result_object,
                @JsonProperty("scope") String scope
    ) {
        this.search_explanations = search_explanations;
        this.result_type = result_type;
        this.result_object = result_object;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Data{" +
                "search_explanations=" + search_explanations +
                ", result_type='" + result_type + '\'' +
                ", result_object=" + result_object +
                ", scope='" + scope + '\'' +
                '}';
    }

    public Search_explanations getSearch_explanations() {
        return search_explanations;
    }

    public String getResult_type() {
        return result_type;
    }

    public Result_object getResult_object() {
        return result_object;
    }

    public String getScope() {
        return scope;
    }

}
