@echo off
echo ==========================================
echo   UPLOADING TO GITHUB
echo ==========================================
echo.

echo Step 1: Checking Git status...
git status
echo.

echo Step 2: Adding all files...
git add -A
echo.

echo Step 3: Committing changes...
git commit -m "Complete Community Health System Project

Modules:
- DBConnection.java - Database connectivity
- ResidentDAO.java - Resident management
- HealthCheckupDAO.java - Health checkups
- VaccinationDAO.java - Vaccination records
- ReportGenerator.java - Health reports
- MainApp.java - Main menu system

Features:
- MySQL JDBC integration
- CRUD operations
- Console-based UI
- Error handling
- Database scripts"
echo.

echo Step 4: Pushing to GitHub...
git push origin main
echo.

if errorlevel 1 (
    echo Push failed. Trying with force...
    git push origin main --force-with-lease
)

echo.
echo ==========================================
echo Check your repository at:
echo https://github.com/krishkumar1526/Community-Health-Tracking-JDBC
echo ==========================================
pause