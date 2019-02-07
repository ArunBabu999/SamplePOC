package example.com.samplepoc.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.google.gson.Gson;

import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.network.FactsAPIService;
import example.com.samplepoc.utils.NetworkUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class FactsViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    public MutableLiveData<FactsResponse> mFactsResponse;

    public LiveData<FactsResponse> getFacts(FactsAPIService apiService) {
        if (mFactsResponse == null) {
            mFactsResponse = new MutableLiveData<FactsResponse>();
            fetchFactsList(apiService);
        }
        return mFactsResponse;
    }

    private void fetchFactsList(FactsAPIService apiService) {
        Call<FactsResponse> lCal = apiService.getFacts();
        lCal.enqueue(new Callback<FactsResponse>() {
            @Override
            public void onResponse(Call<FactsResponse> call, Response<FactsResponse> response) {
                if (response != null) {
                    Log.d(TAG, "Facts Response:" + new Gson().toJson(response));
                    FactsResponse factResponse = response.body();
                    mFactsResponse.setValue(factResponse);
                }
            }

            @Override
            public void onFailure(Call<FactsResponse> call, Throwable t) {
                Log.d("REQUEST FAILED", " STATUS:" + t.getStackTrace());
            }
        });

    }
}
