import java.util.Scanner;
public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        String[] vowelArr = {"a", "e", "i", "o", "u"}; // Creating array with all vowels to detect
        int vowelAmount = 0; // Variable that keeps track of how many times a vowel was found
        for (int i = 0; i < s.length(); i++){ // Looping through each letter in given string
            for (int j = 0; j < vowelArr.length; j++){ // For each letter it will check if it equals each vowel
                if(s.substring(i, i + 1).equals(vowelArr[j])){ // If the letter equals the current vowel
                    vowelAmount ++; // If true then add one to the vowel count
                }
            }
        }
        System.out.println("Number of vowels: " + vowelAmount); // Printing the output
        return vowelAmount; // Returning the output
    }
    //Code you problem number two here
    static int problemTwo(String s){
        String keyWord = "bob"; // String containing the keyword
        int bobOccurrences = 0; // Variable that keeps track of how many times bob occurred in the given string
        for (int i = 0; i < s.length(); i++){ // Looping through each letter in given string
    // If the current loop isn't recording the last 3 letters and the next 3 letters equal keyword (aka bob)
                if (i <= s.length() - 3 && (s.substring(i, i+3).equals(keyWord))){
                    bobOccurrences ++; // If true then add one to the bob count
                }
        }
        System.out.println("Number of times bob occurs is: " + bobOccurrences); // Printing the output
        return bobOccurrences; // Returning the output
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        String[] alphabeticalArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z"}; // Creating array with every letter
        String longestAlphabeticalSubstring = ""; // String that will hold the longest alphabetical substring found in the given string
        int newIndex = 0; // Variable that keeps track of the starting index for determining the longest alphabetical phrase
        for (int i = 0; i < s.length(); i++){ // Loops through each letter in given string
            String currentPhrase = s.substring(newIndex, i + 1); // Variable that keeps track of the current phrase
            int leastIndex = 0; // Variable that stores the index of the last letter (to check whether next letter is still in alphabetical order
            String currentAlphabeticalSubstring = ""; // Variable that stores the current alphabetical substring
            for (int j = 0; j < currentPhrase.length(); j++){ // Loops through each letter in the current phrase
                for (int n = 0; n < alphabeticalArr.length; n++){ // Loops through each letter in the alphabet
    // If the current letter in the current phrase equals the current letter being looped
                    if (currentPhrase.substring(j, j + 1).equals(alphabeticalArr[n])){
                        if (n >= leastIndex){ // If the current letter is further than the last
                            leastIndex = n; // If true then make the last letter alphabetical index to the current (for the next loop)
                            currentAlphabeticalSubstring += currentPhrase.substring(j, j + 1); // Add the letter to the current alphabetical substring
                        } else{ // If current letter is less than the last
                            newIndex = i; // We move past this phrase and start over
                        }
    // If the current alphabetical substring is longer than the longest alphabetical substring so far
                        if (currentAlphabeticalSubstring.length() > longestAlphabeticalSubstring.length()){
                            longestAlphabeticalSubstring = currentAlphabeticalSubstring; // If true then replace
                        }
                       break; // Break out of the loop once the current letter was found because all the next letters can't be equal
                    }
                }
            }
        }
        System.out.println("Longest alphabetical substring:" + longestAlphabeticalSubstring); // Printing the output
        return longestAlphabeticalSubstring; // Returning the output
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        These tests will put your methods through several, different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        problemOne("iueuaondjmhoiuxj");
        problemTwo("iueuaondjmhoiuxj");
        problemThree("iueuaondjmhoiuxj");
    }
}
