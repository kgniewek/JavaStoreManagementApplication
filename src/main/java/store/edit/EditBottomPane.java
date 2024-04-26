package store.edit;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import lombok.extern.slf4j.Slf4j;
import store.CustomEvent;
import store.model.DataHandler;

@Slf4j
public class EditBottomPane extends HBox {
    private Button buttonSave = null;
    private Button buttonCancel = null;
    private final EditInputPane inputPane;

    public EditBottomPane(EditInputPane inputPane) {
        this.inputPane = inputPane;
        initPane();
    }

    private void initPane() {
        getChildren().addAll(getButtonCancel(),getButtonSave());
    }

    public Button getButtonSave() {
        if(buttonSave == null){
            buttonSave = new Button("Save");
            buttonSave.setOnAction((e)->{
                log.info("Save...");
                DataHandler.INSTANCE.editItem(inputPane.item());
                fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
            });
        }
        return buttonSave;
    }

    public Button getButtonCancel() {
        if(buttonCancel == null){
            buttonCancel = new Button("Cancel");
            buttonCancel.setOnAction((e)->{
                log.info("Cancel...");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
            });
        }
        return buttonCancel;
    }
}
