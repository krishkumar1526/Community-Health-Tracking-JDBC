@echo off
cls
echo ==========================================
echo   COMMUNITY HEALTH TRACKING SYSTEM
echo   JDBC Database Application
echo ==========================================
echo.

echo Checking MySQL Connector...
if not exist "lib\mysql-connector-j-9.5.0.jar" (
    echo ERROR: MySQL Connector not found in lib folder!
    echo Please download from: https://dev.mysql.com/downloads/connector/j/
    pause
    exit /b 1
)

echo Compiling Java files...
javac -cp "lib\mysql-connector-j-9.5.0.jar" -d . src\*.java

if errorlevel 1 (
    echo.
    echo COMPILATION FAILED!
    echo Please check:
    echo 1. MySQL password in DBConnection.java
    echo 2. All Java files are in src/ folder
    pause
    exit /b 1
)

echo.
echo Starting application...
echo ==========================================
echo.
java -cp ".;lib\mysql-connector-j-9.5.0.jar" src.MainApp

echo.
pause