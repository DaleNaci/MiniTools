from pynput.mouse import Button, Controller
from pynput.keyboard import Key, Listener
import time

mouse = Controller()

time.sleep(2)

while True:
    mouse.position = (84.9, 320.2)
    mouse.click(Button.left, 1)
    time.sleep(.1)
    mouse.position = (1392.2, 206.5)
    mouse.click(Button.left, 1)
    time.sleep(.1)
