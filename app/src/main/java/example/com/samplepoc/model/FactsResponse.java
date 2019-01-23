package example.com.samplepoc.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FactsResponse {
    @SerializedName("title")
    private String title;
    @SerializedName("rows")
    private List<FactsModel> rows;
}
