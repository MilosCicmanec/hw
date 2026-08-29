#!/bin/bash

alphabet="abcdefghijklmnopqrstuvwxyz"

input=$(echo "${1,,}" | grep -o [a-z] | sort | uniq | tr -d "\n")

if [[ "$input" == "$alphabet" ]]; then
    echo True 
else 
    echo False
fi