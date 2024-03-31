import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MetodaPenelor extends JPanel implements ActionListener{
    private JPanel titlu;

    private Punct[] puncte;
    private Punct A1, A2, A3, A4, A5, A6, Ox1, Ox2, Oy1, Oy2, M, G;
    private JPanel desenPoligon;
    private JLabel rezultat;
    private JButton start, refresh;

    public MetodaPenelor(){
        titlu = new TitluPanel("Metoda penelor");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        puncte = new Punct[6];

        Ox1 = new Punct(-200, 0);
        Ox2 = new Punct(200, 0);
        Oy1 = new Punct(0, -200);
        Oy2 = new Punct(0, 200);

        A1 = new Punct(12, 8); 
        A2 = new Punct(10, 1); 
        A3 = new Punct(3, 1); 
        A4 = new Punct(1, 5); 
        A5 = new Punct(2, 9); 
        A6 = new Punct(8, 10); 
        
        puncte[0] = A1;
        puncte[1] = A2;
        puncte[2] = A3; 
        puncte[3] = A4;
        puncte[4] = A5; 
        puncte[5] = A6;

        desenPoligon = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }
           
            public void drawLines(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.translate(350, 250);
                g2d.drawLine(Oy1.getX(), Oy1.getY(), Oy2.getX(), Oy2.getY());
                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);
                g2d.drawLine(Ox1.getX(), Ox1.getY(), Ox2.getX(), Ox2.getY());
                g2d.setColor(Color.MAGENTA);
                g2d.drawLine(0, 0, 0, 0);
                    g2d.drawLine(A1.getX() * 10, -A1.getY() * 10, A2.getX() * 10, -A2.getY() * 10);
                    g2d.drawLine(A2.getX() * 10, -A2.getY() * 10, A3.getX() * 10, -A3.getY() * 10);
                    g2d.drawLine(A3.getX() * 10, -A3.getY() * 10, A4.getX() * 10, -A4.getY() * 10);
                    g2d.drawLine(A4.getX() * 10, -A4.getY() * 10, A5.getX() * 10, -A5.getY() * 10);
                    g2d.drawLine(A5.getX() * 10, -A5.getY() * 10, A6.getX() * 10, -A6.getY() * 10);
                    g2d.drawLine(A6.getX() * 10, -A6.getY() * 10, A1.getX() * 10, -A1.getY() * 10);

                if(M != null){
                    g2d.drawOval(M.getX()*10, -M.getY()*10, 3, 3);
                }
                g2d.setColor(Color.BLUE);
                if(G != null){
                    g2d.drawLine(G.getX(), -G.getY(), G.getX(), -G.getY());
                }
                Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2d.setStroke(dashed);
                if(G != null) {
                    g2d.drawLine(G.getX(), -G.getY(), A1.getX() * 10, -A1.getY() * 10);
                    g2d.drawLine(G.getX(), -G.getY(), A2.getX() * 10, -A2.getY() * 10);
                    g2d.drawLine(G.getX(), -G.getY(), A3.getX() * 10, -A3.getY() * 10);
                    g2d.drawLine(G.getX(), -G.getY(), A4.getX() * 10, -A4.getY() * 10);
                    g2d.drawLine(G.getX(), -G.getY(), A5.getX() * 10, -A5.getY() * 10);
                    g2d.drawLine(G.getX(), -G.getY(), A6.getX() * 10, -A6.getY() * 10);
                }
            }
        };

        start = new JButton("Start");
        refresh = new JButton("Refresh");
        start.setBackground(new Color(30, 30, 30));
        refresh.setBackground(new Color(30, 30, 30));
        start.setForeground(new Color(0, 153, 153));
        refresh.setForeground(new Color(0, 153, 153));

        start.setFocusable(false);
        refresh.setFocusable(false);

        start.setPreferredSize(new Dimension(80, 30));
        refresh.setPreferredSize(new Dimension(80, 30));

        JPanel butoane = new JPanel();
        butoane.add(start);
        butoane.add(refresh);
        butoane.setMaximumSize(new Dimension(700, 50));
        JPanel panelRezultat = new JPanel();
        panelRezultat.setMaximumSize(new Dimension(200, 50));
        rezultat = new JLabel();
        panelRezultat.add(rezultat);

        desenPoligon.setMaximumSize(new Dimension(700, 400));
        this.add(desenPoligon);
        this.add(butoane);
        this.add(panelRezultat);

        refresh.setEnabled(false);
        
        start.addActionListener(this);
        refresh.addActionListener(this);
    }


    public void verificaPunct(Punct M){
        G = calculeazaCentruGreutate(puncte[0], puncte[1], puncte[2]);
        System.out.println(G.getX() + " " + G.getY());
        for(int i = 0; i < puncte.length ; i++){
            puncte[i].setX(puncte[i].getX() - G.getX());
            puncte[i].setY(puncte[i].getY() - G.getY());
        }
        int x = M.getX();
        int y = M.getY();
        M.setX(M.getX() - G.getX());
        M.setY(M.getY() - G.getY());
        System.out.println("M(" + M.getX() + ", " + M.getY() + ")");
        desenPoligon.repaint();

        sort(puncte, 0, puncte.length - 1);

        int m = cautareBinara(puncte);
        System.out.println(m);
        if(calculeazaDeterminant1(M, puncte[cautareBinara(puncte)], puncte[cautareBinara(puncte) + 1]) > 0){
            rezultat.setText("M(" + x +", " + y + ") se afla in interior!");
        }
        if(calculeazaDeterminant1(M, puncte[cautareBinara(puncte)], puncte[cautareBinara(puncte) + 1]) < 0){
            rezultat.setText("M(" + x +", " + y + ") se afla in exterior!");
        }
        if(calculeazaDeterminant1(M, puncte[cautareBinara(puncte)], puncte[cautareBinara(puncte) + 1]) == 0){
        rezultat.setText("M(" + x+", " + y + ") se afla pe frontiera!");
        }
    }


    public Punct calculeazaCentruGreutate(Punct A, Punct B, Punct C){
        int x = (A.getX() + B.getX() + C.getX()) / 3;
        int y = (A.getY() + B.getY() + C.getY()) / 3;
        Punct S = new Punct(x, y);

        return S;
    }


    public int calculeazaDeterminant(Punct A, Punct M, Punct B){
        int a[][] = new int[3][3];
        a[0][0] = A.getX(); a[0][1] = -A.getY(); a[0][2] = 1;
        a[1][0] = M.getX(); a[1][1] = -M.getY(); a[1][2] = 1;
        a[2][0] = B.getX(); a[2][1] = -B.getY(); a[2][2] = 1;

        int x = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[0][1] * a[1][2] * a[2][0]);
        int y = (a[0][2] * a[1][1] * a[2][0]) + (a[2][1] * a[1][2] * a[0][0]) + (a[1][0] * a[0][1] * a[2][2]);

        return x - y;
    }
    public int calculeazaDeterminant1(Punct A, Punct M, Punct B){
        int a[][] = new int[3][3];
        a[0][0] = A.getX(); a[0][1] = A.getY(); a[0][2] = 1;
        a[1][0] = M.getX(); a[1][1] = M.getY(); a[1][2] = 1;
        a[2][0] = B.getX(); a[2][1] = B.getY(); a[2][2] = 1;

        int x = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[0][1] * a[1][2] * a[2][0]);
        int y = (a[0][2] * a[1][1] * a[2][0]) + (a[2][1] * a[1][2] * a[0][0]) + (a[1][0] * a[0][1] * a[2][2]);

        return x - y;
    }

    public int getCadran(Punct A){
        int Ca = 0;
        if(A.getX() > 0 && A.getY() >= 0){
            Ca = 1;
        }else if(A.getX() <= 0 && A.getY() > 0){
            Ca = 2;
        }else if(A.getX() < 0 && A.getY() <= 0){
            Ca = 3;
        }else if(A.getX() >= 0 && A.getY() < 0){
            Ca = 4;
        }
        return Ca;
    }

    public int cautareBinara(Punct[] arr){
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.println("\n" + arr[m].getX() + " " + arr[m].getY() + " " + arr[m+1].getX() + " " + arr[m+1].getY());
            if ((getCadran(arr[m]) < getCadran(M) || (getCadran(M) == getCadran(arr[m]) && calculeazaDeterminant(M,new Punct(0,0),arr[m]) >= 0 ) && (getCadran(arr[m+1]) > getCadran(M) || (getCadran(M) == getCadran(arr[m+1]) && calculeazaDeterminant(arr[m+1],new Punct(0,0),M) >= 0 ))))
                return m;

            if (getCadran(M) > getCadran(arr[m]) || (getCadran(M) == getCadran(arr[m]) && calculeazaDeterminant(M,new Punct(0,0),arr[m]) > 0 ))
                l = m + 1;
                
            else
                r = m - 1;
                
        }
        return -1;
    }

    public void sort(Punct[] arr, int st, int dr){
        if(st < dr){
            int mij = st + (dr - st)/2;
            sort(arr, st, mij);
            sort(arr, mij + 1, dr);
            merge(arr, st, mij, dr);
        }
    }

    void merge(Punct arr[], int s, int m, int d) { 
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
            Punct A, B;
            if (stanga[i].getX() <= dreapta[j].getX()) { 
                B = stanga[i];
                A = dreapta[j]; 
            } 
            else { 
                B = dreapta[j];
                A = stanga[i]; 
            } 

            int Ca = getCadran(A);
            int Cb = getCadran(B);

            if((Cb > Ca) || (Ca == Cb && calculeazaDeterminant(A, G, B) > 0)){
                arr[k] = A;
                if(A.getX() == stanga[i].getX() && A.getY() == stanga[i].getY()){
                    i++;
                }else j++;
            }else{
                arr[k] = B;
                if(B.getX() == stanga[i].getX() && B.getY() == stanga[i].getY()){
                    i++;
                }else j++;
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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            String nr = JOptionPane.showInputDialog("Introduceti coordonatele punctului M:");
            String[] nr2 = nr.split(",");
            M = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
            System.out.println("M(" + M.getX() + ", " + M.getY() + ")");
            start.setEnabled(false);
            refresh.setEnabled(true);
            verificaPunct(M);
        }

        if(e.getSource() == refresh){
            A1.setX(12); A1.setY(8);
            A2.setX(10); A2.setY(1);
            A3.setX(3); A3.setY(1);
            A4.setX(1); A4.setY(5);
            A5.setX(2); A5.setY(9);
            A6.setX(8); A6.setY(10);

            puncte[0] = A1;
            puncte[1] = A2;
            puncte[2] = A3; 
            puncte[3] = A4;
            puncte[4] = A5; 
            puncte[5] = A6;

            G = null;
            M = null;
            rezultat.setText("");
            desenPoligon.repaint();
            start.setEnabled(true);
            refresh.setEnabled(false);
        }
        
    }
}