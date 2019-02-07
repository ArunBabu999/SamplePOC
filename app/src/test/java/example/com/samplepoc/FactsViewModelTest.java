package example.com.samplepoc;

import android.arch.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.network.FactsAPIService;
import example.com.samplepoc.viewmodel.FactsViewModel;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FactsViewModelTest {
  FactsViewModel viewModel;
  @Mock
  FactsAPIService apiService;
  @Mock
  MutableLiveData<FactsResponse> factsResponse;

  @Before
  public void setup() {
    viewModel = new FactsViewModel();
    viewModel.mFactsResponse = factsResponse;
  }

  @Test
  public void testGetFacts() {
    assertEquals(viewModel.getFacts(apiService), factsResponse);
  }
}
