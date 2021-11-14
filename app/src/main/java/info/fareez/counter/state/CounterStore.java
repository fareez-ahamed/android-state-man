package info.fareez.counter.state;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;

public class CounterStore {

    private static CounterStore _store;

    private int count = 0;

    private List<CountChangeListener> countChangeListeners;

    private CounterStore() {
        this.countChangeListeners = new ArrayList<CountChangeListener>();
    }

    public static CounterStore getStore() {
        if(_store == null) {
            _store = new CounterStore();
        }
        return _store;
    }

    public void setCount(int count) {
        this.count = count;
        for (CountChangeListener l: this.countChangeListeners) {
            l.onChange(this.getCount());
        }
    }

    public int getCount() {
        return count;
    }

    public void onCountChange(CountChangeListener r) {
        this.countChangeListeners.add(r);
    }

    public void incrementCount () {
        this.setCount(this.getCount() + 5);
    }
}
