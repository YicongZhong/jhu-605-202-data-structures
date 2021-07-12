@echo off

for /L %%I in (1,1,%1) do (
  if exist "output\tower-%%Ir.txt" del "output\tower-%%Ir.txt"
  echo Running recursive for %%I...
  java -cp src\ Lab02 %%I "output\tower-%%Ir.txt" 1 "output\timings.txt"
  REM if exist "output\tower-%%Ir.txt" del "output\tower-%%Ir.txt"
)

edit "output\timings.txt"
