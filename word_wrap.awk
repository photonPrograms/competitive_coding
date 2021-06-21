# input: a text file with one or more records.
# output: the file formatted to print a maximum of n visible characters
# per line and wrap the rest to the next line

BEGIN { n = 20 }

{ printer($0, 1, n) }

function printer(str, start, max) {
	stop = max
	i = 1
	flag = 0
	while (i <= length(str)) {
		ch = substr(str, i, 1)
		if (i > max) {
			block1 = substr(str, start, stop)
			print block1
			block2 = substr(str, stop + 1)
			printer(block2, 1, max)
			flag = 1
			break
		}
		if (ch == " " || ch == "\t")
			stop = i
		i++
	}
	if (!flag)
		print str
}
