# Othello
Othello/Reversi Terminal Game<br/>
by [Ryan J. Slater](https://github.com/rjslater2000/Othello)

## To Run:

### Windows
Ensure Java is installed<br/>
Extract "Othello - master.zip"<br/>
Inside the extracted folder is a folder called "Othello - master"<br/>
Cut this folder and paste it into C:/Program Files/<br/>
Rename the folder to "OthelloGame"<br/>
Double click on OthelloGame.bat.exe and trust the program to run

### Linux
cd to this directory, then run
`java -jar Othello.jar`<br/>
To make a .desktop file, follow [these](https://askubuntu.com/questions/64222/how-can-i-create-launchers-on-my-desktop) instructions<br/>
Set the name to "Othello"<br/>
Set the command to the command above (make sure to include the filepath from /home/)<br/>
Set the icon to othello.png (in the "Game" folder)<br/>
Make sure to put the .desktop file in ~/.local/share/applications/ to make it searchable

## Othello Information

Othello is a registered trademark of Tsukuda Original, licensed by Anjar Co., copyright 1973, 1990 Pressman Toy Corporation.
The rules given here are a direct transcription (including diagrams) of the rules included in the Pressman Toy Corporation version of the game sold in North America.

### Rules
These rules can be viewed in more detail [here](http://www.hannu.se/games/othello/rules.htm)

#### Objective
The object of the game is to have the majority of your color discs on the board at the end of the game

#### Moving
A move consists of "outflanking" your opponent's disc(s), then flipping the outflanked disc(s) to your color.

To outflank means to place a disc on the board so that your opponent's row (or rows) of disc(s) is bordered at each end by a disc of your color. (A "row" may be made up of one or more discs).

#### Othello Rules
1. Black always moves first.

2. If on your turn you cannot outflank and flip at least one opposing disc, your turn is forfeited and your opponent moves again. However, if a move is available to you, you may not forfeit your turn.

3. A disc may outflank any number of discs in one or more rows in any number of directions at the same time - horizontally, vertically or diagonally. (A row is defined as one or more discs in a continuous straight line)

4. You may not skip over your own color disc to outflank an opposing disc.

5. Discs may only be outflanked as a direct result of a move and must fall in the direct line of the disc placed down.

6. All discs outflanked in any one move must be flipped, even if it is to the player's advantage not to flip them at all.

7. A player who flips a disc which should not have been turned may correct the mistake as long as the opponent has not made a subsequent move. If the opponent has already moved, it is too late to change and the disc(s) remain as is.

8. Once a disc is placed on a square, it can never be moved to another square later in the game.

9. If a player runs out of discs, but still has an opportunity to outflank an opposing disc on his or her turn, the opponent must give the player a disc to use. (This can happen as many times as the player needs and can use a disc).

10. When it is no longer possible for either player to move, the game is over. Discs are counted and the player with the majority of his or her color discs on the board is the winner.

NOTE: It is possible for a game to end before all 64 squares are filled.
