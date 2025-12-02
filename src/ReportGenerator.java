package src;

import java.sql.*;

public class ReportGenerator {
    
    public void generateSummaryReport() {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("\n=== COMMUNITY HEALTH SUMMARY REPORT ===");
            System.out.println("Generated on: " + new java.util.Date());
            System.out.println("==========================================\n");
            
            // Total residents
            String sql1 = "SELECT COUNT(*) as total FROM Residents";
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(sql1);
            if (rs1.next()) {
                System.out.println("Total Residents: " + rs1.getInt("total"));
            }
            
            // Age distribution
            System.out.println("\n--- Age Distribution ---");
            String sql2 = "SELECT CASE WHEN age < 18 THEN 'Child (<18)' " +
                         "WHEN age BETWEEN 18 AND 60 THEN 'Adult (18-60)' " +
                         "ELSE 'Senior (>60)' END as age_group, COUNT(*) as count " +
                         "FROM Residents GROUP BY age_group";
            ResultSet rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                System.out.println(rs2.getString("age_group") + ": " + rs2.getInt("count"));
            }
            
            // Recent checkups
            System.out.println("\n--- Recent Health Checkups (Last 30 days) ---");
            String sql3 = "SELECT COUNT(*) as recent_checkups FROM HealthCheckups " +
                         "WHERE checkup_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)";
            ResultSet rs3 = stmt.executeQuery(sql3);
            if (rs3.next()) {
                System.out.println("Checkups in last 30 days: " + rs3.getInt("recent_checkups"));
            }
            
            // Vaccination summary
            System.out.println("\n--- Vaccination Summary ---");
            String sql4 = "SELECT vaccine_name, COUNT(*) as doses FROM Vaccinations GROUP BY vaccine_name";
            ResultSet rs4 = stmt.executeQuery(sql4);
            while (rs4.next()) {
                System.out.println(rs4.getString("vaccine_name") + ": " + rs4.getInt("doses") + " doses");
            }
            
            // Residents without checkups
            System.out.println("\n--- Residents without recent checkups ---");
            String sql5 = "SELECT COUNT(DISTINCT r.resident_id) as without_checkup " +
                         "FROM Residents r LEFT JOIN HealthCheckups h ON r.resident_id = h.resident_id " +
                         "WHERE h.checkup_id IS NULL OR h.checkup_date < DATE_SUB(CURDATE(), INTERVAL 365 DAY)";
            ResultSet rs5 = stmt.executeQuery(sql5);
            if (rs5.next()) {
                System.out.println("Residents needing checkup: " + rs5.getInt("without_checkup"));
            }
            
            System.out.println("\n==========================================");
            System.out.println("End of Report");
            
        } catch (SQLException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}