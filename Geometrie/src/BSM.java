import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;


public class BSM extends JPanel implements ActionListener{
    private JPanel titlu;

    private JPanel desenDrepunghi;
    private JLabel rezultat;
    private Punct Ox1, Ox2, Oy1, Oy2, A, B, C, D;
    private Punct[] S, pcte = new Punct[4];
    private JButton check, add, refresh;
    private Punct[] L1, L2;
    private int[][] M;
    private int[] Q = new int[4];
    

    public BSM(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel ("Algoritmul de limitare");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        Ox1 = new Punct(-250, 0);
        Ox2 = new Punct(250, 0);
        Oy1 = new Punct(0, -200);
        Oy2 = new Punct(0, 200);

        S = new Punct[8];
        S[0] = new Punct(2, 2);
        S[1] = new Punct(15, 4);
        S[2] = new Punct(10, 6);
        S[3] = new Punct(20, 8);
        S[4] = new Punct(1, 10);
        S[5] = new Punct(8, 12);
        S[6] = new Punct(4, 14);
        S[7] = new Punct(12, 16);
        

        desenDrepunghi = new JPanel(){
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

                Stroke stroke1 = new BasicStroke(4f);
                g2d.setStroke(stroke1);
                g2d.setColor(Color.RED);
                for(int i = 0; i < S.length; i++){
                    g2d.drawLine(S[i].getX() * 10, -S[i].getY()*10, S[i].getX() * 10, -S[i].getY()*10);
                }

                g2d.setStroke(stroke);
                g2d.setColor(Color.MAGENTA);
                if(A != null){
                    g2d.drawLine(A.getX() * 10, -A.getY()*10, A.getX() * 10, -A.getY()*10);
                }
                if(B != null){
                    g2d.drawLine(B.getX() * 10, -B.getY()*10, B.getX() * 10, -B.getY()*10);
                }
                if(C != null){
                    g2d.drawLine(C.getX() * 10, -C.getY()*10, C.getX() * 10, -C.getY()*10);
                }
                if(D != null){
                    g2d.drawLine(D.getX() * 10, -D.getY()*10, D.getX() * 10, -D.getY()*10);
                }

                if((A != null) && (B != null) && (C != null) && (D != null)){
                    g2d.drawLine(A.getX() * 10, -A.getY()*10, B.getX() * 10, -B.getY()*10);
                    g2d.drawLine(B.getX() * 10, -B.getY()*10, C.getX() * 10, -C.getY()*10);
                    g2d.drawLine(C.getX() * 10, -C.getY()*10, D.getX() * 10, -D.getY()*10);
                    g2d.drawLine(D.getX() * 10, -D.getY()*10, A.getX() * 10, -A.getY()*10);
                }
            }
            
        };
        JPanel buttons = new JPanel();

        refresh = new JButton("Refresh");
        check = new JButton("Check");
        add = new JButton("Add");

        refresh.setBackground(new Color(30, 30, 30));
        refresh.setForeground(new Color(0, 153, 153));
        check.setBackground(new Color(30, 30, 30));
        check.setForeground(new Color(0, 153, 153));
        add.setBackground(new Color(30, 30, 30));
        add.setForeground(new Color(0, 153, 153));
        check.setFocusable(false);
        add.setFocusable(false);
        refresh.setFocusable(false);
        check.setEnabled(false);
        refresh.setEnabled(false);

        check.setPreferredSize(new Dimension(80, 30));
        add.setPreferredSize(new Dimension(80, 30));
        refresh.setPreferredSize(new Dimension(80, 30));

        buttons.setMaximumSize(new Dimension(700, 35));
        buttons.add(add); buttons.add(check); buttons.add(refresh);

        desenDrepunghi.setMaximumSize(new Dimension(700, 450));
        this.add(desenDrepunghi);
        this.add(buttons);

        add.addActionListener(this);
        check.addActionListener(this);
        refresh.addActionListener(this);

        JPanel rezultatPanel = new JPanel();
        rezultatPanel.setMaximumSize(new Dimension(700, 50));
        rezultat = new JLabel();
        
        rezultatPanel.add(rezultat);
        this.add(rezultatPanel);
        
    }

   
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String nr = JOptionPane.showInputDialog("Introduceti coordonatele punctului:");
            String[] nr2 = nr.split(",");
        
            if(A == null){
                A = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
                refresh.setEnabled(true);
                desenDrepunghi.repaint();
                pcte[0] = A;
            }
            else if(B == null){
                B = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
                desenDrepunghi.repaint();
                pcte[1] = B;
            }
            else if(C == null){
                C = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
                desenDrepunghi.repaint();
                pcte[2] = C;
            }
            else if(D == null){
                D = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
                desenDrepunghi.repaint();
                pcte[3] = D;
                add.setEnabled(false);
                check.setEnabled(true);
            }

        }
        if(e.getSource() == check){
            getPuncte();
            check.setEnabled(false);
        }
        if(e.getSource() == refresh){
            A = null; B = null; C = null; D = null;
            desenDrepunghi.repaint();
            refresh.setEnabled(false);
            add.setEnabled(true);
            rezultat.setText("");
        }
    }

    public void getPuncte(){
        L1 = Arrays.copyOf(S, S.length);
        L2 = Arrays.copyOf(S, S.length);
        
        sortOrizontala(L1, 0, L1.length - 1);
        sortVerticala(L2, 0, L2.length - 1);

        int n = L1.length + 1;
        initializeazaMatrice(n);

        for(int i = 0; i < pcte.length; i++){
            int k = cautareBinaraL1(pcte[i]);
            int l = cautareBinaraL2(pcte[i]);

            Q[i] = M[k][M.length- 1 - l];
        }
        int ABCD = Q[1] - Q[0] - Q[2] + Q[3];

        rezultat.setText("ABCD cuprinde " + ABCD + " puncte.");

    }

    public int cautareBinaraL1(Punct X){
        int st = 0, dr = L1.length - 1;

        while(st <= dr){
            int mij = (st + dr) / 2;
            if(L1[dr].getX() < X.getX()) return dr;
            else if(L1[st].getX() > X.getX()) return st ;
            else if((X.getX() >= L1[mij].getX()) && (X.getX() <= L1[mij + 1].getX())) {
                return mij;
            }else if(X.getX() < L1[mij].getX()){
                dr = mij - 1;
            }else if(X.getX() > L1[mij + 1].getX()) st = mij + 1;
        }
        return - 1;
    }

    public int cautareBinaraL2(Punct X){
        int st = 0, dr = L2.length - 1;

        while(st <= dr){
            int mij = (st + dr) / 2;
            if(L2[dr].getY() <= X.getY()) return dr;
            else if(L2[st].getY() >= X.getY()) return st;
            else if((X.getY() >= L2[mij].getY()) && (X.getY() <= L2[mij + 1].getY())) {
                return mij;
            }else if(X.getY() < L2[mij].getY()){
                dr = mij - 1;
            }else if(X.getY() > L2[mij + 1].getY()) st = mij + 1;
        }
        
        return - 1;
    }

    public void initializeazaMatrice(int n){
        M = new int[n][n];
        int[][] N = new int[n][n];
        
        for(int i = 0; i < n; i++){
            N[i][0] = 0;
        }
        for(int j = 1; j < n; j++){
            int k = cautaL1inL2(j-1);
            for(int i = 0; i < k + 1; i++){
                N[i][j] = N[i][j - 1];
            }
            for(int i = k + 1; i < n; i++){
                N[i][j] = N[i][j - 1] + 1;
            }
        }
        int k = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                M[k][j] = N[i][j];
            }
            k++;
        }
    }

    public int cautaL1inL2(int j){
        for(int k = 0; k < L2.length; k++){
            if (L2[k] == L1[j]) return k;
        }
        return -1;
    }

    void sortOrizontala(Punct[] arr, int l, int r) 
    {   
        if (l < r) { 
            int m = (l + r) / 2; 
            sortOrizontala(arr, l, m); 
            sortOrizontala(arr, m + 1, r); 
            mergeOrizontala(arr, l, m, r); 
        }
        
    } 

    void mergeOrizontala(Punct[] arr, int s, int m, int d) 
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

    void sortVerticala(Punct[] arr, int l, int r) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 
            sortVerticala(arr, l, m); 
            sortVerticala(arr, m + 1, r); 
            mergeVerticala(arr, l, m, r); 
        }
        
    } 

    void mergeVerticala(Punct[] arr, int s, int m, int d) 
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
            if (stanga[i].getY() <= dreapta[j].getY()) { 
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