package demo.java.vm.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import demo.java.vm.domain.Hello;
import timber.log.Timber;

/**
 * Created by Al Warren on 4/15/2018.
 */

public class HelloViewModel extends ViewModel {
    // observed by ViewModel as a trigger to retrieve data from the source
    private MutableLiveData<String> liveTrigger = new MutableLiveData<>();

    // observed by Activity/Fragment or some other class as a trigger to do something with the data
    private LiveData<String> liveData;

    @Inject
    HelloViewModel(Hello dataSource) {
        // default observable trigger
        liveTrigger.setValue(dataSource.defaultText());

        // observe liveTrigger and reload observable liveData when trigger changes
        liveData = Transformations.switchMap(liveTrigger, dataSource::fetchData);
    }

    // changing liveTrigger's value causes Transformations.switchMap to send a value to the Hello
    // model where it's live value is updated. Hello model returns it's live data which replaces the
    // ViewModel's live data. MainActivity's observer sees the change and updates it's UI
    // with the new value.
    public void setData(String value) {
        Timber.d("---> Updating the ViewModel with " + value);
        liveTrigger.setValue(value);
    }

    // retrieve the observable data
    public LiveData<String> getData() {
        return liveData;
    }
}
