import json

# NB: the quote around the element must be double quote
inp='''
[
    {"id": "001",
    "x": "2",
    "name": "Chuck"
    },
    {"id": "009",
    "x": "7",
    "name": "Brent"
    }
]'''

info=json.loads(inp)
print type(info), len(info)
print info
print '------------'

for item in info:
    print type(item)
    print item['name'], item['id'], item['x']
