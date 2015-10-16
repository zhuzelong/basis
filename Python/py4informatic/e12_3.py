import urllib
import re

myurl=raw_input('Please enter the url: ')
rexp='^http://([^/]+)'
#hostName=re.findall(rexp, myurl)[0]
#print hostName
try:
    fh=urllib.urlopen(myurl)
except:
    print 'Please enter a valid url'
    fh.close()
    exit()

data=fh.read()
print type(data), len(data)
print data[:3000]
fh.close()
