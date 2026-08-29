#!/bin/bash


seconds_in_ey=31557600
planets=("Mercury" "Venus" "Earth" "Mars" "Jupiter" "Saturn" "Uranus" "Neptune")
orbital_periods=(0.2408467 0.61519726 1.0 1.8808158 11.862615 29.447498 84.016846 164.79132)
age_in_seconds=$1

earth_years=$(echo "$age_in_seconds / $seconds_in_ey" | bc -l)

for i in "${!planets[@]}"; do
    planet=${planets[$i]}
    orbital_period=${orbital_periods[$i]}
    
   
    planet_age=$(echo "$earth_years / $orbital_period" | bc -l)

   
    planet_age_rounded=$(echo "$planet_age + 0.5" | bc | cut -d'.' -f1)

    echo "Age on $planet: $planet_age_rounded years"
done
