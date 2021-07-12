@echo off
cls
setlocal

REM From 
REM   https://www.dostips.com/forum/viewtopic.php?t=3679
for %%F in ("src\IntegerSorter.class") do set label=%%~tF
set fInput="input\given-%1-%2.dat"

echo.
echo.Running sort comparison for 
echo.  file size = %1
echo.  file suffix = %2

del output\given-%1-%2-*.dat

if exist %fInput% (
  java -cp src\ Lab04 %fInput% output\ given-%1-%2 timings.txt "Compiled at %label%"    
) else (
  echo.  ERROR: %fInput% does not exist...
)
echo.

