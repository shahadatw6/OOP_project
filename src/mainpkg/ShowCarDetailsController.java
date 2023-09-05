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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class ShowCarDetailsController implements Initializable {

    @FXML
    private TextArea carDetailsTextArea;
    @FXML
    private ComboBox<String> regNoComboBox;
    
    ObservableList<Car> tempList2 = Admin.viewCars();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
           for(Car car: tempList2){
               regNoComboBox.getItems().add(car.getRegNo());
           }
           

    }    

    @FXML
    private void seeDetailsButtonOnClick(ActionEvent event) {
        
        for(Car car: tempList2){
            if(car.getRegNo().equals(regNoComboBox.getValue())){
                carDetailsTextArea.setText(car.toString());
            }
        }

    }
    
}
