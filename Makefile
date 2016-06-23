# 204728299 302860986
# salomor3 broyere1

compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*/*.java src/*.java
run: 
	java -cp biuoop-1.4.jar:bin:resources Ass7Game
jar: 
	jar cfm space-invaders.jar Manifest.mf -C bin . -C resources .
check:
	java -jar checkstyle-5.7-all.jar -c biuoop.xml src/*/*.java src/*.java
bin:
	mkdir bin
