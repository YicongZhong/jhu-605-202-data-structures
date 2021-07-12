@echo off
cls

setlocal

if "%~3"=="e" (
  set instem=clear
  set outstem=encoded
) else (
  set instem=encoded
  set outstem=clear
)

set freqin=input\freq-%1.txt
set infile=input\%instem%-%2.txt
set outfile=output\%2-%outstem%-%1.txt
set freqout=output\freq-%1-analysis.txt
set abort=0

if exist "%freqin%" set freqin_exists=1
if exist "%infile%" set infile_exists=1


echo.Parameters...
echo.  Method   %3
echo.  FreqIn   %freqin%
echo.  FreqOut  %freqout%
echo.  MsgIn    %infile%
echo.  MsgOut   %outfile%
if not exist "%freqin%" (
  echo.    FreqIn file does not exist!
  set abort=1
)
if not exist "%infile%" (
  echo.    MsgIn file does not exist!
  set abort=1
)
echo.

if %abort%==1 goto EOF


java -cp src\ Lab03 %freqin% %infile% %outfile% %3 %freqout%
start notepad++ %outfile% %freqout% %infile%


:EOF