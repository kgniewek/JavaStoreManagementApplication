package store.edit;


import javafx.scene.layout.BorderPane;


public class EditPane extends BorderPane {
    private EditInputPane editInputPane = null;
    private EditBottomPane editBottomPane = null;

    public EditPane(){
        initPane();
    }

    private void initPane() {
        setCenter(getEditInputPane());
        setBottom(getEditBottomPane());
        setPrefHeight(600);
        setPrefWidth(800);
    }

    public EditInputPane getEditInputPane() {
        if (editInputPane == null) {
            editInputPane = new EditInputPane();
        }
        return editInputPane;
    }

    public EditBottomPane getEditBottomPane() {
        if (editBottomPane == null) {
            editBottomPane = new EditBottomPane(getEditInputPane());
        }
        return editBottomPane;
    }
}
