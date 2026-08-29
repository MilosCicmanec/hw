#!/bin/bash

for ((i=0,i<${#1},i++)); do 
    (( s+= ${1:$i:1}**${#1} ))
done 
 
if [ "$s" -eq "$1"]; then
    echo True
else
    echo False
