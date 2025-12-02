package src;

import java.sql.*;
import java.util.Scanner;

public class HealthCheckupDAO {
    private Scanner scanner = new Scanner(System.in);
    
    public void addHealthCheckup() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("\n=== ADD HEALTH CHECKUP ===");
            
            // First show existing residents
            String residentSql = "SELECT resident_id, name FROM Residents";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(residentSql);
            
            System.out.println("Available Residents:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("resident_id") + " - " + rs.getString("name"));
            }
            
            System.out.print("\nEnter resident ID: ");
            int residentId = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter checkup date (YYYY-MM-DD): ");
            String checkupDate = scanner.nextLine();
            
            System.out.print("Enter weight (kg): ");
            double weight = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter height (cm): ");
            double height = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter blood pressure (e.g., 120/80): ");
            String bp = scanner.nextLine();
            
            System.out.print("Enter sugar level: ");
            double sugarLevel = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter doctor's name: ");
            String doctorName = scanner.nextLine();
            
            String sql = "INSERT INTO HealthCheckups (resident_id, checkup_date, weight, height, bp, sugar_level, doctor_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, residentId);
            pstmt.setString(2, checkupDate);
            pstmt.setDouble(3, weight);
            pstmt.setDouble(4, height);
            pstmt.setString(5, bp);
            pstmt.setDouble(6, sugarLevel);
            pstmt.setString(7, doctorName);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Health checkup recorded successfully!");
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void viewHealthCheckups() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT h.*, r.name FROM HealthCheckups h JOIN Residents r ON h.resident_id = r.resident_id ORDER BY h.checkup_date DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("\n=== HEALTH CHECKUP RECORDS ===");
            System.out.println("Checkup ID\tResident\tDate\t\tWeight\tHeight\tBP\t\tSugar\tDoctor");
            System.out.println("-----------------------------------------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%d\t\t%s\t%s\t%.1f\t%.1f\t%s\t%.1f\t%s\n",
                    rs.getInt("checkup_id"),
                    rs.getString("name"),
                    rs.getDate("checkup_date"),
                    rs.getDouble("weight"),
                    rs.getDouble("height"),
                    rs.getString("bp"),
                    rs.getDouble("sugar_level"),
                    rs.getString("doctor_name"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}