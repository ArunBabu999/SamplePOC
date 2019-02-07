package example.com.samplepoc.network;

import example.com.samplepoc.model.FactsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FactsAPIService {

  @GET("s/2iodh4vg0eortkl/facts.json")
  Call<FactsResponse> getFacts();
}
