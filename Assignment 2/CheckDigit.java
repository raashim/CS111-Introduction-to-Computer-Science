public class CheckDigit {
    public static void main(String [] args) 
    {
        long num1 = Long.parseLong(args[0]);
        int sum1 = 0;
        int sum2 = 0;
        int count = 0;


        while(num1 > 0) {
            if(count % 2 == 0) {
                sum1 += num1 % 10;
            }
            else {
                sum2 += num1 % 10; 
            }

            num1 = num1 / 10;
            count++;
        }
        
        sum1 = sum1 % 10;
        sum2 = (sum2*3) % 10;

        int sum3 = sum1 + sum2; 
        sum3 = sum3 % 10; 
        System.out.println(sum3);
    }
}