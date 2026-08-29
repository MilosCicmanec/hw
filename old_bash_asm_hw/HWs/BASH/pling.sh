#!/bin/bash

if (($1 % 3 == 0 )); then
	result+="Pling"
fi 

if (($1%5 == 0)); then 
	result+="Plang"
fi
if (($1 %7 == 0)); then 
	result+="Plong"
fi

echo ${result}