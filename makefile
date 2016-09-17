MAKEFLAGS += -rRs

.PHONY: all clean

all: opencv/build src/Main

%: %.class
	java $@

%.class: %.java
	javac $<

opencv/build:
	cd opencv && \
	mkdir build && \
	cd build && \
	cmake .. && \
	$(MAKE) -j8

clean:
	find src -name "*.class" -delete
