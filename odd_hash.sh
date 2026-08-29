#!/bin/bash

#loop through the directory
for file in *; do
    #check if it is a file and not a folder
    if [ -f "$file" ]; then
        #calculate sha1 hash using sha1sum
        hash=$(sha1sum "$file" | awk '{print $1}')

        #get the last character of the hash
        last_char="${hash: -1}"

        #convert from hex to dec
        decimal_value=$((16#$last_char))

        #check if the the value is odd or even
        if ((decimal_value % 2 != 0)); then
            #delete odd
            echo "Deleting file '$file' because its hash is odd: $hash"
            rm "$file"
        else
            #even keep
            echo "Keeping file '$file' because its hash is even: $hash"
        fi
    else
        #if it isnt a file skip
        echo "Skipping '$file' because it's not a file."
    fi
done

