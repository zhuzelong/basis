pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
hourDict=dict()
for line in fh:
    if not line.startswith('From '):
        continue
    words=line.split()
    time=words[5].split(':')  # truncate the time string and split it
    print time  # debug time
    if time[0] not in hourDict:
        hourDict[time[0]]=1
    else:
        hourDict[time[0]]+=1
fh.close()
hourList=hourDict.keys()
hourList.sort()
for i in hourList:
    print i, hourDict[i]
    
