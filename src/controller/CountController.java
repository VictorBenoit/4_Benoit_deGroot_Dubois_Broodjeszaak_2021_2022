package controller;

import domain.model.CountModel;
import domain.model.CountObserver;
import view.OrderView;
import view.panels.OrderViewPane;

public class CountController implements CountObserver {
    private CountModel model;
    private OrderViewPane view;
    public CountController(CountModel model) {
        this.model = model;
        model.addObserver(this);
    }
    // Methods called by the view
    public void setView(OrderViewPane view) {
        this.view = view;
    }
    public void incrementButtonPressed() {
        model.updateBy(1);
    }
    public void decrementButtonPressed() {
        model.updateBy(-1);
    }
    // Method called by the model
    public void update(int count) {
        view.setLabel("Count is " + count);
    }
}


