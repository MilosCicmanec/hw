#!/bin/bash

if [[ -z "$1" || "$1" =~ ^[[:space:]]*$ ]]; then 
    echo "Fine. Be that way!"
elif [[ "$1" =~ [A-Z] && "$1" == *\? ]]; then
    echo "Calm down, I know what I'm doing!"
elif [[ "$1" =~ [A-Z] ]]; then
    echo "Whoa, chill out!"
elif [[ "$1" == *\? ]]; then 
    echo "Sure."
else
    echo "Whatever."
fi
