class Solution {
    public boolean checkDivisibility(int n) {

        int original = n;
        int digitsum = 0;
        int digitproduct = 1;

        while(n!=0)
        {
            int digit = n%10;
           
            digitsum += digit;
            digitproduct = digitproduct * digit;
            n = n/10;
           
        }
        int totalSum = digitsum + digitproduct;
        
        return (original % totalSum ==0);
        
    }
};