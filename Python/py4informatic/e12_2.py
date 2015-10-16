import socket
import re

myurl=raw_input('Please enter the url: ')
rexp='^http://([^/]+)'
hostName=re.findall(rexp, myurl)[0]
print hostName
mysock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
try:
    mysock.connect((hostName, 80))
    mysock.send('GET '+myurl+' HTTP/1.0\n\n')
except:
    print 'Please enter a valid url'
    mysock.close()
    exit()

count=0  # count the total chars received so far
output=0  # count the total chars printed so far
while True:
    data=mysock.recv(512)  # receive 512 char per time
    if len(data)<1:
        break
    count+=len(data)
    if count<=3000:
        print data
        output=count
    elif output<3000:
        print data[:3000-output]
        output=count
    else:
        continue
print 'Data received:', count
print 'Data printed:', output
mysock.close()

