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
public class SalesAgent implements Serializable{
    private Integer agentID;
    private String agentName;
    private float salary;
    private String gender;
    private LocalDate dateOfJoin;

    public SalesAgent(Integer agentID, String agentName, float salary, String gender, LocalDate dateOfJoin) {
        this.agentID = agentID;
        this.agentName = agentName;
        this.salary = salary;
        this.gender = gender;
        this.dateOfJoin = dateOfJoin;
    }

    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    @Override
    public String toString() {
        return "SalesAgent{" + "agentID=" + agentID + ", agentName=" + agentName + ", salary=" + salary + ", gender=" + gender + ", dateOfJoin=" + dateOfJoin + '}';
    }
    
    
}
