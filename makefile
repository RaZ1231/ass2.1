# 204728299 302860986
# salomor3 broyere1

compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*/*.java
run2:
	java -cp biuoop-1.4.jar:bin graphics/AbstractArtDrawing
run3.2:
	java -cp biuoop-1.4.jar:bin graphics/BouncingBallAnimation
run3.3:
	java -cp biuoop-1.4.jar:bin graphics/MultipleBouncingBallsAnimation 12 2 3 4 2 9
run3.4:
	java -cp biuoop-1.4.jar:bin graphics/MultipleFramesBouncingBallsAnimation 12 2 3 4 2 9
check:
	java -jar checkstyle-5.7-all.jar -c biuoop.xml src/*/*.java
bin:
	mkdir bin