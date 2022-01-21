GraphConnected
Reads if a graph is connected or not
=====================================
5
a b
b c
c d
d e
e a
========================================================================
Above the line is an example of the format for what the inputfile.txt should consist of.
'5' being the number of edges.
'a' + ' ' + 'b' are connected and require a blank space in between to be read correctly.
The next set of edges should begin on a new line.

The desired input file should be directed in the data folder and the following line of code in Main.java should be altered to the desired inputfile.txt. For this current example, the file 'demo.txt' is being used.

	final String filename = "./data/demo.txt";

A test file has been included named 'demo_connected_cycle.txt'.
