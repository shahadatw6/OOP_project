/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<Car> tableView;
    @FXML
    private TableColumn<Car, String> modelCol;
    @FXML
    private TableColumn<Car, String> manuCol;
    @FXML
    private TableColumn<Car, LocalDate> dateCol;
    @FXML
    private TableColumn<Car, String> countryCol;
    @FXML
    private TableColumn<Car, String> regCol;
    @FXML
    private TableColumn<Car, String> ccCol;
    @FXML
    private TableColumn<Car, Float> aucPriceCol;
    @FXML
    private TableColumn<Car, Integer> noOfSeatCol;
    @FXML
    private TableColumn<Car, Boolean> sportsCol;
    @FXML
    private RadioButton ccCon1RadioButton;
    @FXML
    private RadioButton ccCon2RadioButton;
    @FXML
    private RadioButton ccCon3RadioButton;
    @FXML
    private RadioButton ccCon4RadioButton;
    @FXML
    private TextField minTextField;
    @FXML
    private TextField maxTextBox;

    
        ObservableList<Car> tempList2 = Admin.viewCars();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
             ToggleGroup   tg = new ToggleGroup();
             ccCon1RadioButton.setToggleGroup(tg);
             ccCon2RadioButton.setToggleGroup(tg);
             ccCon3RadioButton.setToggleGroup(tg);
             ccCon4RadioButton.setToggleGroup(tg);
             


             
        
        
        
        modelCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModel()));
        manuCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getManufacName()));
        dateCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateOfManufacture()));
        countryCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCountryOfMake()));
        regCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRegNo()));
        ccCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCc()));
        aucPriceCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAuctionPrice()));
        noOfSeatCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNoOfSeat()));
        sportsCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getIsSportscar()));
        
        tableView.setItems(tempList2);
        
       
    }    

@FXML
private void addCCFilterButtonOnclick(ActionEvent event) {
    if (ccCon1RadioButton.isSelected()) {
        filterCarByCC(tableView, "0", "1500");
    } else if (ccCon2RadioButton.isSelected()) {
        filterCarByCC(tableView, "1501", "1800");
    } else if (ccCon3RadioButton.isSelected()) {
        filterCarByCC(tableView, "1801", "2200");
    } else if (ccCon4RadioButton.isSelected()) {
        filterCarByCC(tableView, "2201", "100000000");
    }
}

    @FXML
    private void addPricefilterButtonOnclick(ActionEvent event) {
        
        ObservableList<Car> temp = FXCollections.observableArrayList();
        
        Integer min = Integer.parseInt(minTextField.getText());
        Integer max = Integer.parseInt(maxTextBox.getText());
        
        for(Car car: tempList2){
            if(Integer.parseInt(car.getCc())>min && Integer.parseInt(car.getCc())<max ){
                temp.add(car);
            }
        }
        
        tableView.setItems(temp);
    }

    @FXML
    private void makePDFButtonOnClick(ActionEvent event) {
        
        ObservableList<Car> items = tableView.getItems();

        
        Admin.generatePDFForApplication(items, "CarList");
    }
    
    
    private void filterCarByCC(TableView<Car> tableView, String cc1, String cc2) {
    ObservableList<Car> temp = FXCollections.observableArrayList();

    for (Car car : tempList2) {
        int cc = Integer.parseInt(car.getCc());
        int minCC = Integer.parseInt(cc1);
        int maxCC = Integer.parseInt(cc2);

        if (cc >= minCC && cc <= maxCC) {
            temp.add(car);
        }
    }

    tableView.setItems(temp);
}
    
}
