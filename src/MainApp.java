package src;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResidentDAO residentDAO = new ResidentDAO();
        HealthCheckupDAO healthDAO = new HealthCheckupDAO();
        VaccinationDAO vaccineDAO = new VaccinationDAO();
        ReportGenerator reportGen = new ReportGenerator();
        
        System.out.println("==========================================");
        System.out.println("   COMMUNITY HEALTH TRACKING SYSTEM");
        System.out.println("==========================================");
        
        // Test database connection
        System.out.println("Testing database connection...");
        if (DBConnection.getConnection() != null) {
            System.out.println("✅ Database connection successful!");
        } else {
            System.out.println("❌ Database connection failed. Exiting...");
            return;
        }
        
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Resident Management");
            System.out.println("2. Health Checkup Management");
            System.out.println("3. Vaccination Management");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            System.out.print("Select option (1-5): ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }
            
            switch (choice) {
                case 1:
                    residentMenu(residentDAO);
                    break;
                case 2:
                    healthMenu(healthDAO);
                    break;
                case 3:
                    vaccineMenu(vaccineDAO);
                    break;
                case 4:
                    reportMenu(reportGen);
                    break;
                case 5:
                    System.out.println("\nThank you for using Community Health System!");
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }
    }
    
    private static void residentMenu(ResidentDAO dao) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== RESIDENT MANAGEMENT ===");
            System.out.println("1. Add New Resident");
            System.out.println("2. View All Residents");
            System.out.println("3. Search Resident");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1: dao.addResident(); break;
                case 2: dao.viewAllResidents(); break;
                case 3: dao.searchResident(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void healthMenu(HealthCheckupDAO dao) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== HEALTH CHECKUP MANAGEMENT ===");
            System.out.println("1. Add Health Checkup");
            System.out.println("2. View All Checkups");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1: dao.addHealthCheckup(); break;
                case 2: dao.viewHealthCheckups(); break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void vaccineMenu(VaccinationDAO dao) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== VACCINATION MANAGEMENT ===");
            System.out.println("1. Add Vaccination Record");
            System.out.println("2. View All Vaccinations");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select option: ");
            
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1: dao.addVaccination(); break;
                case 2: dao.viewVaccinations(); break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void reportMenu(ReportGenerator reportGen) {
        System.out.println("\n=== REPORTS ===");
        reportGen.generateSummaryReport();
        System.out.println("\nPress Enter to continue...");
        new Scanner(System.in).nextLine();
    }
}