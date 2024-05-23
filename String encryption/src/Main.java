import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//      Variables
        boolean isRunning = true;
        String welcomeText = "This program lets you encrypt and decrypt your text. If at anytime you would like to quit the program type 'quit'\n";
        String askEncryptText = "Current mode: Encryption. If you want to switch to decryption mode type 'decrypt'\nPlease give me some text to encrypt:";
        String starLine = "*****************************************************************************************************************";
        String askDecryptText = "Current mode: Decryption. if you want to switch to encryption mode type 'encrypt'\nPlease give me some text to decrypt:";
        String decryptText = "decrypt";
        String quitText = "quit";
        String encryptEnd = "iuc";
        String encryption;
        String decryption;
        String endLetter;

//      Creating scanner
        Scanner scan = new Scanner(System.in);

//      Welcome message/user instructions
        System.out.println(starLine + "\n" + welcomeText);
        System.out.println(askEncryptText);
        String phrase = scan.nextLine();

//      Creating the loop
        while (isRunning){ //Loop continues unless isRunning becomes false
            if (phrase.equals(quitText)){ //If user types 'quit' then isRunning becomes false and the loop gets ended (quits the program)
                isRunning = false;
            } else if (phrase.equals(decryptText)){ //If the user types 'decrypt' then the game switches to decrypt mode
                System.out.println(askDecryptText); //Asking the user for the encrypted text to decrypt
                String encryptedPhrase = scan.nextLine();
                decryption = ""; //Setting the final decryption variable to empty every new decryption
                if (encryptedPhrase.equals("encrypt")){ //If the user type 'encrypt' then the game switches to encrypt mode
                    phrase = "encrypt";
                } else if (encryptedPhrase.equals("quit")){ //If user types 'quit' then program will quit. I have to repeat this
                    phrase = "quit";                        //because we are in a different section
                } else{ //If the user did not type 'quit' or 'decrypt' then it must be input to decrypt
                    for (int i = 0; i < encryptedPhrase.length(); i++){ //Loops through for every letter in the encrypted phrase
                        String currentLetter = encryptedPhrase.substring(i, i + 1); //Variable that contains the current letter that the loop is on
                        if(i + 1 == encryptedPhrase.length()){ //If the current letter index + 1 equals the total length (The last letter)
                            decryption += encryptedPhrase.substring(0, 1); //Then we add the beginning letter that was moved from the end during encryption
                        } else if(i <= encryptedPhrase.length() - 4 && i != 0){ //If we are not on the last 3 letters then we will
                            decryption += currentLetter;     //add the letters to the decryption because the last 3 are just for encryption
                        }
                    }
                    System.out.println("Decrypted message: " + decryption + "\n" + starLine); //Printing the decrypted phrase
                }
            } else {
                if (!phrase.equals("encrypt")){ //If the word is not encrypt we run the encryption
                    encryption = ""; //Setting the final encryption variable to empty every new encryption
                    for (int i = 0; i < phrase.length(); i++){ //Loops through for every letter in the phrase
                        String currentLetter = phrase.substring(i, i + 1); //Variable that contains the current letter that the loop is on
                        if (i + 1 == phrase.length()){ //If the current letter index + 1 equals the total length (The last letter)
                            endLetter = phrase.substring(i, i + 1); //Then set the endLetter variable equal to the last letter
                            encryption += encryptEnd; //We then add the encryption end instead of the actual end letter
                            encryption = endLetter + encryption; // Finally we create the final encryption by adding the last letter to the beginning
                            break;
                        } else{
                            encryption += currentLetter; //If it's not the last letter we can just add the letter to our encryption
                        }
                    }
                    System.out.println("Encrypted message: " + encryption + "\n" + starLine); //Printing the encrypted phrase
                }
                System.out.println(askEncryptText); //Asking the user for another text to encrypt
                phrase = scan.nextLine();
            }
        }
    }
}