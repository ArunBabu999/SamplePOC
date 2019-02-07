package example.com.samplepoc;

import javax.inject.Singleton;

import dagger.Component;
import example.com.samplepoc.view.activity.MainActivity;

@Singleton
@Component(modules = {
    example.com.samplepoc.AppModule.class, example.com.samplepoc.ApiModule.class
})
public interface ApiComponent {
  void inject(MainActivity activity);
}
