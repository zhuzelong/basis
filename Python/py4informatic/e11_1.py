import re

pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
fileName=raw_input('Please enter the file name: ')
path=pathRoot+fileName
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
rexp=raw_input('Please enter a regular expression: ')
count=0
for line in fh:
    try:
        if re.search(rexp, line):
            count+=1
    except:
        print 'Pleas enter valid regular expression.'
        exit()
print fileName, 'had', count, 'lines that matched', rexp 
