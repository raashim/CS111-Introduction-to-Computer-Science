public class LargestOfFive {
    public static void main(String [] args) {
        int one = Integer.parseInt(args[0]);
        int two = Integer.parseInt(args[1]);
        int three = Integer.parseInt(args[2]);
        int four = Integer.parseInt(args[3]);
        int five = Integer.parseInt(args[4]);

        if(one > two && one > three && one > four && one > five) {
            System.out.println(one);
        }
        else if (two > one && two > three && two > four && two > five) {
            System.out.println(two);
        }
        else if (three > one && three > two && three > four && three > five) {
            System.out.println(three);
        }
        else if(four > one && four > two && four > three && four > five) {
            System.out.println(four);
        }
        else if(five > one && five > two && five > three && five > four) {
            System.out.println(five);
        }
    }
}