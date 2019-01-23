package example.com.samplepoc.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import example.com.samplepoc.MyApplication;
import example.com.samplepoc.R;
import example.com.samplepoc.model.FactsModel;
import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.network.FactsAPIService;
import example.com.samplepoc.view.adapter.FactsRecyclerviewAdpater;
import example.com.samplepoc.viewmodel.FactsViewModel;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FactsRecyclerviewAdpater mAdapter;
    @Inject Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(toolbar);
        ((MyApplication) getApplication()).getNetComponent().inject(this);

        FactsAPIService lFactAPI = mRetrofit.create(FactsAPIService.class);

        FactsViewModel factViewModel = ViewModelProviders.of(this).get(FactsViewModel.class);
        factViewModel.getFacts(lFactAPI).observe(this, new Observer<FactsResponse>() {
            @Override
            public void onChanged(@Nullable FactsResponse factsResponse) {
                getSupportActionBar().setTitle(factsResponse.getTitle());
                mAdapter = new FactsRecyclerviewAdpater(MainActivity.this, factsResponse.getRows());
                recyclerView.setAdapter(mAdapter);
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
