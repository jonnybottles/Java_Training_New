package com.jonathan.contactlist;

import com.jonathan.contactlist.datamodel.Contact;
import com.jonathan.contactlist.datamodel.ContactData;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableView<Contact> tableView;

    @FXML
    private TableColumn<Contact, String> firstNameCol;

    @FXML
    private TableColumn<Contact, String> lastNameCol;

    @FXML
    private TableColumn<Contact, String> phoneNumberCol;

    @FXML
    private TableColumn<Contact, String> notesCol;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;


    public void initialize() {

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(actionEvent -> {
            Contact item = tableView.getSelectionModel().getSelectedItem();
            deleteItem(item);
        });

        listContextMenu.getItems().add(deleteMenuItem); // Add this line

        // Set the row factory for the TableView
        tableView.setRowFactory(tv -> {
            TableRow<Contact> row = new TableRow<>();
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu) null)
                            .otherwise(listContextMenu)
            );
            return row;
        });


        //Bind the TableView to the list of contacts
        tableView.setItems(ContactData.getInstance().getContacts());

        // Assuming you have 4 columns, and you want them to take up equal space
//        double width = tableView.widthProperty().divide(4).doubleValue();

//        // Bind the width of each column to a quarter of the table's width
//        firstNameCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
//        lastNameCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
//        phoneNumberCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
//        notesCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));


    }

    // Provides right click delete functionality
    public void deleteItem(Contact item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact Item");
        alert.setHeaderText("Delete item: " + item.getFirstName() + " " + item.getLastName());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(item);
        }
    }

    @FXML
    public void showAddItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("This is some other instructions");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("additemdialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            AddItemDialogController controller = fxmlLoader.getController();
            Contact newItem = controller.processResults();
            //Bind the TableView to the list of contacts
            tableView.setItems(ContactData.getInstance().getContacts());

            //Find the index of the new contact
            int newIndex = ContactData.getInstance().getContacts().indexOf(newItem);
            tableView.getSelectionModel().select(newIndex);

            System.out.println("OK pressed");
        }
        
    }


    @FXML
    public void showEditContactDialog() {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if(selectedContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit.");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("additemdialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        AddItemDialogController addItemDialogController = fxmlLoader.getController();
        addItemDialogController.editContact(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            addItemDialogController.updateContact(selectedContact);
            ContactData.getInstance().saveContacts();
        }
    }

    public void deleteContact() {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        if(selectedContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Contact Selected");
            alert.setHeaderText(null);
            alert.setContentText("PLease select the contact you want to delete.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Contact");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected contact: " +
                selectedContact.getFirstName() + " " + selectedContact.getLastName());

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(selectedContact);
            ContactData.getInstance().saveContacts();
        }
    }
    
}