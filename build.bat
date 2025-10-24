@echo off
setlocal

set PROJECT_DIR=%~dp0

echo ========================================
echo UmayTv CloudStream Plugin Builder
echo ========================================

cd /d "%PROJECT_DIR%"
echo Derleme başlatılıyor...
.\gradlew.bat clean build assembleRelease

echo ========================================
echo Build tamamlandı. Çıktılar:
dir /s *.cs3
pause
