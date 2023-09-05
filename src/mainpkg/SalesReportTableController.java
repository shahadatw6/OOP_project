/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
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
public class SalesReportTableController implements Initializable {

    @FXML
    private TableView<SalesRecord> reportTable;
    @FXML
    private TableColumn<SalesRecord, String> regCol;
    @FXML
    private TableColumn<SalesRecord, Integer> agIdCol;
    @FXML
    private TableColumn<SalesRecord, Float> sPriceCol;
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
             
             
        
        regCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRegNo()));
        agIdCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAgentID()));
        sPriceCol.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getSalePrice()));
        
        reportTable.setItems(Admin.viewSalesRecord());
    }    

    @FXML
    private void addCCFilterButtonOnclick(ActionEvent event) {
        
    if (ccCon1RadioButton.isSelected()) {
        filterCarByCC(reportTable, "0", "1500");
    } else if (ccCon2RadioButton.isSelected()) {
        filterCarByCC(reportTable, "1501", "1800");
    } else if (ccCon3RadioButton.isSelected()) {
        filterCarByCC(reportTable, "1801", "2200");
    } else if (ccCon4RadioButton.isSelected()) {
        filterCarByCC(reportTable, "2201", "100000000");
    }
        
    }

    @FXML
    private void addPricefilterButtonOnclick(ActionEvent event) {
        
        
        ObservableList<Car> temp = FXCollections.observableArrayList();
        ObservableList<SalesRecord> temp2 = Admin.viewSalesRecord();
        

        Float min = Float.parseFloat(minTextField.getText());
        Float max = Float.parseFloat(maxTextBox.getText());
        
        ObservableList<SalesRecord> temp4 = FXCollections.observableArrayList();

        for(SalesRecord salesRecord: temp2){
            if(salesRecord.getSalePrice() < max && salesRecord.getSalePrice() >min){
                temp4.add(salesRecord);
            }
        }
        reportTable.setItems(temp4);
    }

    @FXML
    private void makePDFButtonOnClick(ActionEvent event) {
                
        ObservableList<SalesRecord> items = reportTable.getItems();
        
        
        Admin.generatePDFForSalesRecord(items, "CarList");
    }
    
    
    private void filterCarByCC(TableView<SalesRecord> reportTable, String cc1, String cc2) {
    ObservableList<Car> temp = FXCollections.observableArrayList();
    ObservableList<SalesRecord> temp4 = FXCollections.observableArrayList();

    ObservableList<SalesRecord> temp2 = Admin.viewSalesRecord();


    for (Car car : tempList2) {
        int cc = Integer.parseInt(car.getCc());
        int minCC = Integer.parseInt(cc1);
        int maxCC = Integer.parseInt(cc2);

        if (cc >= minCC && cc <= maxCC) {
            temp.add(car);
        }
    }
    for(Car car2: temp){
        for(SalesRecord s:temp2){
            if(car2.getRegNo().equals(s.getRegNo())){
                temp4.add(s);
            }
    }
    }
    reportTable.setItems(temp4);
}
    
}
