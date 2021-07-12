# Author: Adam L. Rich
# Date:   July 3, 2016
#         April 24, 2018
# Description:
#
#   Analyze text file from Project Gutenberg 
#   to see how many words, letters, etc. there are
#


# Setup
library(magrittr)

freq_table <- function(f_in, f_out) {
  txt <- readLines(f_in)
  words_all <- strsplit(txt, ' ') %>% unlist %>% toupper %>% sort
  words_all <- words_all[words_all != '']
  words_all <- words_all[words_all != '--']
  chars_all <- strsplit(words_all, '') %>% unlist
  letters_all <- chars_all[chars_all %in% LETTERS]
  m <- letters_all %>% table %>% as.data.frame %>% as.matrix
  v <- apply(m, 1, paste, collapse = ' - ')
  writeLines(v, f_out)
}

freq_table('../input-raw/clear-bible.txt',       '../input/freq-bible.txt')
freq_table('../input-raw/clear-montana.txt',     '../input/freq-montana.txt')
freq_table('../input-raw/clear-toadstools.txt',  '../input/freq-toadstools.txt')

