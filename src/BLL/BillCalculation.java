/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;


/**
 *
 * @author DTC
 */
public class BillCalculation {
    
    public static String calculateBill(String category) {
     
        
        double amount = 0;
        double taxRate = 0.03; // 3% tax

        switch (category.toLowerCase()) {
            case "cardiology":
                amount = 1500;
                break;
            case "pediatrics":
                amount = 2000;
                break;
            case "orthopedics":
                amount = 2500;
                break;
            case "dermatology":
                amount = 3000;
                break;
            case "neurology":
                amount = 3500;
                break;
            default:
                return "Invalid category.";
        }

      
        double taxAmount = amount * taxRate;
        double totalAmount = amount + taxAmount;

        
        
        return "Category: " + category + "\n"
                + "Amount: Rs. " + amount + "\n"
                + "Tax (3%): Rs. " + taxAmount + "\n"
                + "Total: Rs. " + totalAmount;  
    }
}
