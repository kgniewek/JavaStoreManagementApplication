package store.edit;

import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import store.model.Item;

public class EditInputPane extends GridPane {
    private Text txtName;
    private TextField name;
    private TextField category;
    private Text txtCategory;
    private TextField price;
    private Text txtPrice;


    public EditInputPane() {
        initPane();
    }

    private void initPane() {
        getChildren().addAll(
                getTxtName(), getName(),
                getTxtCategory(), getCategory(),
                getTxtPrice(), getPrice()
        );
        ColumnConstraints c1 = new ColumnConstraints(200);
        ColumnConstraints c2 = new ColumnConstraints(300);
        c2.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(c1, c2);


        int row = 0;
        int column = 0;
        setRowIndex(getTxtName(), row);
        setRowIndex(getName(), row++);

        setColumnIndex(getTxtName(), column++);
        setColumnIndex(getName(), column);

        column = 0;
        setRowIndex(getTxtCategory(), row);
        setRowIndex(getCategory(), row++);

        setColumnIndex(getTxtCategory(), column++);
        setColumnIndex(getCategory(), column);

        column = 0;
        setRowIndex(getTxtPrice(), row);
        setRowIndex(getPrice(), row++);

        setColumnIndex(getTxtPrice(), column++);
        setColumnIndex(getPrice(), column);



    }

    private Text getTxtName() {
        if (txtName == null) {
            txtName = new Text("Name:");
        }
        return txtName;
    }

    private TextField getName() {
        if (name == null) {
            name = new TextField("NOT_SET");
        }
        return name;
    }

    private TextField getCategory() {
        if (category == null) {
            category = new TextField("NOT_SET");
        }
        return category;
    }

    private Text getTxtCategory() {
        if (txtCategory == null) {
            txtCategory = new Text("Category:");
        }
        return txtCategory;
    }

    private TextField getPrice() {
        if (price == null) {
            price = new TextField("NOT_SET");
        }
        return price;
    }

    private Text getTxtPrice() {
        if (txtPrice == null) {
            txtPrice = new Text("Price:");
        }
        return txtPrice;
    }


    public Item item() {
        return new Item(
                getName().getText(),
                getCategory().getText(),
                Double.parseDouble(getPrice().getText())
        );
    }
}
