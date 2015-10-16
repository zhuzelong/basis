class MyClass(object):
    i = 2.0
    __private = 1
    info = []

    def f(self):
        print "Hello World"

    def add_info(self, stuff):
        self.info.append(stuff)

# Test function.
instance = MyClass()
another_instance = MyClass()
MyClass.f(instance)

instance.add_info('Instance #1')
print instance.info, another_instance.info

another_instance.add_info('Instance #2')
print instance.info, another_instance.info, MyClass.info

# Test class variable.
instance.i = 3.0

print instance.i, another_instance.i, MyClass.i
print instance.__private
