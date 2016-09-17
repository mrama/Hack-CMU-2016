MAKEFLAGS += -rRs

.PHONY: all clean

all: src/Main

%: %.class
	java $@

%.class: %.java
	javac $<

clean:
	find src -name "*.class" -delete
