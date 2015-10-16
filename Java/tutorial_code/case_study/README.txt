These are the solutions to the case study exercises. There is a folder for
each theme which has a case study module (the case study doesn't cover the
Collections and Streams themes, which have separate examples),

The parts of the case study for the Nuts and Bolts theme and the Classes theme
can be done in either order. If you do the Nuts and Bolts part first (which
I expect most people will do) you'll have the enhanced NumberSequence class to
go along with your SetOfNumberSequences class, otherwise you'll just have
the original one - it will work either way. I've included the original
version in the solution in order not to give away the solution to the Nuts
and Bolts part.

There is also a folder called gensim. This contains the code for the 
"general simulation framework", which you integerate with your code in the 
final part of the case study.

The code in gensim is in a package called gensim, which means that in order to
do the final part you'll need to set your CLASSPATH accordingly, e.g. if you're
using Windows and you've put this in C:\softdev\case_study you'll need to

set CLASSPATH=.;C:\softdev\case_study

However you only need to do this for the last part - for the rest you don't need
to worry about the CLASSPATH.