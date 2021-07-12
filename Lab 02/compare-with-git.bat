@echo off

for /L %%I in (1,1,10) do (
  
  cls
  echo.Iterative versus Recursive, n = %%I
  echo.
  echo.
  git diff --no-index "output\tower-%%Ii.txt" "output\tower-%%Ir.txt"
  echo.
  echo.
  pause
  
)

