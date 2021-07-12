@echo off
java -cp src\ Lab03 input\freq-backward.txt    input\clear-given.txt   output\given-encoded-backward.txt    e   output\freq-backward-analysis.txt    d
java -cp src\ Lab03 input\freq-bible.txt       input\clear-given.txt   output\given-encoded-bible.txt       e   output\freq-bible-analysis.txt       d
java -cp src\ Lab03 input\freq-given.txt       input\clear-given.txt   output\given-encoded-given.txt       e   output\freq-given-analysis.txt       d
java -cp src\ Lab03 input\freq-montana.txt     input\clear-given.txt   output\given-encoded-montana.txt     e   output\freq-montana-analysis.txt     d
java -cp src\ Lab03 input\freq-skew.txt        input\clear-given.txt   output\given-encoded-skew.txt        e   output\freq-skew-analysis.txt        d
java -cp src\ Lab03 input\freq-toadstools.txt  input\clear-given.txt   output\given-encoded-toadstools.txt  e   output\freq-toadstools-analysis.txt  d
java -cp src\ Lab03 input\freq-uniform.txt     input\clear-given.txt   output\given-encoded-uniform.txt     e   output\freq-uniform-analysis.txt     d

java -cp src\ Lab03 input\freq-backward.txt    input\clear-given.txt   output\given-encoded-m-backward.txt    e   output\freq-m-backward-analysis.txt    m
java -cp src\ Lab03 input\freq-bible.txt       input\clear-given.txt   output\given-encoded-m-bible.txt       e   output\freq-m-bible-analysis.txt       m
java -cp src\ Lab03 input\freq-given.txt       input\clear-given.txt   output\given-encoded-m-given.txt       e   output\freq-m-given-analysis.txt       m
java -cp src\ Lab03 input\freq-montana.txt     input\clear-given.txt   output\given-encoded-m-montana.txt     e   output\freq-m-montana-analysis.txt     m
java -cp src\ Lab03 input\freq-skew.txt        input\clear-given.txt   output\given-encoded-m-skew.txt        e   output\freq-m-skew-analysis.txt        m
java -cp src\ Lab03 input\freq-toadstools.txt  input\clear-given.txt   output\given-encoded-m-toadstools.txt  e   output\freq-m-toadstools-analysis.txt  m
java -cp src\ Lab03 input\freq-uniform.txt     input\clear-given.txt   output\given-encoded-m-uniform.txt     e   output\freq-m-uniform-analysis.txt     m

