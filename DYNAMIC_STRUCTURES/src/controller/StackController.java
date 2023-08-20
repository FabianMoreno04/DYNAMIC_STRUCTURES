package controller;

import model.StackModel;
import view.StackView;

public class StackController {
    private StackModel model;
    private StackView view;

    public StackController(StackModel model, StackView view) {
        this.model = model;
        this.view = view;
        initView();
    }

    private void initView() {
        view.mostrar(); 
    }

    public double evaluarExpresion(String expression) {
        return model.evaluarExpresion(expression);
    }
    public void setView(StackView view) {
        this.view = view;
        initView(); 
    }

    public static void main(String[] args) {
        StackModel model = new StackModel();
        StackView view = new StackView(null);
        StackController controller = new StackController(model, view);
       
        view.setController(controller);
    }
    
}
