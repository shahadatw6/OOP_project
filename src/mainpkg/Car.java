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
public class Car extends Vehicle implements Taxable,Serializable{
    private String regNo;
    private String cc;
    private Float auctionPrice;
    private Integer noOfSeat;
    private Boolean isSportscar;

    public Car(String regNo, String cc, float auctionPrice, Integer noOfSeat, Boolean isSportscar, String model, String manufacName, LocalDate dateOfManufacture, String countryOfMake) {
        super(model, manufacName, dateOfManufacture, countryOfMake);
        this.regNo = regNo;
        this.cc = cc;
        this.auctionPrice = auctionPrice;
        this.noOfSeat = noOfSeat;
        this.isSportscar = isSportscar;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public float getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(float auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public Integer getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(Integer noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public Boolean getIsSportscar() {
        return isSportscar;
    }

    public void setIsSportscar(Boolean isSportscar) {
        this.isSportscar = isSportscar;
    }

    @Override
    public String toString() {
        return "Car{" + "regNo=" + regNo + ", cc=" + cc + ", auctionPrice=" + auctionPrice + ", noOfSeat=" + noOfSeat + ", isSportscar=" + isSportscar + '}';
    }


    
    
    

    @Override
    public float getImportTaxAmount() {
        if (Integer.parseInt(this.cc) <= 1500) {
            return 40; 
        } else if (Integer.parseInt(this.cc) >1500 && Integer.parseInt(this.cc) <= 1800) {
            return 100; 
        } else if (Integer.parseInt(this.cc) > 1800 &&  Integer.parseInt(this.cc) <=2200 ) {
            return 200 ; 
        } else if (Integer.parseInt(this.cc) > 2200 ) {
            return 300; 
        } else {
            return 0; 
        }
    }
    
    }
    
    
    
