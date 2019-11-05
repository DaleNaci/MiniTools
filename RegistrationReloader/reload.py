from pynput.mouse import Button, Controller
import threading as th
import time

mouse = Controller()

keep_going = True
def key_capture_thread():
    global keep_going
    input()
    keep_going = False

time.sleep(2)

def do_stuff():
    th.Thread(target=key_capture_thread, args=(), name='key_capture_thread', daemon=True).start()
    while keep_going:
        mouse.position = (84.9, 320.2)
        mouse.click(Button.left, 1)
        time.sleep(.1)
        mouse.position = (1392.2, 206.5)
        mouse.click(Button.left, 1)
        time.sleep(.1)

do_stuff()
