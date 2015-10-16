# fileName=raw_input("Please enter the file name: ")
# fHand=open(fileName)
import os
path='/users/Zack/Dropbox/sourcecode/Python/txt/mbox-short.txt'
fhand=open(path, 'r')
spamNumber=0.0
count=0
for line in fhand:
    if line.startswith('X-DSPAM-Confidence:'):
        startPoint=line.find(':')
        spamNumber=spamNumber+float(line[startPoint+1:])
        count=count+1
print 'Average spam confidence:', spamNumber/count
