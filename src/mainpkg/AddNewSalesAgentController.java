/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class AddNewSalesAgentController implements Initializable {

    @FXML
    private TextField agNameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField salaryTextField;
    private TextField genderTextField;
    @FXML
    private DatePicker dojDatePicker;
    @FXML
    private ComboBox<String> genderComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genderComboBox.getItems().addAll("Male","Female");
    }    

    @FXML
    private void addAgentButtonOnClick(ActionEvent event) {
        SalesAgent salesAgent = new SalesAgent(Integer.parseInt(idTextField.getText()),
                                                agNameTextField.getText(),
                                                Float.parseFloat(salaryTextField.getText()),
                                                genderComboBox.getValue(),
                                                dojDatePicker.getValue());
        
        Admin.addnewSalesAgent(salesAgent);
    }
    
}
