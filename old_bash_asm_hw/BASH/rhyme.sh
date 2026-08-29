#!/bin/bash

input_list=("$@")


length=${#input_list[@]}


for ((i=0; i<$length-1; i++)); do
    echo "For want of a ${input_list[$i]} the ${input_list[$((i+1))]} was lost."
done


echo "And all for the want of a ${input_list[0]}."