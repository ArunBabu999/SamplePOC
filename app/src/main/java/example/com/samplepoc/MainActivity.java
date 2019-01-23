package example.com.samplepoc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import javax.inject.Inject;

import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.network.FactsAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ((MyApplication) getApplication()).getNetComponent().inject(this);
        getFacts();
    }

    private void getFacts(){

        FactsAPIService lFactAPI = mRetrofit.create(FactsAPIService.class);
        Call<FactsResponse> lCal = lFactAPI.getFacts();
        lCal.enqueue(new Callback<FactsResponse>() {
            @Override
            public void onResponse(Call<FactsResponse> call, Response<FactsResponse> response) {
                FactsResponse factsResponse= response.body();
                Log.d("Arun","Response::"+ new Gson().toJson(factsResponse));
            }

            @Override
            public void onFailure(Call<FactsResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
