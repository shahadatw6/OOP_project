/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class AddNewSalesRecordController implements Initializable {

    @FXML
    private ComboBox<String> regNoComboBox;
    @FXML
    private ComboBox<Integer> agentIDComboBox;
    @FXML
    private Label salePriceLabel;
    
    ObservableList<Car> tempList2 = Admin.viewCars();
    Float salesPricee ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<SalesAgent> tempList1 = Admin.viewSalesAgent();

        
        
        for(Car car : tempList2){
            regNoComboBox.getItems().add(car.getRegNo());
        }
        
        for(SalesAgent salesAgent: tempList1){
            agentIDComboBox.getItems().add(salesAgent.getAgentID());
        }
        
    }    

    @FXML
private void getSalePriceButtonOnClick(ActionEvent event) {
    String selectedRegNo = regNoComboBox.getValue();
    if (selectedRegNo != null) {
        for (Car car : tempList2) {
            if (car.getRegNo().equals(selectedRegNo)) {
                float taxRate = car.getImportTaxAmount();
                System.out.println(taxRate);
                float auctionPrice = car.getAuctionPrice();
                float price = getImportTax(auctionPrice, taxRate);
                System.out.println(price);
                salesPricee = price + (price * (20.0f / 100.0f));
                salePriceLabel.setText(Float.toString(salesPricee));
                break;
           }
       }
    } 
       
    }

    @FXML
    private void makeASalePriceButtonOnClick(ActionEvent event) {
        SalesRecord salesrecord = new SalesRecord(regNoComboBox.getValue(),agentIDComboBox.getValue(),salesPricee);
        Admin.addnewSalesRecord(salesrecord);
    }
    
    
    private Float getImportTax(Float auctionprice, Float Taxrate){
        Float sprice = auctionprice + (auctionprice* (Taxrate/100));
        
        return sprice;
    }
    
    
}
