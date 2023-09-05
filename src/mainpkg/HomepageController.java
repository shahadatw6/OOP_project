/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class HomepageController implements Initializable {

    @FXML
    private BorderPane homeBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void addNewCarButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AddNewCar.fxml"));
        homeBorderPane.setCenter(parent);
    }

    @FXML
    private void addNewAgentButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AddNewSalesAgent.fxml"));
        homeBorderPane.setCenter(parent);
    }

    @FXML
    private void addNewSalesRecordButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AddNewSalesRecord.fxml"));
        homeBorderPane.setCenter(parent);
    }


    @FXML
    private void viewACarButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ShowCarDetails.fxml"));
        homeBorderPane.setCenter(parent);
    }

    @FXML
    private void reportTableButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("TableView.fxml"));
        homeBorderPane.setCenter(parent);
    }

    @FXML
    private void reportChartButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("PieAndBarChart.fxml"));
        homeBorderPane.setCenter(parent);
    }

    @FXML
    private void salesReportTableButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SalesReportTable.fxml"));
        homeBorderPane.setCenter(parent);
    }
    
}
