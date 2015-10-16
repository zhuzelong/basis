try:
    hours=int(raw_input('Enter Hours: '))
    rate=float(raw_input('Enter Rate: '))
    if hours>40:
        pay=(hours-40)*1.5*rate+400.0
    else:
        pay=hours*rate
    print 'Pay: ', pay
except:
    print 'Error, please enter numeric input.'
