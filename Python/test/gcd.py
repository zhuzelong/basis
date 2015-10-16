"""
Use euclidean method to find out the greatest common divisor
"""


def gcd(x, y):
    m = x
    n = y
    while n != 0:
        remainder = m % n
        m = n
        n = remainder
    return m

if __name__ == '__main__':
    a = 414
    b = 662
    gcd = gcd(a, b)
    print 'The gcd of (414, 662) is %d' % gcd
