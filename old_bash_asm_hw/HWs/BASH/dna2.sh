#!/bin/bash

dna=$1
count_A=0
count_C=0
count_G=0
count_T=0

for (( i=0; i<${#dna}; i++ )); do
    nucleotide="${dna:i:1}"

    
    if [ "$nucleotide" == "A" ]; then
        ((count_A++))
    elif [ "$nucleotide" == "C" ]; then
        ((count_C++))
    elif [ "$nucleotide" == "G" ]; then
        ((count_G++))
    elif [ "$nucleotide" == "T" ]; then
        ((count_T++))
    fi
done

echo "'A': $count_A, 'C': $count_C, 'G': $count_G, 'T': $count_T"