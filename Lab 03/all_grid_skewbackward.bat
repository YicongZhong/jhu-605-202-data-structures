@echo off

java -cp src\ Lab03 input\freq-skewbackward.txt    input\clear-bible.txt   output\bible-encoded-skewbackward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skewbackward.txt    input\clear-given.txt   output\given-encoded-skewbackward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skewbackward.txt    input\clear-montana.txt   output\montana-encoded-skewbackward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skewbackward.txt    input\clear-toadstools.txt   output\toadstools-encoded-skewbackward.txt    e   freq.txt


rm freq.txt