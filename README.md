# Community Health Tracking System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

A Java console application for tracking community health records using JDBC and MySQL, developed as part of CSE2006 Programming in Java course.

## 📋 Features
- ✅ **Resident Management** - Add, view, update, search residents
- ✅ **Health Check-up Tracking** - Record health examinations
- ✅ **Vaccination Management** - Track vaccination records and due dates
- ✅ **Report Generation** - Generate health summary reports
- ✅ **MySQL Database Integration** - Full CRUD operations using JDBC
- ✅ **Console-based Interface** - User-friendly menu system
- ✅ **Error Handling** - Comprehensive exception handling
- ✅ **Sample Data** - Pre-populated database for testing

## 🏗️ Project Structure
Community-Health-Tracking-JDBC/
├── src/ # Java source files (6 modules)
│ ├── DBConnection.java # Database connectivity
│ ├── ResidentDAO.java # Resident operations
│ ├── HealthCheckupDAO.java # Health checkup operations
│ ├── VaccinationDAO.java # Vaccination operations
│ ├── ReportGenerator.java # Report generation
│ └── MainApp.java # Main menu system
├── sql/ # Database scripts
│ └── database_setup.sql # Database creation with sample data
├── docs/ # Project documentation
│ └── Project_Report.pdf # Complete project report
├── screenshots/ # Application screenshots
│ ├── main_menu.png # Main menu interface
│ ├── resident_management.png
│ ├── health_checkups.png
│ ├── vaccinations.png
│ ├── report.png
│ └── compilation_success.png
├── lib/ # External libraries
│ └── mysql-connector-j-9.5.0.jar
├── run.bat # Windows run script
├── compilation_screenshot.bat
├── README.md # This file
└── .gitignore # Git ignore file


## 🚀 Quick Start

### Prerequisites
- **Java JDK 8 or higher** (`java -version`)
- **MySQL 8.0 or higher** (`mysql --version`)
- **MySQL Connector/J 9.5.0** (included in `lib/` folder)

### Installation
1. **Clone the repository**
   
   git clone https://github.com/krishkumar1526/Community-Health-Tracking-JDBC.git
   cd Community-Health-Tracking-JDBC

2. Set up the database
mysql -u root -p < sql/database_setup.sql

3. Compile and run
# Using run script (Windows)
run.bat

# Or manually:
javac -cp "lib/mysql-connector-j-9.5.0.jar" -d . src/*.java
java -cp ".;lib/mysql-connector-j-9.5.0.jar" src.MainApp

📊 Database Schema

Tables:

1. Residents - Personal information of community members

resident_id (PK), name, age, gender, address, contact, blood_group

2. HealthCheckups - Health examination records

checkup_id (PK), resident_id (FK), checkup_date, weight, height, bp, sugar_level

3. Vaccinations - Vaccination history

vaccination_id (PK), resident_id (FK), vaccine_name, dose_number, date_administered, next_due_date

🎮 Usage
1. Run the application

run.bat

2. Main Menu Options:

=== MAIN MENU ===
1. Resident Management
2. Health Checkup Management
3. Vaccination Management
4. Reports
5. Exit

3. Navigate through sub-menus to:

Add/view/search residents

Record health check-ups

Track vaccination records

Generate health reports


📸 Screenshots
Feature	Screenshot
Main Menu	https://screenshots/main_menu.png
Resident Management	https://screenshots/resident_management.png
Health Checkups	https://screenshots/health_checkups.png
Vaccination Records	https://screenshots/vaccinations.png
Health Report	https://screenshots/report.png
Compilation Success	https://screenshots/compilation_success.png

🛠️ Technical Implementation

Java Modules:

DBConnection.java - Handles MySQL database connectivity

ResidentDAO.java - Data Access Object for resident operations

HealthCheckupDAO.java - Manages health checkup records

VaccinationDAO.java - Handles vaccination data

ReportGenerator.java - Generates health summary reports

MainApp.java - Main application with menu navigation


Key Technologies:

JDBC (Java Database Connectivity) for MySQL operations

MySQL 8.0 as relational database

PreparedStatement for SQL injection prevention

Try-with-resources for automatic resource management

Package structure for organized code

📄 Project Report
Complete project documentation available in docs/Project_Report.pdf including:

System specification

Database design

Testing strategies

Code implementation

Screenshots

Future enhancements

👨‍💻 Developer
Name: Krish 

Course: CSE2006 - Programming in Java

University: VIT Bhopal 

GitHub: @krishkumar1526

📄 License
This project is created for educational purposes as part of academic coursework. All code is open for learning and reference.

🔗 Links
GitHub Repository: https://github.com/krishkumar1526/Community-Health-Tracking-JDBC

MySQL Download: https://www.mysql.com/downloads/

JDBC Documentation: https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/


Note: This project demonstrates JDBC concepts, database connectivity, and console application development in Java.


