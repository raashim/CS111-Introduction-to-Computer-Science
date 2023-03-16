public class RURottenTomatoes {
    public static void main(String [] args) {

        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);
        int index1 = 2; 

        int [][] intArr = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++ ) {
                intArr[i][j] = Integer.parseInt(args[index1]);
                index1++;
            }
        }
       
       int movieIndex = 0;; 
       int sumPlace = 0; 

       for(int i = 0; i < col; i++) {
            
            int sum = 0; 
            
            for(int j = 0; j < row; j++) {
                sum += intArr[j][i]; 
        }
       
            if(sum > sumPlace) {
                sumPlace = sum;
                movieIndex = i;
            }
    }


    StdOut.print(movieIndex);

        }
}