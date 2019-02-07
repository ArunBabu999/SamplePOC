package example.com.samplepoc;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import example.com.samplepoc.view.adapter.FactsRecyclerviewAdpater;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {
  @Mock
  RecyclerView mRecyclerView;
  @Mock
  FactsRecyclerviewAdpater mAdapter;
  @Mock
  public LinearLayoutManager mLayoutManager;
  @Mock
  Activity mActivity;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    when(mRecyclerView.getLayoutManager()).thenReturn(mLayoutManager);
    when(mRecyclerView.getContext()).thenReturn(mActivity);
  }

  @Test
  public void testSetAdapter() {
    verify(mRecyclerView).setAdapter(mAdapter);
  }
}
