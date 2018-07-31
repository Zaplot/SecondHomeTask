import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class Main extends JFrame {
    // Method which calculate do rectangles overlapping or not
    public static boolean rectangleOverlap(double x1 , double x2 , double x3 , double x4 , double y1 , double y2 , double y3 ,  double y4 ){
        if ((Math.max(x3,x4)<=Math.min(x1,x2)) || (Math.max(x1,x2)<=Math.min(x3,x4)) ||
                (Math.max(y1,y2)<=Math.min(y3,y4)) || (Math.max(y3,y4)<=Math.min(y1,y2)))
            return false;
        else return true;
    }

   /* public static double initiation () {
        System.out.println("Input (x,y) coordinates of the edges of both rectangles");
        Scanner in = new Scanner(System.in)l
       double x1=in.nextDouble();
       double y1=in.nextDouble();
       double x2=in.nextDouble();
       double y2=in.nextDouble();
       double x3=in.nextDouble();
       double y3=in.nextDouble();
       double x4=in.nextDouble();
       double y4=in.nextDouble();
        return
    }*/


    public static void main(String [] args){
        Scanner in = new Scanner (System.in);
        double x1 , x2 , x3, x4 , y1 , y2 , y3 , y4;
        String flag="";
        System.out.println("Choose your action \n || Input 1 for simple solution || Input 2 for graphics solution || Input exit for 3 || ");
        while (in.hasNext()) {
            final String s = in.next();
            flag=s;
            if(s.equals("3")||s.equals("2")||s.equals("1"))
                break;
            System.out.println("Choose your action \n || Input 1 for simple solution || Input 2 for graphics solution || Input exit for 3 || ");

        }
        switch (flag){
            case "1": {
                System.out.println("Input (x,y) coordinates of the edges of both rectangles");
                x1 = in.nextDouble();
                y1 = in.nextDouble();
                x2 = in.nextDouble();
                y2 = in.nextDouble();
                x3 = in.nextDouble();
                y3 = in.nextDouble();
                x4 = in.nextDouble();
                y4 = in.nextDouble();

                if (rectangleOverlap(x1, x2, x3, x4, y1, y2, y3, y4)) {
                    double[] x = {x1, x2, x3, x4};
                    double[] y = {y1, y2, y3, y4};
                    Arrays.sort(x);
                    Arrays.sort(y);
                    double res = Math.abs(x[1] - x[2]) * Math.abs(y[1] - y[2]);
                    System.out.println("The area of intersection of two rectangles is " + res);
                } else System.out.println("Your rectangles don't overlap");
                break;
            }
            case "2":{
                Main t = new Main();
                t.add(new JComponent() {
                    public void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                        Graphics2D g3 = (Graphics2D) g;
                        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                        Graphics2D g4 = (Graphics2D) g;
                        g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                        double s;
                        int k = 0;
                        Random rnx4 = new Random();
                        Random rny4 = new Random();
                        double rx = 0;
                        double ry = 0;

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
                        int n= 100000;
                        double[] x = {x1,x2,x3,x4};
                        double[] y = {y1,y2,y3,y4};
                        Arrays.sort(x);
                        Arrays.sort(y);
                        for (int i=0 ; i< n; i++) {
                            rx = rnx4.nextDouble();
                            rx*=x[3];

                            ry = rny4.nextDouble();
                            ry*=y[3];
                            if     ((rx >=x1 && rx <= x2 && rx>=x3 && rx <= x4 && ry >=y1 && ry <= y2 && ry>=y3 && ry <= y4) ||
                                    (rx <=x1 && rx >= x2 && rx<=x3 && rx >= x4 && ry <=y1 && ry >= y2 && ry<=y3 && ry >= y4)){
                                k++;
                                g2.setColor(Color.MAGENTA);
                                g2.draw(new Line2D.Double(rx,ry,rx,ry));
                            }
                            if(((rx >=x1 && rx <= x2 && ry>=y1 && ry <= y2) || rx <=x1 && rx >= x2 && ry<=y1 && ry >= y2) && !((rx >=x3 && rx <= x4 && ry>=y3 && ry <= y4) || rx <=x3 && rx >= x4 && ry<=y3 && ry >= y4)){
                                g3.setColor(Color.BLUE);
                                g3.draw(new Line2D.Double(rx,ry,rx,ry));
                            }
                            if(((rx >=x3 && rx <= x4 && ry>=y3 && ry <= y4) || rx <=x3 && rx >= x4 && ry<=y3 && ry >= y4) && !((rx >=x1 && rx <= x2 && ry>=y1 && ry <= y2) || rx <=x1 && rx >= x2 && ry<=y1 && ry >= y2)){
                                g4.setColor(Color.PINK);
                                g4.draw(new Line2D.Double(rx,ry,rx,ry));
                            }
                        }
                           System.out.println(k+ " SKOLechko vnutri peresecheniya ");

                           double ssl = Math.abs(x[0]-x[3])*Math.abs(y[0]-y[3]);
                            System.out.println("ploshad"+ ssl);
                            double nn = n + 0.0;
                            s = (k/nn)*ssl;
                             System.out.println("Ploshad peresecheniya" + s);
                             t.setDefaultCloseOperation(EXIT_ON_CLOSE);
                             t.setSize(400, 400);
                             t.setVisible(true);
                    }
                }
                );
                break;

            }
            default :
                System.exit(0);
                break;
        }
    }
}

