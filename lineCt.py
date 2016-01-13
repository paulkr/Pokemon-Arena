#!/usr/bin/env python
#
# lineCt.py
# Paul Krishnamurthy
# Counts the number of lines in every java file

from glob import glob
lines = 0

for f in glob("*.java"):
	print("Counting:", f)
	lines += open(f).read().count("\n")

print("Total lines:", lines)
