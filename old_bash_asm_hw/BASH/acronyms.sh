#!/bash/bin

acr=""

input=$(echo $1 | tr "[:lower:] [:upper:]" | tr -d "[:punct:]" | tr "-" " ") # da pismenka na uppercase vymaze interpunkcne znamienka a nahradi pomlcku medzerami

fo word in $input; do
    acr+="${word:0:1}"
done

echo acr