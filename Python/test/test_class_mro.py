class Shape:
    def __init__(self, shape_name, **kwds):
        self.shape_name = shape_name
        super().__init__(**kwds)


class ColoredShape(Shape):
    def __init__(self, color, **kwds):
        self.color = color
        super(ColoredShape, self).__init__(**kwds)

cs = ColoredShape(color = 'red', shape_name = 'circle')
