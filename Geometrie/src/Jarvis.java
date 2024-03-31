import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;

public class Jarvis extends JPanel implements ActionListener{
    private JPanel titlu;
    private JPanel desen;
    private Punct[] puncte;
    private Punct V1, V2, V3, V4, V5, V6, V7, V8;
    private JButton check;
    private ArrayList<Punct> stanga, dreapta;

    public Jarvis(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel("Algoritmul Jarvis");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        puncte = new Punct[8];

        V1 = new Punct(0, - 15); 
        V2 = new Punct(15, -6);
        V3 = new Punct(-10, -4);
        V4 = new Punct(3, 0);
        V5 = new Punct(9, 5);
        V6 = new Punct(1, 10);
        V7 = new Punct(-12, 14);
        V8 = new Punct(17, 16);

        puncte[0] = V1;
        puncte[1] = V2;
        puncte[2] = V3;
        puncte[3] = V4;
        puncte[4] = V5;
        puncte[5] = V6;
        puncte[6] = V7;
        puncte[7] = V8;
        
        desen = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }

            public void drawLines(Graphics g){
                Graphics2D g2d =(Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.translate(350, 250);
                
                Stroke stroke = new BasicStroke(4f);
                g2d.setStroke(stroke);
                g2d.setColor(Color.RED); 

                for(int i = 0; i < puncte.length; i++){
                    g2d.drawLine(puncte[i].getX() * 10, -puncte[i].getY()*10, puncte[i].getX() * 10, -puncte[i].getY()*10);
                }

                g2d.setColor(Color.GREEN);
                if(dreapta != null && stanga != null){
                    for(int i = 0; i < dreapta.size() - 1; i++){
                        g2d.drawLine(dreapta.get(i).getX() * 10, -dreapta.get(i).getY() * 10, dreapta.get(i+1).getX() * 10, -dreapta.get(i+1).getY() * 10);
                    }
                    for(int i = 0; i < stanga.size() - 1; i++){
                        g2d.drawLine(stanga.get(i).getX() * 10, -stanga.get(i).getY() * 10, stanga.get(i+1).getX() * 10, -stanga.get(i+1).getY() * 10);
                    }
                    g2d.drawLine(stanga.get(0).getX() * 10, -stanga.get(0).getY() * 10, dreapta.get(0).getX() * 10, -dreapta.get(0).getY() * 10);
                }
            }
        };

        JPanel buttons = new JPanel();
        check = new JButton("Check");

        check.setBackground(new Color(30, 30, 30));
        check.setForeground(new Color(0, 153, 153));
        check.setFocusable(false);
        check.setPreferredSize(new Dimension(80, 30));
        buttons.setMaximumSize(new Dimension(700, 35));

        buttons.add(check);

        desen.setMaximumSize(new Dimension(700, 450));
        this.add(desen);
        this.add(buttons);

        check.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check){
            rezolvare();
        }
    }

    public void rezolvare(){
        sortAbscisa(puncte, 0, puncte.length - 1);
        jarvis();
        desen.repaint();

    }

    public void jarvis(){
        dreapta = new ArrayList<>();
        stanga = new ArrayList<>();
        
        Punct P = puncte[0];
        int l = 0, q;
        do{
            dreapta.add(P);
            q = l + 1;
            for(int i = 0; i < puncte.length; i++){
                if(calculeazaDeterminant(P, puncte[i], puncte[q]) > 0) q = i;
            }
            P = puncte[q];
            l = q;
        }while (P != puncte[puncte.length - 1]);

        l = puncte.length - 1;
        P = puncte[l];
        do{
            stanga.add(P);
            q = l - 1;
            for(int i = puncte.length - 1; i >= 0; i--){
                if(calculeazaDeterminant(P, puncte[i], puncte[q]) < 0) q = i;
            }
            P = puncte[q];
            l = q;
        }while (P != puncte[0]);

    }

    public int calculeazaDeterminant(Punct A, Punct M, Punct B){
        int a[][] = new int[3][3];
        a[0][0] = A.getX(); a[0][1] = A.getY(); a[0][2] = 1;
        a[1][0] = M.getX(); a[1][1] = M.getY(); a[1][2] = 1;
        a[2][0] = B.getX(); a[2][1] = B.getY(); a[2][2] = 1;

        int x = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[0][1] * a[1][2] * a[2][0]);
        int y = (a[0][2] * a[1][1] * a[2][0]) + (a[2][1] * a[1][2] * a[0][0]) + (a[1][0] * a[0][1] * a[2][2]);

        return x - y;
    }


    void sortAbscisa(Punct[] arr, int l, int r) 
    {   
        if (l < r) { 
            int m = (l + r) / 2; 
            sortAbscisa(arr, l, m); 
            sortAbscisa(arr, m + 1, r); 
            mergeAbscisa(arr, l, m, r); 
        }
        
    } 

    void mergeAbscisa(Punct[] arr, int s, int m, int d) 
    { 
        
        int d1 = m - s + 1; 
        int d2 = d - m; 

        Punct stanga[] = new Punct[d1]; 
        Punct dreapta[] = new Punct[d2]; 
  
        for (int i = 0; i < d1; i++){
            stanga[i] = arr[s + i]; 
        } 
            
        for (int j = 0; j < d2; j++){
            dreapta[j] = arr[m + 1 + j];
        } 
             
  
        
        int i = 0, j = 0; 
        int k = s; 
        while (i < d1 && j < d2) { 
            if (stanga[i].getX() <= dreapta[j].getX()) { 
                arr[k] = stanga[i]; 
                i++; 
            } 
            else { 
                arr[k] = dreapta[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < d1) { 
            arr[k] = stanga[i]; 
            i++; 
            k++; 
        } 
        while (j < d2) { 
            arr[k] = dreapta[j]; 
            j++; 
            k++; 
        } 
    } 
}