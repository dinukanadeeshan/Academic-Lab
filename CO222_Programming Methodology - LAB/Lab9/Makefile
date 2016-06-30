CC=gcc
CFLAGS=-Wall
CSRC=cipher.c vigenere.c
HSRC=vingenere.h
OBJ=$(CSRC:.c=.o)
BINARY=cipher

	
$(BINARY):$(OBJ)
	$(CC) $(CFLAGS) $(OBJ) -o $@
	
%.o:%.c	
	$(CC) $(CFLAGS) $< -c
	
%.o:%.c $(HSRC)
	$(CC) $(CFLAGS) $< -c

.PHONY:test
test:$(BINARY)
	./$< <test.dat


.PHONY: clean
clean:
	rm -f $(OBJ)

.PHONY:clobber	
clobber:	
	rm -f $(OBJ) $(BINARY)
	