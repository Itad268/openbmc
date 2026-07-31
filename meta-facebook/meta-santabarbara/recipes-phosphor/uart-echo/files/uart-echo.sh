#!/bin/sh

SERIAL_PORT="/dev/ttyS3"

stty -F "$SERIAL_PORT" 9600 raw -echo cs8 -cstopb -parenb -crtscts

while true; do
    if read -r line < "$SERIAL_PORT"; then
        # 判斷是否為空行（只包含空白或沒字）
        if [ -n "$(echo "$line" | tr -d '[:space:]')" ]; then
            printf '%s\n' "$line" > "$SERIAL_PORT"
        fi
    fi
    sleep 1
done
