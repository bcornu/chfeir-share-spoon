BadCalculator="/home/bcornu/workspace/sfeir/share/spoon/testRecrutement/java/badCalculator/src/"

spoon-base=java -classpath target:lib/spoon-core-5.5.0-jar-with-dependencies.jar spoon.Launcher -i $(BadCalculator) --level WARN

clean:
	@rm -rf spooned/*
	@rm -rf target/*

install: clean
	@javac src/main/java/com/sfeir/*/*.java -classpath lib/spoon-core-5.5.0-jar-with-dependencies.jar -d target

spoon1: install
	@$(spoon-base) -p com.sfeir.processors.MyFirstAnalyzer

spoon-gui: install
	@$(spoon-base) -g

mkdirs:
	@mkdir -p spooned
	@mkdir -p target

init: mkdirs install
