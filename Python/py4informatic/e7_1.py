fileName=raw_input("Please enter the file name: ")
fHand=open(fileName)
for line in fHand:
    print line.upper()

