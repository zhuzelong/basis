import urllib
from BeautifulSoup import *

url = raw_input('Enter - ')
html = urllib.urlopen(url).read()
soup = BeautifulSoup(html)

count=0

# Retrieve all of the anchor tags
tags = soup('p')
for tag in tags:
    count+=1
print 'number of paragraph:', count
