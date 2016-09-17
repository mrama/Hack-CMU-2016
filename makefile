MAKEFLAGS += -rRs
CLASSPATH = .:opencv/build/bin/opencv-2413.jar
LIBPATH = opencv/build/lib

.PHONY: all clean

all: opencv/build src/Main

%: %.class
	java -cp $(CLASSPATH) -Djava.library.path=$(LIBPATH) $@

%.class: %.java
	javac -cp $(CLASSPATH) $<

opencv/build:
	cd opencv && \
	mkdir build && \
	cd build && \
	cmake .. && \
	$(MAKE) -j8

clean:
	find src -name "*.class" -delete
