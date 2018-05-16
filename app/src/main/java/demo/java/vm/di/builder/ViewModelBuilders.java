package demo.java.vm.di.builder;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import demo.java.vm.data.CustomViewModelFactory;
import demo.java.vm.data.HelloViewModel;
import demo.java.vm.data.ViewModelKey;

/**
 * Created by Al Warren on 4/15/2018.
 */

@Module
public abstract class ViewModelBuilders {
    @Binds
    protected abstract ViewModelProvider.Factory bindFactory(CustomViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(HelloViewModel.class)
    protected abstract ViewModel bindHelloViewModel(HelloViewModel viewModel);
}
