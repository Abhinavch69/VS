package strings;

import java.util.Scanner;

class longestPalindomicSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        Solution solution = new Solution();
        String longestPalindrome = solution.longestPalindrome(input);
        
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
        scanner.close();
    }
}

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = Integer.MIN_VALUE;
        int l, r;

        for (int i = 0; i < s.length(); i++) {

            // odd length palindrome
            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }

            // even length palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > resLen) {
                    resLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

        }
        return res;
    }
}

