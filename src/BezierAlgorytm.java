import javax.swing.*;
import java.awt.*;

public class BezierAlgorytm extends JPanel {

    //wspolrzedne krzywycyh litery P
    private final int[]xp1={198,180,195};
    private final int[]yp1={105,458,483};
    private final int[]xp2={190,204,267};
    private final int[]yp2={486,491,487};
    private final int[]xp3={267,214,260};
    private final int[]yp3={482,321,244};
    private final int[]xp4={260,329,361};
    private final int[]yp4={241,218,160};
    private final int[]xp5={361,359,203};
    private final int[]yp5={155,5,104};

    //wspolrzedne krzywych litery N
    private final int[]xn1={438,433,469};
    private final int[]yn1={430,122,90};
    private final int[]xn2={466,594,594};
    private final int[]yn2={88,253,268};
    private final int[]xn3={594,571,606};
    private final int[]yn3={263,124,82};
    private final int[]xn4={606,644,680};
    private final int[]yn4={82,67,80};
    private final int[]xn5={678,706,676};
    private final int[]yn5={80,354,418};
    private final int[]xn6={673,650,624};
    private final int[]yn6={418,429,419};
    private final int[]xn7={627,530,535};
    private final int[]yn7={421,287,272};
    private final int[]xn8={528,561,554};
    private final int[]yn8={246,396,432};
    private final int[]xn9={552,511,440};
    private final int[]yn9={434,459,432};

    double xt;
    double yt;

    int silnia(int i)
    {
        if (i==0)
            return 1;
        else
            return  i*silnia(i-1);
    }

    //algorytm generujacy punkty kontrolne
    public void controlPoints(int[]x,int[]y,Graphics g)
    {
        float t;
                for(t=0;t<1.0;t+=0.0005f) {
                    xt=0;yt=0;
                    for (int j = 0; j < x.length; j++){
                        xt += ((silnia(x.length-1))/(silnia(j)*silnia(x.length-1-j)))*Math.pow(1-t, x.length-1-j)*Math.pow(t,j)*x[j];
                        yt += ((silnia(x.length-1))/(silnia(j)*silnia(x.length-1-j)))*Math.pow(1-t, x.length-1-j)*Math.pow(t,j)*y[j];
                    }
                    g.drawLine((int) xt , (int) yt , (int) xt , (int) yt );
                }
        }

        //rysowanie przy wykorzystaniu powyższej funkcji
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,1000,700);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));
        g2d.setPaint(new GradientPaint(xp1[0],yp1[0],new Color(0, 208, 255),xp1[2],yp1[2],new Color(225, 0, 255)));
        controlPoints(xp1,yp1,g);
        g2d.setPaint(new GradientPaint(xp2[0],yp2[0],new Color(225, 0, 255),xp2[2],yp2[2],new Color(255, 247, 28)));
        controlPoints(xp2,yp2,g);
        g2d.setPaint(new GradientPaint(xp3[0],yp3[0],new Color(255, 247, 28),xp3[2],yp3[2],new Color(227, 31, 14)));
        controlPoints(xp3,yp3,g);
        g2d.setPaint(new GradientPaint(xp4[0]+10,yp4[0],new Color(227, 31, 14),xp4[2],yp4[2],new Color(0, 255, 0)));
        controlPoints(xp4,yp4,g);
        g2d.setPaint(new GradientPaint(xp2[0]+50,yp2[0],new Color(0, 208, 255),xp2[2],yp2[2],new Color(0, 255, 0)));
        controlPoints(xp5,yp5,g);
        g2d.setPaint(new GradientPaint(xn1[0],yn1[0],new Color(136, 209, 10),xn1[2],yn1[2], new Color(209, 36, 56)));
        controlPoints(xn1,yn1,g);
        g2d.setPaint(new GradientPaint(xn2[0],yn2[0],new Color(209, 36, 56),xn2[2],yn2[2],new Color(238, 255, 0)));
        controlPoints(xn2,yn2,g);
        g2d.setPaint(new GradientPaint(xn3[0],yn3[0],new Color(238, 255, 0),xn3[2],yn3[2],new Color(23, 30, 227)));
        controlPoints(xn3,yn3,g);
        g2d.setPaint(new GradientPaint(xn4[0],yn4[0],new Color(23, 30, 227),xn4[2],yn4[2],new Color(16, 227, 44)));
        controlPoints(xn4,yn4,g);
        g2d.setPaint(new GradientPaint(xn5[0],yn5[0],new Color(16, 227, 44),xn5[2],yn5[2],new Color(232, 16, 228)));
        controlPoints(xn5,yn5,g);
        g2d.setColor(new Color(232, 16, 228));
        controlPoints(xn6,yn6,g);
        g2d.setPaint(new GradientPaint(xn7[0],yn7[0],new Color(232, 16, 228),xn7[2],yn7[2]+120,new Color(227, 31, 14)));
        controlPoints(xn7,yn7,g);
        g2d.setColor(new Color(227, 31, 14));
        controlPoints(xn8,yn8,g);
        g2d.setPaint(new GradientPaint(xn9[0],yn9[0],new Color(227, 31, 14),xn9[2],yn9[2],new Color(136, 209, 10)));
        controlPoints(xn9,yn9,g);
        g2d.setColor(new Color(225, 0, 255));
        g.drawOval(250,125,60,60);

    }
}
