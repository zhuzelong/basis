import re

pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
#rexp=raw_input('Please enter a regular expression: ')
rexp='^New Revision: ([0-9]+)'
total=0
count=0
for line in fh:
    try:
        result=re.findall(rexp, line)  # result is a list of string which contains one element, list cannot be floated, so use an index to access the string to be floated
        if len(result)!=0:
            total+=float(result[0])
            count+=1
    except:
        print 'Please enter a valid regular expression.'
        fh.close()
        exit()
print 'average is', total/count
fh.close()
