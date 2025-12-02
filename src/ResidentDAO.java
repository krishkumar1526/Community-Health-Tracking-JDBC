package src;

import java.sql.*;
import java.util.Scanner;

public class ResidentDAO {
    private Scanner scanner = new Scanner(System.in);
    
    public void addResident() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("\n=== ADD NEW RESIDENT ===");
            
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter gender (Male/Female/Other): ");
            String gender = scanner.nextLine();
            
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            
            System.out.print("Enter contact number: ");
            String contact = scanner.nextLine();
            
            System.out.print("Enter blood group: ");
            String bloodGroup = scanner.nextLine();
            
            String sql = "INSERT INTO Residents (name, age, gender, address, contact, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, gender);
            pstmt.setString(4, address);
            pstmt.setString(5, contact);
            pstmt.setString(6, bloodGroup);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Resident added successfully!");
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void viewAllResidents() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String sql = "SELECT * FROM Residents ORDER BY name";
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("\n=== ALL RESIDENTS ===");
            System.out.println("ID\tName\t\tAge\tGender\tContact\t\tBlood Group");
            System.out.println("------------------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%d\t%s\t%d\t%s\t%s\t%s\n",
                    rs.getInt("resident_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("contact"),
                    rs.getString("blood_group"));
            }
            
            System.out.println("------------------------------------------------------------------------");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void searchResident() {
        System.out.print("\nEnter resident name to search: ");
        String name = scanner.nextLine();
        
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Residents WHERE name LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            
            ResultSet rs = pstmt.executeQuery();
            
            boolean found = false;
            while (rs.next()) {
                if (!found) {
                    System.out.println("\n=== SEARCH RESULTS ===");
                    found = true;
                }
                System.out.println("ID: " + rs.getInt("resident_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Contact: " + rs.getString("contact"));
                System.out.println("Blood Group: " + rs.getString("blood_group"));
                System.out.println("Registered: " + rs.getTimestamp("registered_date"));
                System.out.println("------------------------");
            }
            
            if (!found) {
                System.out.println("No residents found with name: " + name);
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}