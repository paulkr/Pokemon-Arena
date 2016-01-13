#!/usr/bin/env python
#
# lineCt.py
# Paul Krishnamurthy
# Counts the number of lines in every java file

from glob import glob
lines = 0

for f in glob("lib/*.java"):
	print("Counting:", f)
	lines += open(f).read().count("\n")

print("\nTotal lines:", lines)
input()
