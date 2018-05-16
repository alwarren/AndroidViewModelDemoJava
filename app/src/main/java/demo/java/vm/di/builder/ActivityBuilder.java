package demo.java.vm.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.java.vm.MainActivity;
import demo.java.vm.di.module.MainActivityModule;

/**
 * Created by Al Warren on 4/15/2018.
 */

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    protected abstract MainActivity bindMainActivity();
}
