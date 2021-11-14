package info.fareez.counter.state;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class CounterStore {

    private static CounterStore _store;

    private BehaviorSubject<Integer> count = BehaviorSubject.createDefault(0);

    private CounterStore() {
    }

    public static CounterStore getStore() {
        if (_store == null) {
            _store = new CounterStore();
        }
        return _store;
    }

    public void setCount(int count) {
        this.count.onNext(count);
    }

    public BehaviorSubject<Integer> getCount() {
        return count;
    }

    public void incrementCount() {
        if (this.count.getValue() == null) {
            this.count.onNext(0);
        } else {
            this.count.onNext(this.count.getValue() + 1);
        }
    }
}
