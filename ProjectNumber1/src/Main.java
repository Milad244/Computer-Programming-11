import java.util.Scanner;
public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        String[] vowelArr = {"a", "e", "i", "o", "u"};
        int vowelAmount = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < vowelArr.length; j++){
                if(s.substring(i, i + 1).equals(vowelArr[j])){
                    vowelAmount ++;
                }
            }
        }
        System.out.println("Number of vowels: " + vowelAmount);
        return vowelAmount;
    }
    //Code you problem number two here
    static int problemTwo(String s){
        String keyWord = "bob";
        int bobOccurrences = 0;
        for (int i = 0; i < s.length(); i++){
                if (i <= s.length() - 3 && (s.substring(i, i+3).equals(keyWord))){
                    bobOccurrences ++;
                }
        }
        System.out.println("Number of times bob occurs is: " + bobOccurrences);
        return bobOccurrences;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        String[] alphabeticalArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String longestAlphabeticalSubstring = "";
        int newIndex = 0;
        for (int i = 0; i < s.length(); i++){
            String currentPhrase = s.substring(newIndex, i + 1);
            int leastIndex = 0;
            String currentAlphabeticalSubstring = "";
            for (int j = 0; j < currentPhrase.length(); j++){
                for (int n = 0; n < alphabeticalArr.length; n++){
                    if (currentPhrase.substring(j, j + 1).equals(alphabeticalArr[n])){
                        if (n >= leastIndex){
                            leastIndex = n;
                            currentAlphabeticalSubstring += currentPhrase.substring(j, j + 1);
                        } else{
                            newIndex = i;
                        }
                        if (currentAlphabeticalSubstring.length() > longestAlphabeticalSubstring.length()){
                            longestAlphabeticalSubstring = currentAlphabeticalSubstring;
                        }
                       break;
                    }
                }
            }
        }
        System.out.println(longestAlphabeticalSubstring);
        return longestAlphabeticalSubstring;
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
