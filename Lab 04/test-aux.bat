@echo off
cls
REM java -cp src\ Lab04 "input\%~1.txt" "output\%~1-result.txt"
REM start notepad++ "input\%~1.txt" "output\%~1-result.txt"

del output\Test*-result.txt

java -cp src\ TestArrayStringParser  > output\TestArrayStringParser-result.txt
java -cp src\ TestIntegerSorter      > output\TestIntegerSorter-result.txt

edit output\Test*-result.txt

