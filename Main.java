import java.util.*;

// this is the runner!
class Main {
  public static void main(String[] args) {
    System.out.println(" ");
    askStart();
    ;
  }

  public static void askStart() {
    System.out.println("This is Country Hangman. enter 1 to begin, enter 2 for instructions");
    numberInput();
  }

  public static void numberInput() {
    Scanner sc = new Scanner(System.in);
    boolean valid = false;
    int input = 0;
    while (!valid) {
      if (sc.hasNextInt()) {
        input = sc.nextInt();
        //System.out.println("this works");
        if(input == 1 || input == 2){
          //valid = true;
          //System.out.println(input);
          break;
        }else {
          System.out.println("Not a legitimate number!");
      } 
      sc.next();
      }
    }
    if (input == 1) {
      //System.out.println("this works");
      Game game = new Game();
      game.startGame();
    } else if (input == 2) {
      printInstructions();
    }
  }

  public static void printInstructions() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println("How to play Hangman:");
    System.out
        .println("Enter a letter. If the letter is in the word, the spaces which countain the word will disappear");
    System.out.println("for example if you start off with ____ as your blank");
    System.out.println("you may want to guess a.");
    System.out.println("the Game will update the spaces: __A_");
    System.out.println("If you had guessed e, the spaces would have remained blank.");
    System.out.println("All the words are countries. In this case the answer was CHAD");
    System.out.println("You have 8 incorrect Guesses");
    System.out.println("Good Luck!");
    System.out.println(" ");
    System.out.println("Press 1 to start");
    numberInput();
  }  
}