pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
emailDict=dict()
for line in fh:
    if not line.startswith('From '):
        continue
    words=line.split()
    if words[1] not in emailDict:
        emailDict[words[1]]=1
    else:
        emailDict[words[1]]+=1
print emailDict
fh.close()

# find out the most frequent email
largest=0
for key in emailDict:
    if emailDict[key]>largest:
        maxKey=key
        largest=emailDict[key]
print maxKey, emailDict[maxKey]

# create a list of (count, email)
emailList=list()
for key in emailDict:
    emailList.append((emailDict[key], key))
print emailList
emailList.sort()
print emailList[-1][1], emailList[-1][0]  # sort the list to find the most frequent email
