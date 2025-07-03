/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DTC
 */
public class AddUser {
    public static boolean saveUserDetails(String username, String password, String role) {
        String userDetails = username + "," + password + "," + role;
        String filePath = "users.txt";  

        try (FileWriter writer = new FileWriter(filePath, true)) {
             writer.write(userDetails + System.lineSeparator());
            return true; 
        } catch (IOException e) {
            e.printStackTrace();
            return false; 
        }
    }
}
