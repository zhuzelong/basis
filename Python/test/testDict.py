count=dict()
table=[1, 2, 3, 4, 5]
for i in table:
    count[i]='num'
print count
table_2=count.items()
for key, val in table_2:
    print key, val
