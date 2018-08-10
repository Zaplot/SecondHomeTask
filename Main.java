import java.util.Arrays;
import java.util.Scanner;


public class Main {
    // Method which calculate do rectangles overlapping or not
    private static boolean rectangleOverlap(double x1, double x2, double x3, double x4, double y1, double y2, double y3, double y4) {
        return (!(Math.max(x3, x4) <= Math.min(x1, x2))) && (!(Math.max(x1, x2) <= Math.min(x3, x4))) &&
                (!(Math.max(y1, y2) <= Math.min(y3, y4))) && (!(Math.max(y3, y4) <= Math.min(y1, y2)));
    }
    // Method which get coordinates and calculate the area of intersection
    private static void rectangleSolution() {
        System.out.println("Input (x,y) coordinates of the edges of both rectangles");
        Scanner in = new Scanner(System.in);
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();
        double x4 = in.nextDouble();
        double y4 = in.nextDouble();
        if (rectangleOverlap(x1, x2, x3, x4, y1, y2, y3, y4)) {
            double[] x = {x1, x2, x3, x4};
            double[] y = {y1, y2, y3, y4};
            Arrays.sort(x);
            Arrays.sort(y);
            double res = Math.abs(x[1] - x[2]) * Math.abs(y[1] - y[2]);
            System.out.println("The area of intersection of two rectangles is " + res);
        } else System.out.println("Your rectangles don't overlap");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String flag = "";
        System.out.println("Choose your action \n || Input 1 for simple solution || Input 2 for graphics solution || Input 3 for exit || ");
        while (in.hasNext()) {
            final String s = in.next();
            flag = s;
            if (s.equals("3") || s.equals("2") || s.equals("1"))
                break;
            System.out.println("Choose your action \n || Input 1 for simple solution || Input 2 for graphics solution || Input 3 for exit || ");

        }
        switch (flag) {
            case "1": {
                rectangleSolution();
                break;
            }
            case "2": {
                System.out.println("Program will be uploaded soon with graphic solution! Sorry for this! ");
            }
            break;

            default:
                System.exit(0);
                break;
        }
    }
}

