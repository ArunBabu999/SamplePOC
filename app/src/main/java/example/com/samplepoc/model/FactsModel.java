package example.com.samplepoc.model;

import com.google.gson.annotations.SerializedName;

public class FactsModel {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("imageHref")
    private String imageHref;
}
