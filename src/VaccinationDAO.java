package src;

import java.sql.*;
import java.util.Scanner;

public class VaccinationDAO {
    private Scanner scanner = new Scanner(System.in);
    
    public void addVaccination() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("\n=== ADD VACCINATION RECORD ===");
            
            System.out.print("Enter resident ID: ");
            int residentId = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter vaccine name: ");
            String vaccineName = scanner.nextLine();
            
            System.out.print("Enter dose number: ");
            int doseNumber = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter date administered (YYYY-MM-DD): ");
            String dateAdministered = scanner.nextLine();
            
            System.out.print("Enter next due date (YYYY-MM-DD): ");
            String nextDueDate = scanner.nextLine();
            
            System.out.print("Enter administered by (doctor/nurse name): ");
            String administeredBy = scanner.nextLine();
            
            System.out.print("Enter hospital name: ");
            String hospitalName = scanner.nextLine();
            
            String sql = "INSERT INTO Vaccinations (resident_id, vaccine_name, dose_number, date_administered, next_due_date, administered_by, hospital_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, residentId);
            pstmt.setString(2, vaccineName);
            pstmt.setInt(3, doseNumber);
            pstmt.setString(4, dateAdministered);
            pstmt.setString(5, nextDueDate);
            pstmt.setString(6, administeredBy);
            pstmt.setString(7, hospitalName);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Vaccination record added successfully!");
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void viewVaccinations() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT v.*, r.name FROM Vaccinations v JOIN Residents r ON v.resident_id = r.resident_id ORDER BY v.date_administered DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("\n=== VACCINATION RECORDS ===");
            System.out.println("Vaccine ID\tResident\tVaccine\t\tDose\tDate\t\tNext Due\tHospital");
            System.out.println("------------------------------------------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.printf("%d\t\t%s\t%s\t%d\t%s\t%s\t%s\n",
                    rs.getInt("vaccination_id"),
                    rs.getString("name"),
                    rs.getString("vaccine_name"),
                    rs.getInt("dose_number"),
                    rs.getDate("date_administered"),
                    rs.getDate("next_due_date"),
                    rs.getString("hospital_name"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}