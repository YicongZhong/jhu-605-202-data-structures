@echo off
cls
java -cp src\ Lab01Application "input\%~1.txt" "output\%~1-result.txt"
start notepad++ "input\%~1.txt" "output\%~1-result.txt"
