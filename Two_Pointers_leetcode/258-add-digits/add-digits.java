class Solution {
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }

        int sum = digitSum(num);
       
       return addDigits(sum);

    }

    private int digitSum(int num){
        if(num == 0) return 0;

        return (num%10) + digitSum(num/10);
    }
}