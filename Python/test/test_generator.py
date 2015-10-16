def reverse(data):
    for index in range(len(data) - 1, -1, -1):
        yield data[index]

print reverse('python')
print type(reverse('python'))

for char in reverse('python'):
    print char,
