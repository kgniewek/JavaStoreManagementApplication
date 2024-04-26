package store;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import store.create.CreateScene;
import store.edit.EditScene;
import store.overview.OverviewScene;

@Slf4j
public class StoreApplication extends Application {
    private OverviewScene overviewScene = null;
    private CreateScene createScene = null;
    private EditScene editScene = null;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {
        this.stage = stage;
        stage.setTitle("Store Application");
        stage.setScene(getOverviewScene());
        stage.show();
    }

    private OverviewScene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
            overviewScene.addEventFilter(CustomEvent.GO_TO_CREATE_SCENE, (e) -> {
                log.info("Change scene to CREATE item BEGIN");
                stage.setScene(getCreateScene());
                log.info("Change scene to CREATE item END");
            });
            overviewScene.addEventFilter(CustomEvent.GO_TO_EDIT_SCENE,event -> {
                log.info("Change scene to EDIT item BEGIN");
                stage.setScene(getEditScene());
                log.info("Change scene to EDIT item END");
            });
        }
        return overviewScene;
    }

    private CreateScene getCreateScene() {
        if (createScene == null) {
            createScene = new CreateScene();
            createScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, (e) -> {
                log.info("Change scene to Overview item begin");
                stage.setScene(getOverviewScene());
                overviewScene.refreshData();
                log.info("Change scene to Overview item END");
            });
        }
        return createScene;
    }

    private EditScene getEditScene(){
        if(editScene == null){
            editScene = new EditScene();
            editScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE,(e)->{
                log.info("Change scene to Overview item begin");
                stage.setScene(getOverviewScene());
                overviewScene.refreshData();
                log.info("Change scene to Overview item END");

            });
        }
        return editScene;
    }
}