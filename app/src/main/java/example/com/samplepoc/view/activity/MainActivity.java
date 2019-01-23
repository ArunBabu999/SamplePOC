package example.com.samplepoc.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.samplepoc.MyApplication;
import example.com.samplepoc.R;
import example.com.samplepoc.model.FactsModel;
import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.network.FactsAPIService;
import example.com.samplepoc.view.adapter.FactsRecyclerviewAdpater;
import example.com.samplepoc.viewmodel.FactsViewModel;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swipeToRefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    FactsRecyclerviewAdpater mAdapter;
    @Inject
    Retrofit mRetrofit;
    FactsAPIService lFactAPI;
    FactsViewModel factViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((MyApplication) getApplication()).getNetComponent().inject(this);
        lFactAPI = mRetrofit.create(FactsAPIService.class);

        //View Model Logic
        factViewModel = ViewModelProviders.of(this).get(FactsViewModel.class);
        getFactsDataFromAPI(factViewModel, lFactAPI);


        //PullTo Refresh Logic here
        //mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
       // mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.blue);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(true);
                getFactsDataFromAPI(factViewModel, lFactAPI);
            }
        });
    }

    private void getFactsDataFromAPI(FactsViewModel factViewModel, FactsAPIService lFactAPI) {
        factViewModel.getFacts(lFactAPI).observe(this, new Observer<FactsResponse>() {
            @Override
            public void onChanged(@Nullable FactsResponse factsResponse) {
                getSupportActionBar().setTitle(factsResponse.getTitle());
                mAdapter = new FactsRecyclerviewAdpater(MainActivity.this, factsResponse.getRows());
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);
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
