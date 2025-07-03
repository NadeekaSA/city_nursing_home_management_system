package DB;

import java.io.FileWriter;
import java.io.IOException;
import citynursingh.CashierSys;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PatientDB {


    public void savePatientDetails(String name, String age, String gender, String category, String contact) {
        CashierSys obj=new CashierSys();
        String patientDetails = name + "," + age + "," + gender + "," + category + "," + contact;

       
        try (FileWriter fw = new FileWriter("patients.txt", true)) { 
            fw.write(patientDetails + "\n");
            System.out.println("Patient details saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving patient details.");
        }
    }
     public String readPatientDetails() {
        StringBuilder content = new StringBuilder();
        String filePath = "patients.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to read file.";
        }

        return content.toString();
    }
        public List<String> searchConsultants(String searchTerm) {
        List<String> searchResults = new ArrayList<>();
        String filePath = "consultants.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResults.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchResults;
    }
    public static String getCategoryFromFile(String patientName) {
        try {
           
            BufferedReader reader = new BufferedReader(new FileReader("patients.txt"));
            String line;

           
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String category = parts[3].trim();

               
                if (name.equalsIgnoreCase(patientName)) {
                    reader.close();
                    return category;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";  
    }
    
      
}
