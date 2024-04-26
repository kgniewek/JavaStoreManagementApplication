package store.overview;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import store.CustomEvent;
import store.model.DataHandler;
import store.model.Item;

import java.util.Comparator;
import java.util.Optional;

@Slf4j
public class OverviewLeftPane extends VBox {
    private Button buttonCreate = null;
    private Button buttonDelete = null;
    private Button buttonEdit = null;
    private Button buttonAddToFavorites = null;
    private TextField searchBar;
    private final OverviewTableView overviewTableView;

    public OverviewLeftPane(OverviewTableView overviewTableView) {
        this.overviewTableView = overviewTableView;
        initStuff();
    }

    private void initStuff() {
        this.setSpacing(10);
        this.setPadding(new Insets(5));
        this.getChildren().addAll(getButtonCreate(), getButtonDelete(), getButtonEdit(),createFilterButtons(),getButtonAddToFavorites());
        initSearchBar();
    }

    private void initSearchBar() {
        searchBar = new TextField();
        searchBar.setPromptText("Search");
        searchBar.setOnKeyReleased(this::handleSearch);
        this.getChildren().add(searchBar);
    }

    private void handleSearch(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String searchText = searchBar.getText().trim().toLowerCase();
            overviewTableView.getItems().clear();

            for (Item item: DataHandler.INSTANCE.itemsAsObservableList()) {
                if(item.getName().toLowerCase().contains(searchText)){
                    overviewTableView.getItems().add(item);
                }
            }
            overviewTableView.refresh();
        }
    }
    private Button getButtonCreate() {
        if(buttonCreate == null){
            buttonCreate = new Button("Add item");
            buttonCreate.setOnAction((e) -> {
                log.info("Add item clicked");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_CREATE_SCENE));
            });
        }
        return buttonCreate;
    }

    private Button getButtonDelete() {
        if(buttonDelete == null){
            buttonDelete = new Button("Delete item");
            buttonDelete.setOnAction((e) ->
            {
                log.info("Delete item BEGIN");
                Item selectedItem = (Item) overviewTableView
                        .getSelectionModel()
                        .getSelectedItem();
                if(selectedItem == null){
                    log.info("No item selected");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("No item selected!");
                    alert.showAndWait();
                    return;
                }

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Are you sure you want to delete the item ?");
                alert.setHeaderText(selectedItem.toString());
                alert.setTitle("Delete item ?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                log.info("ButtonType: "+ buttonType.get().getText());

                if(buttonType.get() == ButtonType.OK){
                    DataHandler.INSTANCE.deleteItem(selectedItem);
                    overviewTableView.setItems(DataHandler.INSTANCE.itemsAsObservableList());
                }
                else{
                    log.info("Cancel the deletion");
                }

                log.info("Delete item END");
            });
        }
        return buttonDelete;
    }

    private Button getButtonEdit(){
        if(buttonEdit == null){
            buttonEdit = new Button("Edit");
            buttonEdit.setOnAction((e)->{
                log.info("Edit item clicked");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_EDIT_SCENE));

            });
        }
        return buttonEdit;
    }
    private HBox createFilterButtons() {
        Button buttonAsc = new Button("Sort Ascending");
        buttonAsc.setOnAction(e -> {
            overviewTableView.getItems().sort(Comparator.comparingDouble(Item::getPrice));
            overviewTableView.refresh();
        });

        Button buttonDesc = new Button("Sort Descending");
        buttonDesc.setOnAction(e -> {
            overviewTableView.getItems().sort(Comparator.comparingDouble(Item::getPrice).reversed());
            overviewTableView.refresh();
        });

        HBox filterButtons = new HBox(buttonAsc, buttonDesc);
        filterButtons.setSpacing(5);
        return filterButtons;
    }

    private Button getButtonAddToFavorites(){
        if(buttonAddToFavorites == null){
            buttonAddToFavorites = new Button("Add to  Favorites");
            buttonAddToFavorites.setOnAction((e)->{
                Item selectedItem = (Item) overviewTableView.getSelectionModel().getSelectedItem();
                if(selectedItem == null){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("No item selected!");
                    alert.showAndWait();
                    return;
                }
                DataHandler.INSTANCE.addToFavorites(selectedItem);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Item added to favorites!");
                alert.showAndWait();
                overviewTableView.refresh();
            });
        }

        return buttonAddToFavorites;
    }

}

