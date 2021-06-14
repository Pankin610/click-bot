# click-bot

Source code of the program prepared as semester project for Object-Oriented Programming course in Technical Computer
Science at the Jagiellonian University.

## Description

Using this application one can create in user-friendly way mini-programs, which
simulate usage of computer mouse and keyboard (and more). Some examples to explore are already implemented.
More commands and conditions can be found in Help > Glossary.

Originally application was meant to automate some repetitive tasks, which cannot
be easily done via command line because direct mouse-keyboard interaction is needed
(like refreshing the website, grinding in games). Since then, more functionalities were added.

## Installation

After copying repository and downloading JavaFX (16 preferably) you
should go to File > Project Structure in IntelliJ and add JavaFX to libraries.
All errors in code should gone.

Now, having that done, you can go to Main.java file and open Run > Edit Configurations
where Application Main should be visible. Now select Modify options > Add VM options
and paste there:
```
--module-path path\to\javafx-sdk-16\lib --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web
```

After that, project should compile nicely and start window of application should be shown.

## Project structure

_Main_ is starting file of whole project - loads information from files and load other structures.
Whole communication user-program is handler by Controllers, which communicate 
with WindowManager which is some sort of the command center of the GUI.

Programs can be implemented in project's pseudo-language, which structure can be found in
_lang_ file. Everything there was coded in such a way, that language is now easily expandable - adding new command
is matter of creating new file and overriding methods in similar fashion to already existing ones.
After that command should be added to _Commands_ enum, where also way of creating command via Graphic Mode can be specified
(if left non-implemented, still can be normally used, but adding this command 
to programs' code is possible only in text mode - however, if set up, command pattern should be already in Glossary).
More info can be found in comments inside corresponding abstract classes and interfaces - especially _CodeFragment_ and _Command_ interface.

Execution of program is handled via _Environments_, where specification of particular actions are implemented, for
example, in _Desktop Environment_ programs are using device's mouse and keyboard, but in _Console Environment_,
execution of programs is shown on console.

Saving and loading existing programs is implemented in corresponding containers for components of program.
They convert from one form to another (for example, from graphic-tree representation to text and vice-versa).
There are also additional wrappers in _files_ file, which handle direct communication with raw files.

## P.S.
Bug with Add Command button which occurred during presentation seems to be purely visual.
Additional checking confirmed that corresponding MenuItems still were inside MenuButton, but
for some reason, interface refused to show it. Some hard reset has been added so now it should work properly.