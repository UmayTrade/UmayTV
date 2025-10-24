@echo off
setlocal

set PROJECT_DIR=%~dp0

echo ========================================
echo UmayTv CloudStream Plugin Builder
echo ========================================

cd /d "%PROJECT_DIR%"
echo Derleme başlatılıyor...
.\gradlew.bat clean build :UmayTv:packagePlugin

echo ========================================
echo Build tamamlandı. Çıktı:
echo %PROJECT_DIR%UmayTv\build\release\UmayTv.cs3
pause