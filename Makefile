

compile:
	javac *java

gui:
	-appletviewer t.html

clean:
	@-/bin/rm *.class xd xd~

print:
	a2ps --delegate=no -T 4 -q -Avirtual -2 -o xd GUIView.java TTY.java View.java GameBoard.java Block.java

