pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
domainDict=dict()
for line in fh:
    if not line.startswith('From '):
        continue
    words=line.split()
    atPoint=words[1].find('@')
    domain=words[1][atPoint+1:]
    if domain not in domainDict:
        domainDict[domain]=1
    else:
        domainDict[domain]+=1
fh.close()
print domainDict
