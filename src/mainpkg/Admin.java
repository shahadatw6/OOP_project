/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

/**
 *
 * @author calsifer
 */
public class Admin {
    
    
    
    public static void addNewcar(Car car){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("CarFile.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(car);
                        showAlert("New car added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new car");
            }
        }
        
    }   
        
    public static void addnewSalesAgent(SalesAgent salesAgent){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("SalesAgent.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(salesAgent);
                        showAlert("New agent added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new agent");
            }
        }
       
    
    }
    
        public static void addnewSalesRecord(SalesRecord salesRecord){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            File file = new File("SalesRecord.bin");
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            }else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(salesRecord);
                        showAlert("New SalesRecord added successfully!");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }finally{
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            showAlert("Error: Failed to add new SalesRecord");
            }
        }
        }
        
    public static ObservableList<Car> viewCars(){
        ObservableList<Car> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CarFile.bin"))) {
            while (true) {
                try {
                    Car car = (Car) ois.readObject();
                    tempList.add(car);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("Car Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("carList.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
    
    public static ObservableList<SalesAgent> viewSalesAgent(){
        ObservableList<SalesAgent> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SalesAgent.bin"))) {
            while (true) {
                try {
                    SalesAgent salesAgent = (SalesAgent) ois.readObject();
                    tempList.add(salesAgent);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("SalesAgent Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("SalesAgent.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
        public static ObservableList<SalesRecord> viewSalesRecord(){
        ObservableList<SalesRecord> tempList = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SalesRecord.bin"))) {
            while (true) {
                try {
                    SalesRecord salesRecord = (SalesRecord) ois.readObject();
                    tempList.add(salesRecord);
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    System.err.println("SalesAgent Class not Found");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("SalesAgent.bin File not Found");
        } catch (IOException e) {
            System.err.println("IO exception" + e.getMessage());
        }

        return tempList;
    }
    
    
    
public static void generatePDFForSalesRecord(ObservableList<SalesRecord> temp, String fileName) {
    try {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
        

        fc.setInitialFileName(fileName);

        File f = fc.showSaveDialog(null);
        if (f != null) {
            PdfWriter pw = new PdfWriter(new FileOutputStream(f));
            PdfDocument pdf = new PdfDocument(pw);
            pdf.addNewPage();
            Document doc = new Document(pdf);
            doc.setLeftMargin(70);
            
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 = "carList" + "\n";
                
                for(SalesRecord salesRecord: temp){

                paraText1 
                        += salesRecord.toString()+"\n";
                        }
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("SalesRecord List");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                               
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(lineSpace);


            
            doc.close();
            
            showAlert("PDF saved successfully.");
        } else {
            showAlert("Saving as PDF: Cancelled.");
        }
    } catch (FileNotFoundException e) {
        showAlert("Error: File not found - " + e.getMessage());
    } catch (Exception e) {
        showAlert("Oops! Exception: " + e.toString() + " occurred.");
    }
}
    

public static void generatePDFForApplication(ObservableList<Car> temp, String fileName) {
    try {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
        

        fc.setInitialFileName(fileName);

        File f = fc.showSaveDialog(null);
        if (f != null) {
            PdfWriter pw = new PdfWriter(new FileOutputStream(f));
            PdfDocument pdf = new PdfDocument(pw);
            pdf.addNewPage();
            Document doc = new Document(pdf);
            doc.setLeftMargin(70);
            
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 = "carList" + "\n";
                
                for(Car car: temp){

                paraText1 
                        += car.toString()+"\n";
                        }
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Car List");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                               
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(lineSpace);


            
            doc.close();
            
            showAlert("PDF saved successfully.");
        } else {
            showAlert("Saving as PDF: Cancelled.");
        }
    } catch (FileNotFoundException e) {
        showAlert("Error: File not found - " + e.getMessage());
    } catch (Exception e) {
        showAlert("Oops! Exception: " + e.toString() + " occurred.");
    }
}
    
        
    private static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
