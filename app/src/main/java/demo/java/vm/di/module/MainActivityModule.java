package demo.java.vm.di.module;

import android.arch.lifecycle.ViewModel;

import dagger.Module;
import dagger.Provides;
import demo.java.vm.data.HelloViewModel;
import demo.java.vm.domain.Hello;

/**
 * Created by Al Warren on 4/15/2018.
 */

@Module
public class MainActivityModule {
    @Provides
    public Hello provideHello() {
        return new Hello();
    }

    @Provides
    public ViewModel provideHelloViewModel(HelloViewModel viewModel) {
        return viewModel;
    }
}
