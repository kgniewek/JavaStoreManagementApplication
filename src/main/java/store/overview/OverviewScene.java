package store.overview;


import javafx.scene.Scene;

public class OverviewScene extends Scene {
    private final OverviewPane overviewPane;

    public OverviewScene() {
        super(new OverviewPane());
          overviewPane = (OverviewPane) getRoot();
    }

    public void refreshData() {
        overviewPane.refreshData();
    }

}
