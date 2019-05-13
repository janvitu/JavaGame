## About

This little project was inspired by my adventure in **Dungeons and Dragons** 
It is also a semestral project for the Java class (4IT101). 

The goal of the game is to find a murder.


## Get started

1. Make sure you have Java Runtime Environment installed
    1. check simply by entering ``java -version`` in the command line 
        1. If nothing is found download Java [here](https://java.com/en/download/)
1. Open the command line and navigate to the directory where _StarWars.jar_ is located (/JavaGame/out/artifacts/JavaGame_Jar/).
1. Run command ``java -jar StarWars.jar`` and enjoy the game

## How to play

The game start with a greeting messeg and info.

Afterwards an interface with current game statistics will appear and it will look something like the following.
![UI_Start](/UI.png)

The game is created in Czech so the commands, comments and UI is in Czech too.

Every command is executed by enter if the comand require some parameters it will show the error message like "Bylo zadáno příliš mnoho parametrů" it means that you have entered too many parameters

### Map and enviroment

The enviroment has three floors the main floor, the upper floor and the basement.

The floors and ways are shown in the picture by the diagram.
![Map](/Map.png)

### Hints and exit

For hints you can always type ``napoveda``
Otherwise when you want to leave the game type ``konec`` it means Exit.

#### Other commands
1. command Mluv (it means talk)
    1. the command requires the name of character with which you want to talk.
    1. ``mluv name_of_character``
1. command Batoh (it shows you things in your backpack)
    1. the command does not require any more parameters.
    1. ``batoh``
1. command Jdi (it means go)
    1. this command requires one parameter the name of the direction
    1. ``jdi Name_of_direction``
1. command Konec (this command is described in **Hints and exit**)
    1. ``konec``
1. command Napoveda (this command is also described in **Hints and exit**)
    1. ``napoveda``
1. command Notes
    1. this command shows you the notes (all dialogs you have taken with another character). Also this command does not require any parameters.
    1. ``notes``
1. command Odemkni (it unlocks the room)
    1. the command will unlock the room if you have the key from it otherwise it will say that you do not have a key and which key you do not have.
    1. ``odemkni Room_name``
1. command Odhod (it throws away the thing from your bagpack)
    1. the command require name of **item** you want to remove from your backpack.
    1. ``odhod Name_of_thing``
1. command Prohledej (it serches the big things and put the small things from them into a room)
    1. the command require name of **big item** you want to serch
    1. ``prohledej Name_of_big_item``
1. command Rozhledni (it shows you the info about the room)
    1. the command does not require any parameters
    1. ``rozhledni``
1. command Seber (it puts the item into your backpack)
    1. be aware of the fact that the **bagpack is only 6 slot big** so if you want to put more things to it the game will show you the error message.
    1. the command require one parameter the name of **item** in the current room.
    1. ``seber Item_name``
1. command Zatkni (it will send someone to jail)
    1. the command require the name of character that you want to send into a jail
    1. if you use this command on wrong person you will lost
    1. ``zatkni Name_of_character``
