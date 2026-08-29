#!/bin/bash

two_fer(){
    if [ -z $1 ]; then
        echo "One for you, one for me"
    else
        echo "One for $1, one for me"
    fi
}

two_fer Milos
two_fer Noel
two_fer 
