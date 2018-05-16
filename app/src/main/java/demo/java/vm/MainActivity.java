package demo.java.vm;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import demo.java.vm.data.HelloViewModel;
import demo.java.vm.domain.Hello;
import demo.java.vm.ui.TextInputDialog;
import timber.log.Timber;

public class MainActivity extends DaggerAppCompatActivity implements TextInputDialog.OnTextResult {
    @Inject Hello hello;
    @Inject ViewModelProvider.Factory factory;

    private TextView helloText;
    private HelloViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("---> onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        viewModel = ViewModelProviders.of(this, factory).get(HelloViewModel.class);

        // Observe the ViewModel's live data. WHen it changes, update the UI with the new value.
        // Watch the log to see when data is actually retrieved from the model. You'll notice that
        // on rotation, the UI is updated with the value from the view model but no call is made
        // to the Hello model.
        viewModel.getData().observe(this, this::updateUI);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("---> onResume()");
    }

    private void bindViews() {
        helloText = findViewById(R.id.textHello);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton buttonHello = findViewById(R.id.buttonHello);
        buttonHello.setOnClickListener(v ->
                new TextInputDialog(this, R.string.app_name).build().show());
    }

    @Override
    public void onTextDialogResult(String input) {
        Timber.d("---> Sending Dialog result to the ViewModel");
        viewModel.setData(input);
    }

    private void updateUI(String data) {
        Timber.d("---> Updating UI from the ViewModel");
        helloText.setText(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // reset the ViewModel's live data with default text from the Hello model
        if (id == R.id.action_reset) {
            onTextDialogResult(hello.defaultText());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
