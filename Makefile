# 204728299 302860986
# salomor3 broyere1

compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*/*.java
run:
	java -cp biuoop-1.4.jar:bin art/Ass5Game 1 2 3 4
jar:
	jar cfm ass5game.jar Manifest.mf -C bin .
check:
	java -jar checkstyle-5.7-all.jar -c biuoop.xml src/*/*.java
bin:
	mkdir bin