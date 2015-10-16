def computepay():
    try:
        score=float(raw_input('Enter score: '))
        if score<0.0 or score>1.0:
            print 'Bad score, pleare verify the score which should be between 0.0 and 1.0'
        if score>=0.9:
            grade='A'
        elif score>=0.8:
            grade='B'
        elif score>=0.7:
            grade='C' 
        elif score>=0.6:
            grade='D'
        else:
            grade='F'
        print 'The grade is', grade
    except:
        print 'Please enter a valid numeric score.'

computepay()
