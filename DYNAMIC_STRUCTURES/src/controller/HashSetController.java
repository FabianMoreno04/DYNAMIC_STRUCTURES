package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import model.HashSetModel;
import view.HashSetView;

public class HashSetController {
    private HashSetModel model;
    private HashSetView view;

    public HashSetController(HashSetModel model, HashSetView view) {
        this.model = model;
        this.view = view;

        view.addGenerateButtonListener(new GenerateButtonListener());
    }

    class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = view.getInput();
            String[] elements = input.split(",");
            Set<Set<String>> powerSet = model.generatePowerSet(elements);
            view.displayPowerSet(powerSet);
        }
    }

    public void start() {
        view.setVisible(true);
    }
    
    public static void main(String[] args) {
        HashSetModel model = new HashSetModel();
        HashSetView view = new HashSetView();
        HashSetController controller = new HashSetController(model, view);

        controller.start();
    }
}

