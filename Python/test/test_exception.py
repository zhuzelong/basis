class B:
    pass


class C(B):
    pass


class D(C):
    pass


class E:
    pass


# Try exception: 'B, C, D' is expected
for c in [B, C, D]:
    try:
        raise c()
    except D:
        print 'D'
    except C:
        print 'C'
    except B:
        print 'B'


print '-'*20

# 'B B B' is expected
for e in [B, C, D, E]:
    try:
        raise e()
    except B:
        print 'B'
    except C:
        print 'C'
    except D:
        print 'D'
