#pathRoot='/users/Zack/Dropbox/sourcecode/Python/txt/'
#path=pathRoot+raw_input('Please enter the file name: ')
#try:
    #fh=open(path, 'r')
    #print type(fh)
#except:
    #print 'File cannot be opened.'
    #exit()
#for line in fh:
    #print line, type(line)
    #line=line.split()
    #print len(line), type(line)
#fh.close()

table = [1, 3, 5, 7, 9, 11, 13, 15]
print type(table)
count = 0
for i in table:
    print i, type(i)
    count += 1
    if count > 5 and count < 9:
        table.append(17)
        print table

# test iterator
it = 'i'
print it, type(it)
for it in table:
    print it, type(it)
print it, type(it)  # 'it' is changed by the for loop
