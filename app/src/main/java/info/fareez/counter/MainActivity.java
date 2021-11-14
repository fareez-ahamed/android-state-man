package info.fareez.counter;

import androidx.appcompat.app.AppCompatActivity;
import info.fareez.counter.state.CounterStore;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CounterStore counterStore;

    public MainActivity() {
        super();
        this.counterStore = CounterStore.getStore();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.counterStore.onCountChange(count -> {
            TextView v = (TextView) findViewById(R.id.counterTxt);
            v.setText(Integer.toString(count));
        });

    }

    public void increment(View view) {
        this.counterStore.incrementCount();
    }
}