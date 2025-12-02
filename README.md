# Community-Health-Tracking-JDBC
A Java console application for tracking community health records using JDBC and MySQL.

## Features
- Add, view, update residents
- Record health check-ups
- Track vaccination records
- Generate basic health reports

## Technologies Used
- Java 8+
- JDBC (Java Database Connectivity)
- MySQL 8.0+
- MySQL Connector/J

## Database Schema

### Tables:
1. **Residents** - Stores resident information
2. **HealthCheckups** - Records health check-up data
3. **Vaccinations** - Tracks vaccination records

## Setup Instructions

### 1. Database Setup
```sql
-- Run the SQL script in sql/database_setup.sql
