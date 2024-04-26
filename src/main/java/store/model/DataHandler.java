package store.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum DataHandler {
    INSTANCE;
    private List<Item> items = null;


    private List<Item> getItems() {
        items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaNaZaliczenie", "postgres", "password")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                items.add(new Item(name, category, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    private void saveItems(Item item) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaNaZaliczenie", "postgres", "password")) {
            String sql = "INSERT INTO items (name,category,price) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, item.getName());
            statement.setString(2, item.getCategory());
            statement.setDouble(3, item.getPrice());
            statement.addBatch();
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeItems(Item item) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaNaZaliczenie", "postgres", "password")) {
            String removeSql = "DELETE FROM items WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(removeSql);
            statement.setString(1, item.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateItems(Item item) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaNaZaliczenie", "postgres", "password")) {
            String updateSql = "UPDATE items SET name = ?, category = ?, price = ? WHERE name = ? ";
            PreparedStatement statement = connection.prepareStatement(updateSql);
            statement.setString(1, item.getName());
            statement.setString(2, item.getCategory());
            statement.setDouble(3, item.getPrice());
            statement.setString(4, item.getName());
            statement.executeUpdate();
            statement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createItem(Item item) {
        items.add(item);
        saveItems(item);
    }

    public void deleteItem(Item item) {
        removeItems(item);
    }

    public void editItem(Item item) {
        updateItems(item);
    }


    public ObservableList<Item> itemsAsObservableList() {
        return FXCollections.observableList(getItems());
    }

    public void addToFavorites(Item selectedItem) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BazaNaZaliczenie", "postgres", "password")) {
            String sql = "UPDATE items SET name = ?, category = ?, price = ? WHERE name = ? AND category = ? AND price = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, selectedItem.getName());
            statement.setString(2, selectedItem.getCategory());
            statement.setDouble(3, selectedItem.getPrice());
            statement.setString(4, selectedItem.getName());
            statement.setString(5, selectedItem.getCategory());
            statement.setDouble(6, selectedItem.getPrice());
            statement.executeUpdate();

            selectedItem.setName("* " + selectedItem.getName());
            selectedItem.setCategory("Favorite");
            selectedItem.setPrice(selectedItem.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
