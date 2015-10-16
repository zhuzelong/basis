counts=dict()
key=1
k=1
if key in counts:
    counts[key]+=1
else:
    counts[key]=1
print counts[key]
print '---------'

count2=dict()
count2[k]=count2.get(k, 0)+1
print count2[k]
