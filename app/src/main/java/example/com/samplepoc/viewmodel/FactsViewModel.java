package example.com.samplepoc.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import example.com.samplepoc.model.FactsModel;
import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.network.FactsAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FactsViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<FactsModel>> mFactsList;

    public LiveData<List<FactsModel>> getFacts(FactsAPIService apiService) {
        if (mFactsList == null) {
            mFactsList = new MutableLiveData<List<FactsModel>>();
            fetchFactsList(apiService);
        }
        return mFactsList;
    }

    private void fetchFactsList(FactsAPIService apiService) {
        Call<FactsResponse> lCal = apiService.getFacts();
        lCal.enqueue(new Callback<FactsResponse>() {
            @Override
            public void onResponse(Call<FactsResponse> call, Response<FactsResponse> response) {
                if (response != null) {
                    Log.d("ARUN","RESPONSE:"+ new Gson().toJson(response));
                    FactsResponse factResponse = response.body();
                    mFactsList.setValue(factResponse.getRows());
                }
            }

            @Override
            public void onFailure(Call<FactsResponse> call, Throwable t) {
                Log.d("REQUEST FAILED", " STATUS:" + t.getStackTrace());
            }
        });

    }
}