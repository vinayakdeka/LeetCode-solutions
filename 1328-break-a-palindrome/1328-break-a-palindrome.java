class Solution {
    public String breakPalindrome(String palindrome) {

        int n = palindrome.length();

        if(n==1) return ""; // if only 1 character in the string then its impossible
        char arr[] = palindrome.toCharArray();

        for(int i = 0; i<n/2; i++)
        {
            if(arr[i] != 'a')
            {
            arr[i] = 'a';
            return new String(arr); 
             //change the first non-'a' alphabet to a to obtain lexicographically smallest string
            }
        }

         arr[n-1] = 'b';
         return new String(arr); // change the last character to b
        
    }
}