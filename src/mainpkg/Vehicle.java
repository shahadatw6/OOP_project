/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author calsifer
 */
public abstract class Vehicle implements Serializable{
    private String model;
    private String manufacName;
    private LocalDate dateOfManufacture;
    private String countryOfMake;

    public Vehicle(String model, String manufacName, LocalDate dateOfManufacture, String countryOfMake) {
        this.model = model;
        this.manufacName = manufacName;
        this.dateOfManufacture = dateOfManufacture;
        this.countryOfMake = countryOfMake;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacName() {
        return manufacName;
    }

    public void setManufacName(String manufacName) {
        this.manufacName = manufacName;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getCountryOfMake() {
        return countryOfMake;
    }

    public void setCountryOfMake(String countryOfMake) {
        this.countryOfMake = countryOfMake;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model=" + model + ", manufacName=" + manufacName + ", dateOfManufacture=" + dateOfManufacture + ", countryOfMake=" + countryOfMake + '}';
    }


    
    
    
}
