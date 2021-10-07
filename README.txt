To run the program: 
Please type javac Main.java in terminal
And java Main


The game logic is implemented as instructed. However, there is a few things to clarify: 

Player can only have unique heroes in her team. If a hero already exists in her team, player will be asked to choose another one.

Once purchased, spell permanently exists in hero's inventory. Unlike potion, it is not single-use.

Fight sequence: for example if there's 2 heroes and 2 monsters in the cell, 1st hero acts first, then 1st monster will attack back to the first hero.
However, if the 1st monster became dead after 1st hero's action, the second monster will attack the first hero.
There will always be 1 hero turn and 1 monster turn.

I set the probability that monster appears in the common cell 50%.

I don't know how to achieve "the player should be able to quit at any time". Instead, whenever player moves to a new cell, it tells user what cell is it and asks user if she wants to quit. 

When in a fight, it will automatically show information about the heroes. When not in a fight, it will ask if player wants to see the info.

Other things to mention:
The line that prompts user for an input is in blue. If user enter invalid input, it will print "Invalid input". In most cases, it will asks again for valid input until there's one.
However, in order to get a smooth gameplay experience, please try to always give a valid input.

Users will be asked "which row is it" from time to time when selecting item.
     For example,  
.........................
Weapon
.................
Sword
Axe
................
Armor
...........
Shield
Boots

Say if user wants Shield.
It will first ask user something like"Type 1 for Weapon, 2 for Armor"
User enters 1.
It will then ask "which row is it?" It means the row under the type Armor.
So if to get shield, user needs to enter 1.

Some class design info:
1. Warriors, Paladin, Sorcerers are all subclasses of Hero
2. Dragon, Exoskeleton, Spirits are all subclasses of Monster
3. Hero and Monster are both subclasses to FightableCharacter
4. 3 types of cells are all subclasses to LegendsGameBoardCell
5. LegendsGameBoardCell constructs LegendsGameBoard
6. LegendsGameBoardCell extends from GameBoardCell, and LegendsGameBoard extends from GameBoard. These two abstract classes will be helpful for future extension.
7. LegendsMonsterAndHeroes extends from RPGGame. Again, the abstract class will help future extension
8. FightableCharacterGenerator and MerchandiseGenerator help converting info in provided txt files to objects.
9. Armor, Weapon, Spell, Potion, are subclasses to Merchandise, since they both have a price and can be traded.
10. Armor, Weapon implements Wearable. Potion implements Consumable. These two interface will be helpful for future extension.

For more info, please see class description and method description. Thank you so much!