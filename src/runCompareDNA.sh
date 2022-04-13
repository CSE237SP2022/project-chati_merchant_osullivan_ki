#!/bin/bash/

FILENAME=$1

#FILENAME=$filename

javac compareDNA/runCompareDNA.java FILENAME
java compareDNA.runCompareDNA FILENAME


