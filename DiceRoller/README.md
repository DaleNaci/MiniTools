<h1>[2018-06-18] Challenge #364 [Easy] Create a Dice Roller</h1>
<h3>Description</h3>
<p>I love playing D&D with my friends, and my favorite part is creating character sheets (my DM is notorious for killing us all off by level 3 or so). One major part of making character sheets is rolling the character's stats. Sadly, I have lost all my dice, so I'm asking for your help to make a dice roller for me to use!</p>
<h2>Formal Inputs & Outputs</h2>
<h3>Input description</h3>
<p>Your input will contain one or more lines, where each line will be in the form of "NdM"; for example:</p>
3d6<br>
4d12<br>
1d10<br>
5d4<br>
<p>If you've ever played D&D you probably recognize those, but for the rest of you, this is what those mean:</p>

<p>The first number is the number of dice to roll, the d just means "dice", it's just used to split up the two numbers, and the second number is how many sides the dice have. So the above example of "3d6" means "roll 3 6-sided dice". Also, just in case you didn't know, in D&D, not all the dice we roll are the normal cubes. A d6 is a cube, because it's a 6-sided die, but a d20 has twenty sides, so it looks a lot closer to a ball than a cube.</p>

<p>The first number, the number of dice to roll, can be any integer between 1 and 100, inclusive.</p>

<p>The second number, the number of sides of the dice, can be any integer between 2 and 100, inclusive.</p>

<h3>Output description</h3>
<p>You should output the sum of all the rolls of that specified die, each on their own line. so if your input is "3d6", the output should look something like</p>

14

<p>Just a single number, you rolled 3 6-sided dice, and they added up to 14.</p>

<h3>Challenge Input</h3>

5d12<br>
6d4<br>
1d2<br>
1d8<br>
3d6<br>
4d20<br>
100d100<br>
<h3>Challenge Output</h3>

[some number between 5 and 60, probably closer to 32 or 33]<br>
[some number between 6 and 24, probably around 15]<br>
[you get the idea]<br>
[...]<br>
<h2>Notes/Hints</h2>

<p>A dice roll is basically the same as picking a random number between 1 and 6 (or 12, or 20, or however many sides the die has). You should use some way of randomly selecting a number within a range based off of your input. Many common languages have random number generators available, but at least a few of them will give the same "random" numbers every time you use the program. In my opinion that's not very random. If you run your code 3+ times with the same inputs and it gives the same outputs, that wouldn't be super useful for a game of D&D, would it? If that happens with your code, try to find a way around that. I'm guessing for some of the newer folks, this might be one of the trickier parts to get correct.</p>

<p>Don't just multiply your roll by the number of dice, please. I don't know if any of you were thinking about doing that, but I was. The problem is that if you do that, it eliminates a lot of possible values. For example, there's no way to roll 14 from 3d6 if you just roll it once and multiply by 3. Setting up a loop to roll each die is probably your best bet here.</p>

<h2>Bonus</h2>

<p>In addition to the sum of all dice rolls for your output, print out the result of each roll on the same line, using a format that looks something like</p>

14: 6 3 5<br>
22: 10 7 1 4<br>
9: 9<br>
11: 3 2 2 1 3<br>
<p>You could also try setting it up so that you can manually input more rolls. that way you can just leave the program open and every time you want to roll more dice, you just type it in and hit enter.</p>