import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetodaArboreluiBinar extends JPanel implements ActionListener{
    private JPanel titlu;

    private JPanel desenDrepunghi;
    private JLabel rezultat;
    private Punct Ox1, Ox2, Oy1, Oy2, A, B, C, D;
    private Punct[] S, pcte = new Punct[4];
    private JButton check, add, refresh;
    private int x1, x2, y1, y2;
    private int totalPuncte;
    
    public MetodaArboreluiBinar(){
        initComponents();
    }

     public void initComponents(){
        titlu = new TitluPanel("Metoda arborelui binar bidimensional");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);
        
        Ox1 = new Punct(-250, 0);
        Ox2 = new Punct(250, 0);
        Oy1 = new Punct(0, -200);
        Oy2 = new Punct(0, 200);

        S = new Punct[10];
        S[0] = new Punct(10, 12); 
        S[1] = new Punct(2,4); 
        S[2] = new Punct(22, 14);
        S[3] = new Punct(6, 16);
        S[4] = new Punct(8, 6);
        S[5] = new Punct(14, 10);
        S[6] = new Punct(4, 8);
        S[7] = new Punct(12,2);
        S[8] = new Punct(18, 18);
        S[9] = new Punct(20, 6);

        S[0].setNume("1");
        S[1].setNume("2");
        S[2].setNume("3");
        S[3].setNume("4");
        S[4].setNume("5");
        S[5].setNume("6");
        S[6].setNume("7");
        S[7].setNume("8");
        S[8].setNume("9");
        S[9].setNume("10");

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
                pcte[0] = A; x1 = A.getX(); y2 = A.getY();
            }
            else if(B == null){
                B = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
                desenDrepunghi.repaint();
                pcte[1] = B; x2 = B.getX();
            }
            else if(C == null){
                C = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
                desenDrepunghi.repaint();
                pcte[2] = C; y1 = C.getY();
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
            totalPuncte = 0;
        }
    }

    public void getPuncte(){
        Node node = construiesteArbore(0, S.length - 1, S, 1);
        cautaInArbore(node);
        rezultat.setText("Patrulaterul cuprinde " + totalPuncte + " puncte.");  
    }

    public Node construiesteArbore(int st, int dr, Punct[] puncte, int taietura){
        if(taietura == 1) sortOrizontala(puncte, st, dr); 
        else sortVerticala(puncte, st, dr);
    
        int mij = (st+(dr+1))/2;

        Node node = new Node(puncte[mij], taietura);

        if(st < mij) node.setLeft(construiesteArbore(st, mij - 1, puncte, 1-taietura)); 
        if(dr > mij) node.setRight(construiesteArbore(mij + 1, dr, puncte, 1-taietura));

        return node;
    }

    public void cautaInArbore(Node node){
        if(node.taietura == 1){
            if(x1 <= node.punct.getX() && node.left != null) cautaInArbore(node.left);
            if(node.punct.getX() <= x2 && node.right != null) cautaInArbore(node.right);
            if(verificaPunct(node.punct.getX(), node.punct.getY())) totalPuncte++; 
        }
        if(node.taietura == 0){
            if(y1 <= node.punct.getY() && node.left != null) cautaInArbore(node.left);
            if(node.punct.getY() <= y2 && node.right != null) cautaInArbore(node.right);
            if(verificaPunct(node.punct.getX(), node.punct.getY())) totalPuncte++;
        }
    }

    public boolean verificaPunct(int x, int y){
        return((x1 <= x && x <= x2) && (y1 <= y && y <= y2));
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
    

    class Node {
        Node left, right;
        Punct punct;
        int taietura;

        public Node(Punct p, int taietura){
            this.taietura = taietura;
            this.punct = p;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left){
            this.left = left;
        }

        public void setRight(Node right){
            this.right = right;
        }
    }
}
