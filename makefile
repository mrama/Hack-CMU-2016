MAKEFLAGS += -rRs

.PHONY: all clean

all: src/Main

%: %.class
	java $@

%.class: %.java
	javac $<

opencv:
	cd opencv && \
	cmake . && \
	$(MAKE) -j8

clean:
	find src -name "*.class" -delete
