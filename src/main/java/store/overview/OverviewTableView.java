package store.overview;


import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import store.model.Item;

public class OverviewTableView extends TableView {
    public OverviewTableView(ObservableList<Item> items) {
        super(items);
        initTable();
    }

    private void initTable() {
        TableColumn<String, Item> tableColumnName = new TableColumn<>("Name");
        tableColumnName.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn<String, Item> tableColumnCategory = new TableColumn<>("Category");
        tableColumnCategory.setCellValueFactory(new PropertyValueFactory("category"));

        TableColumn<Double, Item> tableColumnPrice = new TableColumn<>("Price");
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory("price"));

        getColumns().addAll(tableColumnName,
                tableColumnCategory,
                tableColumnPrice);
    }
}
