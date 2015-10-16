from sys import argv

script, input_file=argv

def print_all(f):
    print f.read()

def rewind(f):
    f.seek(0)

def print_one_line(line_count, f):
    print line_count, f.readline()

fh=open(input_file)

print 'First print the whole file:\n'

print_all(fh)

print 'Now rewind to the start'

rewind(fh)

print 'Now print three lines'

current_line=1
print_one_line(current_line, fh)

current_line += 1
print_one_line(current_line, fh)

current_line += 1
print_one_line(current_line, fh)

