# Middle-Earth: Shadows of Mordor

## Overview
Middle-Earth: Shadows of Mordor is a game very similar to the famous game "Clash of Clans". The
objective of this game is to protect the citadel from the oncoming army of Mordor. The player has
two states in this game:

1. Mithrils - the game currency used to deploy player units, and 
2. HP - the health points of the citadel.

To protect the citadel, the player must spend the 
mithrils and deploy units on the battlefield to resist the enemies. Every time the player wants to deploy a unit, he/she must first make sure that there are enough 
mithrils to deploy the unit. Next, the player should click on the button that corresponds to the unit
to be deployed, and then click on the bottom portion of the field to deploy the unit at the desired 
position. Once deployed, the battle units move according to an algorithm that determines the enemy 
that is closest to the unit. Once the units fall within range of each other, they transition into 
battle states and engage in combat without moving. (There are exceptions for battles against ranged/
special units.) Once the HP of the citadel reaches 0, the player loses and the game ends.
The player should attempt to survive as many waves of orc invasions as possible, since the number of
invasions he/she survived is saved after the game ends. For each wave of invasion, the rate at which
the enemy units spawn are increased according to an exponential model. Have fun playing!!

## Subtyping / Inheritance
Noting that all units in this game must have common attributes such as position or HP, I designed
a BattleUnit interface which sets a layout for methods such as getting/setting the position of a unit,
getting/setting the battle state of a unit, getting/setting the HP of a unit, etc. Under this
interface, I then created four abstract classes which implement the methods specified in the
BattleUnit interface. PlayerMilitia is the abstract class for children classes that are close-range,
mobile player units (infantry, rider, warrior, knight). PlayerRangedUnit is the abstract class for 
children classes that are long-range, static player units (archer, citadel). PlayerSpecialUnit is 
the abstract class for player units that are medium-range and mobile (ranger). Finally, EnemyMilitia
is the abstract class for children classes that are close-range, mobile enemy units (orc). In the
actual game program, the BattleUnit interface was used as the type for all objects in order to 
generalize the behavior of the units as much as possible.

## Collections
Collections are used to store the BattleUnit objects in this game because of the dynamic nature of
the game itself - the user deploys new units on the field with mouseclicks, the computer generates 
new enemy units on the field in random positions, and all units can be eliminated through battling
units of opposite sides. To keep track of the units that are present in the battle, I chose to use a
collection containing the BattleUnit objects I had defined as explained above.
Initially, I planned to use treemaps to store the BattleUnit objects, along with unique identifiers
that would differentiate between objects of the same class (e.g. an infantry from another infantry) 
for implementing the Comparable interface. However, I realized that I could use the identifier as a 
field inside the object, which would eliminate the need to use a map since I would only be storing
the BattleUnit objects themselves.
Therefore, I decided to use arraylists to store the state of the game. The first arraylist, called
'allPlayerUnits', stores all the BattleUnit objects that the player deploys on the field. The second
arraylist, called 'allEnemyUnits', stores all the BattleUnit (enemy) objects that the computer
deploys on the field. As explained, the static type of the arraylists is BattleUnit (an interface).
New units are added to the arraylists whenever the player or computer generates them on the field,
and units are deleted from the arraylists whenever they die from battle.

## File I/O
File I/O is used in this game to keep track of how many waves of enemy invasion the player is able
to survive. At the beginning of the game, the user is prompted to enter his/her nickname in the
command prompt. This nickname is saved to the game's internal state as a global variable. As the
game proceeds, the number of waves which the player survives is also saved in the game's internal
state. When the player loses, these two variables are written to a new line in a designated text
file, separated by a '$'.
When the player loads a new game, the contents of the file are processed by several methods in the
IOHandler class. One of the methods reads all the content of the text file into a treemap (with the
nicknames as the keys and number of waves survived as the values), and another method uses this
treemap to generate a string array containing the names of at most three players with the highest
scores. This, along with their respective scores, are shown on the top-right corner during the game
to motivate the player to put his/her name on the top scores dashboard.

## JUnit Testing
Noting that all the methods for the BattleUnit objects were well-defined within the internal state
of the game without much dependence of the actual GUI, I created tests that verified that my game
model was working as I had intended it to be. The tests check the following game logic
1. the movement behavior of the battle units as the game proceeds (in a simplified version)
2. the battle transition of units as the become within range of one another
3. whether the units actually meet to
engage in battle
4. the battle process of units for both dual combats and multiple combats
5. exceptional behavior for ranged units (including the citadel) and special units which behave 
differently from other units. 

These tests verified that the game model could be used outside of the 
GUI context and that the algorithms for the game's internal state functioned as desired.