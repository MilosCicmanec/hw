#!/bin/bash

word="$1"
score=0


for ((i=0; i<${#word}; i++)); do
    letter="${word:i:1}"
    letter="${letter,,}"  # aby sme sa vyhli case sensitivity

    
    if [[ "$letter" == "a" || "$letter" == "e" || "$letter" == "i" || "$letter" == "o" || "$letter" == "u" || "$letter" == "l" || "$letter" == "n" || "$letter" == "r" || "$letter" == "s" || "$letter" == "t" ]]; then
        score=$((score + 1))  
    elif [[ "$letter" == "d" || "$letter" == "g" ]]; then
        score=$((score + 2))  
    elif [[ "$letter" == "b" || "$letter" == "c" || "$letter" == "m" || "$letter" == "p" ]]; then
        score=$((score + 3))  
    elif [[ "$letter" == "f" || "$letter" == "h" || "$letter" == "v" || "$letter" == "w" || "$letter" == "y" ]]; then
        score=$((score + 4))  
    elif [[ "$letter" == "k" ]]; then
        score=$((score + 5))  
    elif [[ "$letter" == "j" || "$letter" == "x" ]]; then
        score=$((score + 8))  
    elif [[ "$letter" == "q" || "$letter" == "z" ]]; then
        score=$((score + 10))  
    fi
done

echo $score