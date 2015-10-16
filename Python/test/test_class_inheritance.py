class Map(object):
    def __init__(self, name):
        self.name = name
        self.item_list = []

    def update(self, iterable):
        for item in iterable:
            self.item_list.append(item)


class SubMap(Map):
    def update(self, keys, values):
        for item in zip(keys, values):
            self.item_list.append(item) 

# test
instance = SubMap('World Map')
print instance.name

instance.new_field = 100
print instance.new_field

key_list = [1, 2, 3]
value_list = ['one', 'two', 'three']
instance.update(key_list, value_list)
print instance.item_list
