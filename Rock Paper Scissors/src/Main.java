import java.util.Scanner;
public class Main {
    public static void main(String args[]){
//      Variables
        String playText = "Let's play Rock, Paper, Scissors!";
        String chooseText = "Type 'r' for rock, 'p' for paper, or 's' for scissors:";
        String invalidChoiceText = "Invalid selection, please play again.";
        String rockInput = "r";
        String paperInput = "p";
        String scissorsInput = "s";
        String rock = "Rock";
        String paper = "Paper";
        String scissors = "Scissors";
        String playerPick;
        String computerPick;
        String drawText = "You Draw!";
        String winText = "You Win!";
        String loseText = "You Lose!";
        String pChoiceText = "Player: ";
        String cChoiceText = " :Computer";


//      Creating scanner
        Scanner scan = new Scanner(System.in);

//      Getting player RPS input
        System.out.println(playText + "\n" + chooseText);
        String playerChoice = scan.next();

//      Creating Computer RPS pick
        int computerPickInt = (int)(Math.random() * 100); // Creating a random decimal i.e. 0.645312 then multiply by 100. After that
                                                          // I turn it into an int cutting off the rest of the decimal places i.e. 64
        if (computerPickInt < 33){ // If under 33 then computer picks rock
            computerPick = rock;
        } else if(computerPickInt > 66){ // If over 66 then computer picks scissors
            computerPick = scissors;
        } else{
            computerPick = paper; // If neither (33 < computerPickInt < 66) then computer picks paper
        }

//      Determining the results
        if (playerChoice.equals(rockInput)){
            playerPick = rock;
            if (computerPick.equals(playerPick)){ // If computer pick is same as player pick then print draw text.
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + drawText);
            } else if(computerPick.equals(paper)){ // If computer pick beats player pick then print lose text.
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + loseText);
            } else{ // If computer doesn't draw or beat then it must lose so print lose text.
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + winText);
            }
//      Same steps as above for each player choice
        }else if (playerChoice.equals(paperInput)){
            playerPick = paper;
            if (playerPick.equals(computerPick)){
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + drawText);
            } else if(computerPick.equals(scissors)){
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + loseText);
            } else{
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + winText);
            }
        }else if (playerChoice.equals(scissorsInput)){
            playerPick = scissors;
            if (playerPick.equals(computerPick)){
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + drawText);
            } else if(computerPick.equals(rock)){
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + loseText);
            } else{
                System.out.println("\n" + pChoiceText + playerPick + " \tvs\t " + computerPick + cChoiceText + "\n" + winText);
            }
        } else{ // If the player does not pick any of the possible inputs then print invalid choice text.
            System.out.println(invalidChoiceText);
        }
    }
}
