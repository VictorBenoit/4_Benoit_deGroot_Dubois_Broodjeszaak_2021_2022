package domain.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.Collection;

public class CountModel implements Observable {
    private int count = 0;
    private Collection<CountObserver> observers  = new ArrayList<>();
    public void addObserver(CountObserver obs) {
        observers.add(obs);
    }
    private void notifyObservers(int count) {
        for (CountObserver obs : observers)
            obs.update(count);
    }
    public void updateBy(int n) {
        count += n;
        notifyObservers(count);
    }
    public int getCount() {
        return count;
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}

