import keyboard
import time

i = 1

while True:
    time.sleep(61)
    keyboard.write(str(i))
    keyboard.send('enter')

    i += 1
