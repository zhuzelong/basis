import xml.etree.ElementTree as ET

inp='''
<stuff>
    <users>
        <user x='2'>
            <id>001</id>
            <name>Chuck</name>
        </user>
        <user x='7'>
            <id>009</id>
            <name>Brent</name>
        </user>
    </users>
</stuff>'''

stuff=ET.fromstring(inp)
print type(stuff)
node=stuff.find('users/user')
subnode=node.find('name')
print type(node)
print 'Node:', node
print '------'
print type(subnode)
print 'Subnode:',subnode
print '-------------------'

lst=stuff.findall('users/user')
print lst
print type(lst[0])
print '-------------------'

for item in lst:  
    # item is a type of 'class element' <user>
    print 'Name:', item.find('name').text, type(item.find('name'))
    print 'ID:', item.find('id').text, type(item.find('id'))
    print 'Attr:', item.get('x'), type(item.get('x'))
    print type(item)
