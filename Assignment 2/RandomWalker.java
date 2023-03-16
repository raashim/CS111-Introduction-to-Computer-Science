public class RandomWalker {
    public static void main (String [] args) {
        int n = Integer.parseInt(args[0]);

        int x = 0; 
        int y = 0; 

        System.out.println("(" + x + " , " + y + ")");

        for(int i = 0; i < n; i++) {
           
           int check = (int)((Math.random())*4.0);

           if(check == 0 ) {
                x++;
            }
            else if (check <= 1 && check < 2) {
                y++;
            }
            else if(check <=2 && check < 3) {
                x--;
            }
            else if(check <= 3 && check < 4) {
                y--;
            }

            System.out.println("(" + x + " , " + y + ")");
        }

        double distance = Math.pow(x,2) + Math.pow(y,2);
        System.out.print("Squared distance = " + distance);

    }
}