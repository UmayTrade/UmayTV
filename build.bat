@echo off
setlocal

set PROJECT_DIR=%~dp0

echo ========================================
echo TurkuazTV Plugin Builder
echo ========================================

cd /d "%PROJECT_DIR%"
echo Derleme başlatılıyor...
.\gradlew.bat clean build :BelgeselX:packagePlugin

echo ========================================
echo Build tamamlandı. Çıktı:
echo %PROJECT_DIR%BelgeselX\build\release\BelgeselX.cs3
echo ========================================
pause