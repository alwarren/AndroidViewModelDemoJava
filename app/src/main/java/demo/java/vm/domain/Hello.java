package demo.java.vm.domain;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import timber.log.Timber;

/**
 * Created by Al Warren on 4/15/2018.
 */

public class Hello {
    private Hello(String text) {
        this.text = text;
    }

    public Hello() {
        this("Hello from the Model!!!");
    }

    private String text;

    private MutableLiveData<String> liveData = new MutableLiveData<>();

    public String defaultText() {
        return this.text;
    }

    public LiveData<String> fetchData(String value) {
        Timber.d("---> Setting data in the Hello model");
        liveData.setValue(value);
        return liveData;
    }
}
