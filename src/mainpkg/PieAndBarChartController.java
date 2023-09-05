/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author calsifer
 */
public class PieAndBarChartController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Integer> barChart;


    /**
     * Initializes the controller class.
     */
@Override
public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
            ObservableList<Car> tempList = Admin.viewCars();

    int c1 = 0;
    int c2 = 0;
    int c3 = 0;
    int c4 = 0;
    

    for (Car car : tempList) {
        int cc = Integer.parseInt(car.getCc());

        if (cc < 1500) {
            c1++;
        } else if (cc > 1500 && cc <= 1800) {
            c2++;
        } else if (cc > 1800 && cc <= 2200) {
            c3++;
        } else {
            c4++;
        }
    }

    pieChartData.add(new PieChart.Data("<1500", c1));
    pieChartData.add(new PieChart.Data(">1500 & <= 1800", c2));
    pieChartData.add(new PieChart.Data(">1800 & <= 2200", c3));
    pieChartData.add(new PieChart.Data(">2200", c4));

    pieChart.setData(pieChartData);
    
    
    
    
XYChart.Series<String, Integer> series = new XYChart.Series<>();

ObservableList<SalesRecord> tempsr = Admin.viewSalesRecord();
ObservableList<SalesAgent> tempsa = Admin.viewSalesAgent();

ObservableList<Integer> tempsint = FXCollections.observableArrayList();

    for (SalesAgent salesAgent : tempsa) {
        tempsint.add(salesAgent.getAgentID());
    }

System.out.println(tempsint.toString());

    List<Integer> userTypeCounts = new ArrayList<>(tempsint.size());

    for (int i = 0; i < tempsint.size(); i++) {
        userTypeCounts.add(0);
    }

for (SalesRecord salesRecord : tempsr) {
    Integer userID = salesRecord.getAgentID();
    int index = tempsint.indexOf(userID);
    if (index != -1) { 
        userTypeCounts.set(index, userTypeCounts.get(index) + 1);
    }
}

for (Integer i : tempsint) {
    int index = tempsint.indexOf(i);
    if (index != -1) { 
        int count = userTypeCounts.get(index);
        series.getData().add(new XYChart.Data<>(i.toString(), count));
    }
}

barChart.getData().add(series);
barChart.setLegendVisible(true);
}


    }


