@echo off
chcp 65001 >nul
title Screenshots Guide - Community Health Tracking
color 0A

echo ======================================================
echo       COMMUNITY HEALTH TRACKING - SCREENSHOTS GUIDE
echo ======================================================
echo.

echo This guide will help you create organized screenshots for your project.
echo Please follow these steps to ensure all required screenshots are captured.
echo.

echo [INSTRUCTIONS]
echo 1. Run this project using compile_and_run.bat
echo 2. Navigate through ALL menu options
echo 3. Take screenshots at each step
echo 4. Save screenshots in the 'screenshots' folder
echo.

echo ==================== REQUIRED SCREENSHOTS ====================
echo.
echo [MAIN MENU SCREENS]
echo 1.  Main Menu - showing all options
echo 2.  Add Patient Record screen
echo 3.  View All Patients screen
echo 4.  Search Patient screen (before search)
echo 5.  Search Patient screen (after search with results)
echo 6.  Update Patient Information screen
echo 7.  Delete Patient Record screen (confirmation)
echo 8.  Generate Health Report screen
echo 9.  Exit confirmation screen
echo.

echo [DATABASE OPERATIONS]
echo 10. Successful database connection message
echo 11. Record added successfully message
echo 12. Record updated successfully message
echo 13. Record deleted successfully message
echo 14. Error handling screens (if applicable)
echo.

echo [REPORTING]
echo 15. Health report generation screen
echo 16. Generated report display
echo 17. Report saved confirmation
echo.

echo [SPECIAL CASES]
echo 18. Empty database view
echo 19. Search with no results found
echo 20. Validation error messages (invalid input)
echo.

echo ==================== NAMING CONVENTION ====================
echo.
echo Please name your screenshots using this format:
echo.
echo   main_menu.png
echo   add_patient.png
echo   view_patients.png
echo   search_patient.png
echo   update_patient.png
echo   delete_patient.png
echo   health_report.png
echo   db_connection.png
echo   success_add.png
echo   error_message.png
echo.
echo For sequence screenshots, add numbers:
echo   add_patient_1.png, add_patient_2.png, etc.
echo.

echo ==================== TIPS ====================
echo.
echo 1. Use Windows Snipping Tool (Win + Shift + S) or Alt + PrtScn
echo 2. Save screenshots directly to 'screenshots' folder
echo 3. Ensure console window is properly visible
echo 4. Include both input and output in same screenshot when possible
echo 5. Capture error messages and validations
echo 6. Make sure text is readable in screenshots
echo.

echo ==================== FOLDER STRUCTURE ====================
echo.
echo Your screenshots should be saved in:
echo   %~dp0screenshots\
echo.
echo Current folder exists: 
if exist "screenshots\" (
    echo   ✓ screenshots folder exists
) else (
    echo   ✗ screenshots folder does not exist
    echo   Creating it now...
    mkdir screenshots
    echo   ✓ screenshots folder created
)
echo.

echo ==================== QUICK ACTIONS ====================
echo.
echo What would you like to do?
echo 1. Open screenshots folder
echo 2. Run the application now
echo 3. View this guide again
echo 4. Exit
echo.

set /p choice="Enter your choice (1-4): "

if "%choice%"=="1" (
    if exist "screenshots\" (
        start "" "screenshots"
        echo Opening screenshots folder...
    ) else (
        echo Screenshots folder not found!
        pause
    )
    goto :reopen
) else if "%choice%"=="2" (
    echo Launching Community Health Tracking application...
    timeout /t 2 /nobreak >nul
    if exist "compile_and_run.bat" (
        call compile_and_run.bat
    ) else if exist "run" (
        call run
    ) else (
        echo Error: Could not find launcher script!
        pause
    )
    goto :reopen
) else if "%choice%"=="3" (
    cls
    call :main
) else if "%choice%"=="4" (
    exit
) else (
    echo Invalid choice!
    pause
    goto :reopen
)

:reopen
echo.
echo Press any key to return to the guide...
pause >nul
cls
call :main

:main
:: Main function called above
exit /b