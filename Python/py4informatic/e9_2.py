pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
days=dict()
for line in fh:
    if not line.startswith('From'):
        continue
    words=line.split()
    #print type(words), len(words)
    #print words
    # there are two lines which correspond to the criteria, one of them does not contain the day, so use a try-except block to skip the unselected line
    try:
        if words[2] not in days:
            days[words[2]]=1
        else:
            days[words[2]]+=1
    except:
        continue
print days
fh.close()
