class Parent(object):
    def override(self):
        print "PARENT override()"

    def implicit(self):
        print "PARENT implicit()"

    def altered(self):
        print "PARENT altered()"

class Child(Parent):
    def override(self):
        print "Child override()"

    def altered(self):
        print "Child, before PARENT altered()"
        super(Child, self).altered()
        print "Child, after PARENT altered()"

dad = Parent()
son = Child()

dad.implicit()
son.implicit()

dad.override()
son.override()

dad.altered()
son.altered()

