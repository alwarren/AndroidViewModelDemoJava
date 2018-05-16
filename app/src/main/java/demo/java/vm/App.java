package demo.java.vm;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import demo.java.vm.di.component.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by Al Warren on 4/15/2018.
 */

public class App extends DaggerApplication {
    @Override public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
