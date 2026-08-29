#!/bin/bash

input=$1

cleaned_input=$(echo "$input" | tr -d '[:space:]-' | tr '[:upper:]' '[:lower:]')

unique_input=$(echo "$cleaned_input" | fold -w1 | sort | uniq | tr -d '\n')

if [[ ${#cleaned_input} -eq ${#unique_input} ]]; then
    echo "True"
else
    echo "False"
fi