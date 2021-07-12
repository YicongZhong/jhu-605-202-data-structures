@echo off

for /L %%I in (1,1,%1) do (
  if exist "output\tower-%%Ii.txt" del "output\tower-%%Ii.txt"
  echo Running interative for %%I...
  java -cp src\ Lab02 %%I "output\tower-%%Ii.txt" 0 "output\timings.txt"
  REM if exist "output\tower-%%Ii.txt" del "output\tower-%%Ii.txt"
)

edit "output\timings.txt"
