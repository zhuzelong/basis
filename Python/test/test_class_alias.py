class Toy(object):
    def __init__(self, name, color):
        self.name = name
        self.color = color

    def tostring(self):
        print 'name is', self.name,
        print 'color is', self.color


def change(toy):
    toy.name = 'substituted'
    toy.color = 'null'


toy = Toy('test', 'white')
print type(toy)
toy.tostring()

# make alias
dummy = toy
print type(dummy)
print dummy == toy
dummy.tostring()

change(dummy)
toy.tostring()  # toy has been changed in line 26
dummy.tostring()
