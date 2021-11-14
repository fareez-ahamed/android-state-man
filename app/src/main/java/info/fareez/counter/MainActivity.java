package info.fareez.counter;

import androidx.appcompat.app.AppCompatActivity;
import info.fareez.counter.state.CounterStore;
import io.reactivex.rxjava3.disposables.Disposable;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final CounterStore counterStore;

    private Disposable _countDisposable;

    public MainActivity() {
        super();
        this.counterStore = CounterStore.getStore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _countDisposable = this.counterStore.getCount().subscribe(count -> {
            TextView v = findViewById(R.id.counterTxt);
            v.setText(Integer.toString(count));
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _countDisposable.dispose();
    }

    public void increment(View view) {
        this.counterStore.incrementCount();
    }
}