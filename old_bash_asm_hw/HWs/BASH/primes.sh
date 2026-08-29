#!/bin/bash

n=$1
    
sieve=()
for ((i=0; i<=n; i++)); do
    sieve[$i]=1
done
sieve[0]=0 
sieve[1]=0  

for ((i=2; i*i<=n; i++)); do
    if (( sieve[$i] == 1 )); then
        for ((j=i*i; j<=n; j+=i)); do
            sieve[$j]=0 
        done
    fi
done


echo $n
for ((i=2; i<=n; i++)); do
    if (( sieve[$i] == 1 )); then
        echo -n "$i "
    fi
done
