def test_while(i, step):
    numbers = []
    while i<6:
        print "At the top i is %d" % i
        numbers.append(i)

        i = i + step
        print "Numbers now: ", numbers
        print "At the bottom i is %d" % i
    return numbers

numbers = test_while(1, 2)
print numbers
    
