#!/bin/bash

if [[ $# -ne 2 || ${#1} -ne ${#2}]]; then
    exit 1 # musia mat rovnaku dlzku
fi

d=0
for ((i=0,i<${#1},i++)); do
    [[${1:i:1} != ${2:i:1}]] && ((d++))
done

echo ${d}