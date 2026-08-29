#!/bin/bash

if (($# == 1)); then 
    echo "Hello $1"
    exit 0
else 
    echo "Error handling"
    exit 1
fi