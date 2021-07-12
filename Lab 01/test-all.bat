@echo off
for /F %%F in ('dir /b input\*.txt') do (
  test.bat "%%~nF"
)
