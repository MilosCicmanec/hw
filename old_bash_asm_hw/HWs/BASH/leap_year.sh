#!/bin/bash

if (( year % 4 == 0 )); then
    if (( year % 100 == 0 )); then
        if (( year % 400 == 0 )); then
            echo "$year is a leap year!"
        else
            echo "$year is not a leap year."
        fi
    else
        echo "$year is a leap year!"
    fi
else
    echo "$year is not a leap year."
fi