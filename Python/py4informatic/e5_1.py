average=0.0
total=0.0
count=0
max=0.0
min=0.0
number=raw_input('Enter a number: ')
while number!='done':
    try:
        number=float(number)
    except:
        print 'Invalid input'
    count=count+1
    total=total+number
    if(number>max):
        max=number
    elif(number<min):
        min=number
    else:
        number
    number=raw_input('Enter a number: ')
average=total/count
print 'The sum is', total
print 'The count is', count
print 'The average is', average
print 'maximum is', max
print 'minimum is', min
