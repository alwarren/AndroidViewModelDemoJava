package demo.java.vm.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import demo.java.vm.App;
import demo.java.vm.di.builder.ActivityBuilder;
import demo.java.vm.di.builder.ViewModelBuilders;
import demo.java.vm.di.module.AppModule;
import demo.java.vm.di.module.MainActivityModule;

/**
 * Created by Al Warren on 4/15/2018.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class,
        ViewModelBuilders.class, ActivityBuilder.class, MainActivityModule.class})
interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {}
}