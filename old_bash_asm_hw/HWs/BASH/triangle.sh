#!/bin/bash

read -p "Side a: " a
read -p "Side b: " b
read -p "Side c: " c

if (( a == b && b == c )); then
    echo "Equilateral triangle"
elif (( a == b || b == c || a == c )); then
    echo "Isosceles triangle"
else
    echo "Scalene triangle"
fi