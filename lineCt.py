from glob import glob
lines = 0

for f in glob("*.java"):
	print("Counting:", f)
	lines += open(f).read().count("\n")

print("Total lines:", lines)
