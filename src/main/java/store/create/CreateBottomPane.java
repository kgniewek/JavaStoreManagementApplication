package store.create;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import lombok.extern.slf4j.Slf4j;
import store.CustomEvent;
import store.model.DataHandler;

@Slf4j
public class CreateBottomPane extends HBox {
    private Button cancel = null;
    private Button ok = null;
    private final CreateInputPane inputPane;

    public CreateBottomPane(CreateInputPane inputPane){
        this.inputPane = inputPane;
        initPane();
    }

    private void initPane(){
        getChildren().addAll(getCancel(),getOk());
    }

    public Button getCancel() {
        if(cancel == null){
            cancel = new Button("Cancel");
            cancel.setOnAction((e)->{
                log.info("Cancel...");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
            });
        }
        return cancel;
    }

    public Button getOk() {
        if(ok == null){
            ok = new Button("OK");
            ok.setOnAction((e)->{
                log.info("OK...");
                DataHandler.INSTANCE.createItem(inputPane.item());
                fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
            });
        }
        return ok;
    }
}
