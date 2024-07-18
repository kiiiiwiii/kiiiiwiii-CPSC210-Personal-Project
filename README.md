# My Personal Project: situation puzzle

## Introduction

- What will the application do:

This application will be a reasoning game. Players are provided with a crime or a mysterious case. Players will be able 
to ask question that they want to know by selecting options given, the system will provide yes or no answer. 
Attempts are limited. After attempts are all used, players should retell the story by answering questions. 
If correct, an original story will be provided for players, and they can continue playing game; 
otherwise, players have to restart the game.

- Who will use it:

Potential users are people who love horror stories and love solving cases. 

- Why is this project of interest to you:

I love reading detective and mysterious novels, so I want to create a game for people who enjoy reading those stories
and enjoy the process of finding out the truth.

## User Story

- *As a user, I want to be able to select an evidence that I want to know about.*
- *As a user, I want to be able to store and check evidences I have so far.*
- *As a user, I want to be able to type answers.*
- *As a user, I want to be able to see attempts left.*
- *As a user, I want to be able to end the game.*
- *As a user, I want to be able to save my evidence history to files.*
- *As a user, I want to be able to reload my evidence history from file and resume the game.*


# Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by entering correct format of inquiry to ask,
then press 'ask' button to get answer back. Then the question you asked will be added to evidence history with 
corresponding answer.
- You can generate the second required action related to display Xs as Y by pressing 'Evidence History' button, this 
will show the list of evidences you have collected so far.
- You can locate my visual component by having empty evidence history and press 'Evidence History' button.
- You can save the state of my application by pressing 'save' button.
- You can reload the state of my application by pressing 'reload', and then press 'Evidence History', 
you evidence history will be shown.


Phase 4: Task 2

Tue Apr 04 18:26:11 PDT 2023
Added Suicide? to evidence history.

Tue Apr 04 18:26:16 PDT 2023
Added Stab? to evidence history.

Tue Apr 04 18:26:20 PDT 2023
Cleared evidence history.

Phase 4: Task 3

-I could have used iterator in evidencebook that reduces my coupling and increases cohesion of this project. 
-I could have called methods from Menu instead of wrote them again in GUI that increased coupling.
-I could have written an abstract class or interface for NewWindow and Default Frame to extends or implement since 
they actually have many similarities.
