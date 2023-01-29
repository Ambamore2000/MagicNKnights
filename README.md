# groupproject-team-1-b-aj
groupproject-team-1-b-aj created by GitHub Classroom

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
