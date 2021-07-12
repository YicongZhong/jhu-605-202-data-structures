@echo off

setlocal

if "%~2"=="0" set suffix=i
if "%~2"=="1" set suffix=r

set out="output\tower-%~1%suffix%.txt"

if "%~3"=="" (
  set timings="output\timings.txt"
) else (
  set timings="%~3"
)

if exist %out% (
  del %out%)

java -cp src\ Lab02 "%~1" "output\tower-%~1%suffix%.txt" "%~2" %timings%

if exist %out% (
  edit %out%
  edit %timings%)

