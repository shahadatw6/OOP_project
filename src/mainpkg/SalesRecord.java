/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author calsifer
 */
public class SalesRecord implements Serializable{
    private String regNo;
    private Integer agentID;
    private float salePrice;

    public SalesRecord(String regNo, Integer agentID, float salePrice) {
        this.regNo = regNo;
        this.agentID = agentID;
        this.salePrice = salePrice;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "SalesReport{" + "regNo=" + regNo + ", agentID=" + agentID + ", salePrice=" + salePrice + '}';
    }
    
    
    
}
