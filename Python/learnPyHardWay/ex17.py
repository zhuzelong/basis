from sys import argv
from os.path import exists

script, from_file, to_file = argv
out_file=open(to_file, 'w')
out_file.write(open(from_file).read())

out_file.close()
