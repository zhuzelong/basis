import string

pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
letterCount=dict()
for line in fh:
    line=line.translate(None, string.punctuation)
    line=line.strip()
    line=line.lower()
    print type(line), line
    for ch in line:
        if ch not in letterCount:
            letterCount[ch]=1
        else:
            letterCount[ch]+=1
fh.close()
letterList=list()
for key, val in letterCount.items(): 
    letterList.append((val, key))  # in order to sort by val (frequency), val have to be the first element of tuple
letterList.sort(reverse=True)
for key, val in letterList:
    print key, val
