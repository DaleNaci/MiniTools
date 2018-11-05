from mss import mss
from PIL import Image
import pytesseract
from pynput.mouse import Button, Controller
import time

time.sleep(2)

mouse = Controller()

found = False;
while not found:
	with mss() as sct:
		filename = sct.shot()
	words = pytesseract.image_to_string(Image.open(filename))
	if ("MATCH" in words):
		print("Match Found!")
		found = True
		mouse.position = (631, 601)
		time.sleep(.2)
		mouse.click(Button.left, 1)
	else:
		print("Searching...")

#CSGO = (643, 374)
#LOL = (631, 601)
