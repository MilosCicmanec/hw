#!/bin/bash

N=$1

sum_of_numbers=$(( N * (N + 1) / 2 ))

square_of_sum=$(( sum_of_numbers * sum_of_numbers ))

sum_of_squares=$(( N * (N + 1) * (2 * N + 1) / 6 ))

difference=$(( square_of_sum - sum_of_squares ))

echo $difference
