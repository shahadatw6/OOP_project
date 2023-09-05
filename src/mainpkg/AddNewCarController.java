/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class AddNewCarController implements Initializable {

    @FXML
    private TextField modelTextField;
    @FXML
    private TextField manuNameTextField;
    @FXML
    private DatePicker dOMDatePicker;
    @FXML
    private TextField countryOfMAkeTextField;
    @FXML
    private TextField regNoTextField;
    @FXML
    private TextField auctionTextField;
    @FXML
    private TextField noOfSitTextField;
    @FXML
    private ComboBox<String> sportsComboVox;
    @FXML
    private TextField ccTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ccComboBox.getItems().addAll("cc <= 1500","cc <= 1800 && cc >1500","cc > 1800 &&  cc >=2200","cc > 2200");
        sportsComboVox.getItems().addAll("Yes","No");
    }    

    @FXML
    private void addANewCarButtonOnClick(ActionEvent event) {
        
        Boolean flag = false;

        if(!checkIfCarExists(regNoTextField.getText())){
        
        Car car = new Car(regNoTextField.getText(),ccTextField.getText(),
                            Float.parseFloat(auctionTextField.getText()),
                            Integer.parseInt(noOfSitTextField.getText()),
                            flag, modelTextField.getText(),manuNameTextField.getText(),
                            dOMDatePicker.getValue(),countryOfMAkeTextField.getText());
         
        Admin.addNewcar(car);
        
    }else{
            showAlert("Car already exists");
        }
    
    }
    private boolean checkIfCarExists(String regNo) {
    for (Car existingCar : Admin.viewCars()) {
        if (existingCar.getRegNo().equals(regNo)) {
            return true; 
        }
    }
    return false; 
}
    
    
            
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}