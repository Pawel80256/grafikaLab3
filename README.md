# grafikaLab3
Program rysujący inicjały przy wykorzystaniu krzywych Beziera.  
Na początku inicjuje tablice ze wspołrzędnymi punktów dla każdej krzywej
``` 
    private final int[]xp1={198,180,195};
    private final int[]yp1={105,458,483};
    private final int[]xp2={190,204,267};
    private final int[]yp2={486,491,487};
    itd...
```
Algorytm generujący punkty kontrolne:
```
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
```
I na koncu w metodzie paint kolorowanie gradientami i rysowanie
