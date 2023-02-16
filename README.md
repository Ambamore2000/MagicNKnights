# STORY

As part of my Application Development course, I led a team of 4 members to build a card turn-based game. This was one of my favorite projects, as it was the first project I worked with a team in a scrum manner. As the team leader, I organized tasks amongst the team, ensured everyone was on the same page, and assisted other members when needed. As a team, we planned out the project by prototyping and writing up a System Design Report which consisted of UML Diagrams, Interactions, and other necessary documentation needed prior to executing.

# BELOW HERE IS A PART OF AN ASSIGNMENT

## Feature To Implement
- Dynamic Loading of Levels (including enemies and rewards) with JSON files.

## Pseudocode

Looking into changing initializeObjects() function inside MapGraphics.java class to change as such:
```
Parse JSON File to read all levels information
Iterate through each level
  Load level image source, x, and y position
  Load level number
  Iterate through enemy
    Load enemy name
    Load enemy image source
    Load enemy hp, max hp, mana, max mana
    Iterate through enemy deck
      Load each card into deck
  Load level completed
  Iterate through reward
    Load gold reward
    Load card reward
```

## Testing Feature

In order to ensure everything was completed, I had initially output all the information about all levels on startup of the application.
However, other ways to test it is by playing the game and ensuring that:
  - The level has the right image, x, and y position
  - The enemy has the right name, image, hp, maxHp, mana, maxMana, and deck
  - The level is completed
  - The reward when killing the enemy is awarded correctly
To double check, it may be best to instead of outputting the information on loadup, load the information whenever each level is loaded.
