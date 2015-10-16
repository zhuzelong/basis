string='X-DSPAM-Confidence: 0.8475'
startPoint=string.find(':')
print startPoint
number=float(string[startPoint+1:])
print number
