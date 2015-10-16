def chop(inputList):
    del inputList[0]
    del inputList[len(inputList)-1]
# the function returns none

def middle(inputList):
    return inputList[1:len(inputList)-2]
# the function does not modify the original list but return a new list

inputList=list()
while True:
    inp=raw_input('Enter an element: ')
    if inp.upper()=='DONE':
        break
    inputList.append(inp)
#chop(inputList)
newList=middle(inputList)
#print inputList
print newList
