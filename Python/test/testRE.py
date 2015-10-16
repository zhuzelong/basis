import re

string='asdjva123as'
rexp='as+?'
result=re.findall(rexp, string)
print type(result)
print result
