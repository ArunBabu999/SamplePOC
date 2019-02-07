package example.com.samplepoc;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import example.com.samplepoc.model.FactsResponse;
import example.com.samplepoc.viewmodel.FactsViewModel;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
  @Test
  public void useAppContext() {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();
    assertEquals("example.com.samplepoc", appContext.getPackageName());
  }

  @Test
  public void testSucessScenario() {
    onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));
  }

  @Test
  public void testErrorScenario() {
  }
}
