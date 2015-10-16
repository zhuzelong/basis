# text = "x-dspam-confidence:    0.8475"
text = raw_input('enter number: ')
text = text.strip(' ')
print text

pos = text.find(':')
num = float(text[pos+1:])
print num
