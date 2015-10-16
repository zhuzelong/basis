pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
path=pathRoot+raw_input('Please enter the file name: ')
try:
    fh=open(path, 'r')
except:
    print 'File cannot be opened.'
    exit()
wordsRecord=dict()
# create a dict and store the single word as a key in the dict
for line in fh:
    words=line.split()
    for word in words:
        wordsRecord[word]=''
fh.close()
# prompt user to enter a word to test if the word exists
searchWord=raw_input("Please enter a word to see if it exists in 'words.txt': ")
if searchWord in wordsRecord:
    print 'The word exists.'
else:
    print 'The word does not exist.'
