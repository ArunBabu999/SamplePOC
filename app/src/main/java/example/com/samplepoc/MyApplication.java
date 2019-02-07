package example.com.samplepoc;

import android.app.Application;

import example.com.samplepoc.constant.Constants;

public class MyApplication extends Application {
  private example.com.samplepoc.ApiComponent mApiComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApiComponent = DaggerApiComponent.builder()
        .appModule(new example.com.samplepoc.AppModule(this))
        .apiModule(new example.com.samplepoc.ApiModule(Constants.BASE_URL))
        .build();
  }

  public example.com.samplepoc.ApiComponent getNetComponent() {
    return mApiComponent;
  }
}
