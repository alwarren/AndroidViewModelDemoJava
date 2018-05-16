package demo.java.vm.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Al Warren on 4/15/2018.
 */

@Module
public class AppModule {
    @Provides
    @Singleton
    public Context provideContext(Application application) {
        return application;
    }
}
