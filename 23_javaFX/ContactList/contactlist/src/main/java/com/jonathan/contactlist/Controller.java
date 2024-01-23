package com.jonathan.contactlist;

import com.jonathan.contactlist.datamodel.Contact;
import com.jonathan.contactlist.datamodel.ContactData;
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



    public void initialize() {

        ContactData theContacts = new ContactData();
        theContacts.addContact(new Contact("Lorenzo", "Ireland", "1-800-CPT-CPLR", "Americas Premier Programmer"));
        theContacts.addContact(new Contact("Paul", "Navarro", "1-800-CLD-ARCH", "USA's Leading Cloud Architect"));


        //Bind the TableView to the list of contacts
        tableView.setItems(theContacts.getContacts());

        // Bind the column's cell value to the Contact property
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));

        // Assuming you have 4 columns, and you want them to take up equal space
        double width = tableView.widthProperty().divide(4).doubleValue();

        // Bind the width of each column to a quarter of the table's width
        firstNameCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        lastNameCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        phoneNumberCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
        notesCol.prefWidthProperty().bind(tableView.widthProperty().divide(4));
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

        //TODO
        // Implement this code below from the todolist controller function thats the same as this one
//        if(result.isPresent() && result.get() == ButtonType.OK) {
//            DialogController controller = fxmlLoader.getController();
//            TodoItem newItem = controller.processResults();
//            todoListView.getSelectionModel().select(newItem);
//            System.out.println("OK pressed");
//        }


    }
}