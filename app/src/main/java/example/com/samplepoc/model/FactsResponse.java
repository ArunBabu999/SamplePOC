package example.com.samplepoc.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FactsResponse {

    @SerializedName("title")
    private String title;
    @SerializedName("rows")
    private List<FactsModel> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FactsModel> getRows() {
        return rows;
    }

    public void setRows(List<FactsModel> rows) {
        this.rows = rows;
    }
}
