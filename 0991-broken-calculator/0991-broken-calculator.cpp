class Solution {
public:
    int brokenCalc(int startValue, int target) {
        
        int operations = 0;

        while(target > startValue)
        {
            if(target%2==0)
            target /= 2;
            else if(target%2==1)
            target+=1;

            operations++;
        }

        // if now target is smaller than startValue so now we only perform subtraction operations 

        operations += startValue - target;

        return operations;
    }
};