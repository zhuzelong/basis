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

while True:
    data = mysock.recv(512)
    if ( len(data) < 1 ) :
        break
    print data;

mysock.close()
