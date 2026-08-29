#!/bin/bash

total=0

for ((i=1; i<=64; i++))
do
    total=$(( total + 2 ** (i - 1) ))
done

square=$1
echo $(( 2 ** (square - 1)))
echo $total