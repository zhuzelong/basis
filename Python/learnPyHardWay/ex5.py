name='Zack'
age=26
height=180 # cm
weight=72 # kg
eyes='black'
teeth='white'
hair='black'

print "I've got %s eyes and %s hair." % (eyes, hair) # there must be a parathensis around the two arguments
print "My name is %s, I am %r years old" % (name, age) # if use %r, the output will be 'Zack', looks like verbatim; 
# if use %s, the output will be Zack, no quote marks because python compares it to a string.
