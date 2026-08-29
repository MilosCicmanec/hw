#!/bin/bash

phone_number=$1


cleaned_number=$(echo "$phone_number" | tr -cd '0-9')


if [[ ${cleaned_number:0:1} == "1" && ${#cleaned_number} -eq 11 ]]; then
    cleaned_number="${cleaned_number:1}"
fi

echo $cleaned_number