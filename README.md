**********Getting started**********
-

Importing this framework to your project (for IntelliJ):

- Create a new project
- Select file -> project structure
- Select libraries -> add new project library -> java
- Then select the JavaCards.jar file

For other IDE, I guess it would be pretty similar. The source files are also included (Eclipse has some issues when they are not included).


**********Using the framework**********

There are two ways to use the framework

1. make a class and inherit from the Game class. It would be smart to read the JavaDocs about the Player and Game class.
They can be difficult to understand at first, but once you understand it will save a lot of time making games.

example: 

    public class YourGame extends Game {
        
        + here you create the properties needed for your specific game
        
        public YourGame(params for your game, if extra is needed){
            super()
            this.yourProperty = param
        }
        
        @override
        start(){
            Here you implement the game loop, and logic
        }

        functionsIfYouLike(){}

        functionsIfYouLike(){}
        
    }
Then you go to main and instantiate the game:

    public static void main(String[] args) {
        YourGame game = new YourGame();
        game.start();
    }

2. You can implement everything yourself using only the Deck and Card class, 
this would be a lot more work but this framework may not fit your game.


3. There are War and Blackjack built in as examples.

How to instantiate them:

Blackjack:
    
    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.start();
    }

War:

    public static void main(String[] args) {
        WarConsole game = new WarConsole();
        game.start();
    }



    
    
