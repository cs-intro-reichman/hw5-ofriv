/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        if(str.length() == 0)
        {
            return 0;
        }
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) == ch)
            {
                count++;
            }
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
    
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            int countInStr1 = MyString.countChar(str1, c);
            int countInStr2 = MyString.countChar(str2, c);
    
            // If str2 doesn't have enough of character c, return false
            if (countInStr2 < countInStr1) {
                return false;
            }
        }
    
        return true;
    }
    
    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String str2 = "";
        for(int i = 0; i < str.length()-1; i++)
        {
            str2 += str.charAt(i) + " ";
        }
        str2 += str.charAt(str.length()-1);
        return str2;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String result = "";
        for(int i = 0; i < n; i++)
        {
            int randomIndex = (int) (Math.random() * 26);
            char randomLetter = (char) ('a' + randomIndex);
            result += randomLetter;
        }
        return result;
    }

    /**
    S
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String str3 = "";
        for(int i = 0; i < str1.length(); i++)
        {
            if(countChar(str2, str1.charAt(i)) == 0)
            {
                str3 += str1.charAt(i);
            }
            else
            {
                str2 = str2.substring(0,str2.indexOf(str1.charAt(i))) + str2.substring(str2.indexOf(str1.charAt(i))+1);
            }
        }

        return str3;
    }
    
    
    
    

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
