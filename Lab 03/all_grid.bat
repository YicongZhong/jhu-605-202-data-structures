@echo off

java -cp src\ Lab03 input\freq-backward.txt    input\clear-bible.txt   output\bible-encoded-backward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-backward.txt    input\clear-given.txt   output\given-encoded-backward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-backward.txt    input\clear-montana.txt   output\montana-encoded-backward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-backward.txt    input\clear-toadstools.txt   output\toadstools-encoded-backward.txt    e   freq.txt
java -cp src\ Lab03 input\freq-bible.txt    input\clear-bible.txt   output\bible-encoded-bible.txt    e   freq.txt
java -cp src\ Lab03 input\freq-bible.txt    input\clear-given.txt   output\given-encoded-bible.txt    e   freq.txt
java -cp src\ Lab03 input\freq-bible.txt    input\clear-montana.txt   output\montana-encoded-bible.txt    e   freq.txt
java -cp src\ Lab03 input\freq-bible.txt    input\clear-toadstools.txt   output\toadstools-encoded-bible.txt    e   freq.txt
java -cp src\ Lab03 input\freq-given.txt    input\clear-bible.txt   output\bible-encoded-given.txt    e   freq.txt
java -cp src\ Lab03 input\freq-given.txt    input\clear-given.txt   output\given-encoded-given.txt    e   freq.txt
java -cp src\ Lab03 input\freq-given.txt    input\clear-montana.txt   output\montana-encoded-given.txt    e   freq.txt
java -cp src\ Lab03 input\freq-given.txt    input\clear-toadstools.txt   output\toadstools-encoded-given.txt    e   freq.txt
java -cp src\ Lab03 input\freq-montana.txt    input\clear-bible.txt   output\bible-encoded-montana.txt    e   freq.txt
java -cp src\ Lab03 input\freq-montana.txt    input\clear-given.txt   output\given-encoded-montana.txt    e   freq.txt
java -cp src\ Lab03 input\freq-montana.txt    input\clear-montana.txt   output\montana-encoded-montana.txt    e   freq.txt
java -cp src\ Lab03 input\freq-montana.txt    input\clear-toadstools.txt   output\toadstools-encoded-montana.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skew.txt    input\clear-bible.txt   output\bible-encoded-skew.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skew.txt    input\clear-given.txt   output\given-encoded-skew.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skew.txt    input\clear-montana.txt   output\montana-encoded-skew.txt    e   freq.txt
java -cp src\ Lab03 input\freq-skew.txt    input\clear-toadstools.txt   output\toadstools-encoded-skew.txt    e   freq.txt
java -cp src\ Lab03 input\freq-toadstools.txt    input\clear-bible.txt   output\bible-encoded-toadstools.txt    e   freq.txt
java -cp src\ Lab03 input\freq-toadstools.txt    input\clear-given.txt   output\given-encoded-toadstools.txt    e   freq.txt
java -cp src\ Lab03 input\freq-toadstools.txt    input\clear-montana.txt   output\montana-encoded-toadstools.txt    e   freq.txt
java -cp src\ Lab03 input\freq-toadstools.txt    input\clear-toadstools.txt   output\toadstools-encoded-toadstools.txt    e   freq.txt
java -cp src\ Lab03 input\freq-uniform.txt    input\clear-bible.txt   output\bible-encoded-uniform.txt    e   freq.txt
java -cp src\ Lab03 input\freq-uniform.txt    input\clear-given.txt   output\given-encoded-uniform.txt    e   freq.txt
java -cp src\ Lab03 input\freq-uniform.txt    input\clear-montana.txt   output\montana-encoded-uniform.txt    e   freq.txt
java -cp src\ Lab03 input\freq-uniform.txt    input\clear-toadstools.txt   output\toadstools-encoded-uniform.txt    e   freq.txt


rm freq.txt