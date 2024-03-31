import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MetodaLespezilor extends JPanel implements ActionListener{
    private JPanel titlu;

    private JPanel desenPSLG;
    private Punct[] varfuri;
    private Punct V1, V2, V3, V4, V5, V6, V7, V8, M;
    private Color color = new Color(0,153,0);
    private JButton check;
    private Muchie[] muchii;
    private Muchie muchie;
    private int[] B1, A2, B2, A3, B3, A4, B4, A5, B5, A6, B6, A7, B7;
    private ArrayList<Integer> L1, L2, L3, L4, L5, L6, L7;
    private JLabel rezultat;
    private Integer[] lista;
    private int ok;


    public MetodaLespezilor(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel("Metoda lespezilor");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        varfuri = new Punct[8];

        V1 = new Punct(0, -15);
        V2 = new Punct(-7, -6);
        V3 = new Punct(1, -4);
        V4 = new Punct(12, 0);
        V5 = new Punct(-7, 5);
        V6 = new Punct(12, 7);
        V7 = new Punct(4, 9);
        V8 = new Punct(0, 15);
        
        varfuri[0]= V1;
		varfuri[1]= V2;
		varfuri[2]= V3;
		varfuri[3]= V4;
		varfuri[4]= V5;
		varfuri[5]= V6;
		varfuri[6]= V7;
		varfuri[7]= V8;


        desenPSLG = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }

            private void drawLines(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.translate(350, 250);
                //g2d.drawLine(Oy1.getX(), Oy1.getY(), Oy2.getX(), Oy2.getY());
                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);
                //g2d.drawLine(Ox1.getX(), Ox1.getY(), Ox2.getX(), Ox2.getY());
                
                g2d.setColor(Color.MAGENTA);
                    g2d.fillOval(V1.getX()*10 - 9, -V1.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V2.getX()*10 - 9, -V2.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V3.getX()*10 - 9, -V3.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V4.getX()*10 - 9, -V4.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V5.getX()*10 - 9, -V5.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V6.getX()*10 - 9, -V6.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V7.getX()*10 - 9, -V7.getY()*10 - 13, 25, 25);
                    g2d.fillOval(V8.getX()*10 - 9, -V8.getY()*10 - 13, 25, 25);

                    //V1
                    g2d.drawLine(V1.getX()*10, -V1.getY()*10, V2.getX()*10, -V2.getY()*10);
                    g2d.drawLine(V1.getX()*10, -V1.getY()*10, V3.getX()*10, -V3.getY()*10);
                    g2d.drawLine(V1.getX()*10, -V1.getY()*10, V4.getX()*10, -V4.getY()*10);

                    g2d.drawString("11", (V1.getX()+V2.getX())/2 * 10 - 8, -(V1.getY()+V2.getY())/2 * 10);
                    g2d.drawString("12", (V1.getX()+V4.getX())/2 * 10 - 12, -(V1.getY()+V4.getY())/2 * 10);
                    g2d.drawString("13", (V1.getX()+V3.getX())/2 * 10 - 12, -(V1.getY()+V3.getY())/2 * 10);

                    //V2
                    g2d.drawLine(V2.getX()*10, -V2.getY()*10, V5.getX()*10, -V5.getY()*10);
                    g2d.drawString("4", (V2.getX()+V5.getX())/2 * 10 - 12, -(V2.getY()+V5.getY())/2 * 10);

                    //V3
                    g2d.drawLine(V3.getX()*10, -V3.getY()*10, V5.getX()*10, -V5.getY()*10);
                    g2d.drawLine(V3.getX()*10, -V3.getY()*10, V6.getX()*10, -V6.getY()*10);
                    g2d.drawLine(V3.getX()*10, -V3.getY()*10, V7.getX()*10, -V7.getY()*10);
                    g2d.drawLine(V3.getX()*10, -V3.getY()*10, V8.getX()*10, -V8.getY()*10);

                    g2d.drawString("3", (V3.getX()+V5.getX())/2 * 10 - 12, -(V3.getY()+V5.getY())/2 * 10);
                    g2d.drawString("7", (V3.getX()+V8.getX())/2 * 10 - 12, -(V3.getY()+V8.getY())/2 * 10);
                    g2d.drawString("8", (V3.getX()+V7.getX())/2 * 10 + 7, -(V3.getY()+V7.getY())/2 * 10);
                    g2d.drawString("9", (V3.getX()+V6.getX())/2 * 10 - 12, -(V3.getY()+V6.getY())/2 * 10);

                    //V4
                    g2d.drawLine(V4.getX()*10, -V4.getY()*10, V6.getX()*10, -V6.getY()*10);

                    g2d.drawString("10", (V4.getX()+V6.getX())/2 * 10 + 2, -(V4.getY()+V6.getY())/2 * 10);

                    //V5
                    g2d.drawLine(V5.getX()*10, -V5.getY()*10, V8.getX()*10, -V8.getY()*10);

                    g2d.drawString("1", (V5.getX()+V8.getX())/2 * 10 - 12, -(V5.getY()+V8.getY())/2 * 10);

                    //V6
                    g2d.drawLine(V6.getX()*10, -V6.getY()*10, V7.getX()*10, -V7.getY()*10);
                    g2d.drawLine(V6.getX()*10, -V6.getY()*10, V8.getX()*10, -V8.getY()*10);

                    g2d.drawString("6", (V6.getX()+V7.getX())/2 * 10, -(V6.getY()+V7.getY())/2 * 10 + 13);
                    g2d.drawString("5", (V6.getX()+V8.getX())/2 * 10 + 10, -(V6.getY()+V8.getY())/2 * 10);

                    //V7
                    g2d.drawLine(V7.getX()*10, -V7.getY()*10, V8.getX()*10, -V8.getY()*10);

                    g2d.drawString("2", (V7.getX()+V8.getX())/2 * 10 + 8, -(V7.getY()+V8.getY())/2 * 10 + 5);

                g2d.setColor(Color.BLACK);
                    g2d.drawString("1", V1.getX()*10, -V1.getY()*10 +3);
                    g2d.drawString("2", V2.getX()*10, -V2.getY()*10 +3);
                    g2d.drawString("3", V3.getX()*10, -V3.getY()*10 +3);
                    g2d.drawString("4", V4.getX()*10, -V4.getY()*10 +3);
                    g2d.drawString("5", V5.getX()*10, -V5.getY()*10 +3);
                    g2d.drawString("6", V6.getX()*10, -V6.getY()*10 +3);
                    g2d.drawString("7", V7.getX()*10, -V7.getY()*10 +3);
                    g2d.drawString("8", V8.getX()*10, -V8.getY()*10 +3);

                g2d.setColor(color);
                    g2d.drawString("F1", 100, 100);
                    g2d.drawString("F2", 50, 35);
                    g2d.drawString("F3", -45, 40);
                    g2d.drawString("F4", -40, -50);
                    g2d.drawString("F5", 12, -50);
                    g2d.drawString("F6", 50, -50);
                    g2d.drawString("F7", 50, -100);

                g2d.setColor(Color.ORANGE);
                    if(M != null) g2d.fillOval(M.getX() * 10, -M.getY() * 10, 10, 10);
                g2d.setColor(Color.RED);
                Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2d.setStroke(dashed);
                if(ok == 1){
                    g2d.drawLine(-15 * 10, 15 * 10, 15 * 10, 15 * 10); //V1
                    g2d.drawLine(-15 * 10, 7 * 10, 15 * 10, 7 * 10); //V2
                    g2d.drawLine(-15 * 10, 4 * 10, 15 * 10, 4 * 10); //V3
                    g2d.drawLine(-15 * 10, 0 * 10, 15 * 10, 0 * 10); //V4
                    g2d.drawLine(-15 * 10, -5 * 10, 15 * 10, -5 * 10); //V5
                    g2d.drawLine(-15 * 10, -7 * 10, 15 * 10, -7 * 10); //V6
                    g2d.drawLine(-15 * 10, -9 * 10, 15 * 10, -9 * 10); //V7
                    g2d.drawLine(-15 * 10, -15 * 10, 15 * 10, -15 * 10); //V8

                    g2d.drawString("L1", (-15 + -15)/2 * 10, (15+7)/2 * 10);
                    g2d.drawString("L2", (-15 + -15)/2 * 10, (4+7)/2 * 10 + 7);
                    g2d.drawString("L3", (-15 + -15)/2 * 10, (4+0)/2 * 10);
                    g2d.drawString("L4", (-15 + -15)/2 * 10, (0+-5)/2 * 10);
                    g2d.drawString("L5", (-15 + -15)/2 * 10, (-5+-7)/2 * 10 + 7);
                    g2d.drawString("L6", (-15 + -15)/2 * 10, (-7+-9)/2 * 10 + 7);
                    g2d.drawString("L7", (-15 + -15)/2 * 10, (-9+-15)/2 * 10);
                }
            }
            
        };

        desenPSLG.setMaximumSize(new Dimension(700, 450));
        this.add(desenPSLG);

        rezultat = new JLabel();

        JPanel button = new JPanel();
        JPanel result = new JPanel();
        result.setMaximumSize(new Dimension(700, 80));
        result.add(rezultat);
        button.setMaximumSize(new Dimension(700, 80));
        check = new JButton("Check");
        button.add(check);
        
        check.setBackground(new Color(30, 30, 30));
        check.setForeground(new Color(0, 153, 153));
        check.setFocusable(false);

        this.add(button);
        this.add(result);


        check.addActionListener(this);
    }

    public void createMuchie(){
        muchii = new Muchie[13];

        muchii[0] = new Muchie(11, V1, V2, 3, 1, 12, 4);
        muchii[1] = new Muchie(13, V1, V3, 2, 3, 11, 9);
        muchii[2] = new Muchie(12, V1, V4, 1, 2, 13, 10);
        muchii[3] = new Muchie(4, V2, V5, 3, 1, 11, 3);
        muchii[4] = new Muchie(10, V4, V6, 1, 2, 12, 5);
        muchii[5] = new Muchie(3, V3, V5, 4, 3, 13, 1);
        muchii[6] = new Muchie(7, V3, V8, 5, 4, 3, 2);
        muchii[7] = new Muchie(8, V3, V7, 6, 5, 7, 6);
        muchii[8] = new Muchie(9, V3, V6, 2, 6, 8, 10);
        muchii[9] = new Muchie(1, V5, V8, 4, 1, 4, 7);
        muchii[10] = new Muchie(6, V6, V7, 7, 6, 9, 2);
        muchii[11] = new Muchie(2, V7, V8, 7, 5, 8, 1);
        muchii[12] = new Muchie(5, V6, V8, 1, 7, 6, 1);

        initializeazaMultimi();
    }

    public void initializeazaMultimi(){
        B1 = new int[]{11, 13, 12};
        A2 = new int[]{11}; B2 = new int[]{4};
        A3 = new int[]{13}; B3 = new int[]{3, 7, 8, 9};
        A4 = new int[]{12}; B4 = new int[]{10};
        A5 = new int[]{4,3}; B5 = new int[]{1};
        A6 = new int[]{9,10}; B6 = new int[]{6,5};
        A7 = new int[]{8,6}; B7 = new int[]{2};

        initializeazaLespezi();
    }

    public void initializeazaLespezi(){
        int poz = -1;
        L1 = new ArrayList<>();
        for(int elem:B1) L1.add(elem);

        L2 = new ArrayList<>();
        for(int elem:L1) L2.add(elem);
        if(L2.contains(A2[0])) poz = L2.indexOf(A2[0]); L2.remove(poz);
        for(int i = 0; i < B2.length; i++) L2.add(poz++, B2[i]);

        L3 = new ArrayList<>();
        for(int elem:L2) L3.add(elem);
        if(L3.contains(A3[0])) poz = L3.indexOf(A3[0]); L3.remove(poz);
        for(int i = 0; i < B3.length; i++) L3.add(poz++, B3[i]);

        L4 = new ArrayList<>();
        for(int elem:L3) L4.add(elem);
        if(L4.contains(A4[0])) poz = L4.indexOf(A4[0]); L4.remove(poz);
        for(int i = 0; i < B4.length; i++) L4.add(poz++, B4[i]);

        L5 = new ArrayList<>();
        for(int elem:L4) L5.add(elem);
        if(L5.contains(A5[0])) poz = L5.indexOf(A5[0]); L5.remove(poz);
        if(L5.contains(A5[1])) poz = L5.indexOf(A5[1]); L5.remove(poz);
        for(int i = 0; i < B5.length; i++) L5.add(poz++, B5[i]);

        L6 = new ArrayList<>();
        for(int elem:L5) L6.add(elem);
        if(L6.contains(A6[0])) poz = L6.indexOf(A6[0]); L6.remove(poz);
        if(L6.contains(A6[1])) poz = L6.indexOf(A6[1]); L6.remove(poz);
        for(int i = 0; i < B6.length; i++) L6.add(poz++, B6[i]);

        L7 = new ArrayList<>();
        for(int elem:L6) L7.add(elem);
        if(L7.contains(A7[0])) poz = L7.indexOf(A7[0]); L7.remove(poz);
        if(L7.contains(A7[1])) poz = L7.indexOf(A7[1]); L7.remove(poz);
        for(int i = 0; i < B7.length; i++) L7.add(poz++, B7[i]);
    }

    public void interschimba(){
		for(int i = 0; i < muchii.length; i++){
			if(muchii[0].getV1().getY() > muchii[0].getV2().getY()){
                muchii[0].inverseaza();
            }
		}
	}

    public ArrayList<Integer> cautareBinaraVerticala(){
        int st = 0, dr = varfuri.length - 1;
        while(st <= dr){
            int mij = (st + dr) / 2;
            if((varfuri[mij].getY() <= M.getY()) && (varfuri[mij+1].getY() >= M.getY())){
                if(varfuri[mij] == V1) return L1;
                else if(varfuri[mij] == V2) return L2;
                else if(varfuri[mij] == V3) return L3;
                else if(varfuri[mij] == V4) return L4;
                else if(varfuri[mij] == V5) return L5;
                else if(varfuri[mij] == V6) return L6;
                else if(varfuri[mij] == V7) return L7;
            } 
            else if(M.getY() < varfuri[mij].getY()) dr  = mij - 1;
            else if(M.getY() > varfuri[mij + 1].getY()) st = mij + 1;
        }
        return null;
    } 

    public void cautareBinara(int st, int dr){ 
        int mij = (st+dr)/2;
        muchie = cautaMuchie(lista[mij]);
        if(st<dr)
            if(calculeazaDeterminant(muchie.getV1(), M, muchie.getV2()) > 0) cautareBinara(mij+1, dr);
            else cautareBinara(st, mij-1);

    }

    public Muchie cautaMuchie(int x){
        for(Muchie m:muchii){ 
            if(m.getNr() == x) return m;
        }
        return null;
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

    public void gasestePunct(){
        createMuchie();
        interschimba();

        ArrayList<Integer> temp = cautareBinaraVerticala();
        lista = temp.toArray(new Integer[temp.size()]);
        if(lista == null){
            rezultat.setText("Punctul M( " + M.getX() + ", " + M.getY() + ") este pe fata 1.");
            return;
        }
        
        cautareBinara(0, lista.length - 1);
        
        int fata = - 1;
        if(calculeazaDeterminant(muchie.getV1(), M, muchie.getV2()) > 0 ) fata = muchie.getF1();
        else fata = muchie.getF2();

        rezultat.setText("Punctul M( " + M.getX() + ", " + M.getY() + ") este pe fata " + fata + ".");

    }
	

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check){
            String nr = JOptionPane.showInputDialog("Introduceti coordonatele punctului M:");
            String[] nr2 = nr.split(",");
            M = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
            System.out.println("M(" + M.getX() + ", " + M.getY() + ")");
            ok = 1;
            desenPSLG.repaint();
            gasestePunct();
        }
    }

    class Muchie{
        private int nr,f1,f2,p1,p2;
	    private Punct v1,v2;

        public Muchie(int nr, Punct v1, Punct v2, int f1, int f2, int p1, int p2){
            this.nr = nr;
            this.v1 = v1;
            this.v2 = v2;
            this.f1 = f1;
            this.f2 = f2;
            this.p1 = p1;
            this.p2 = p2;
        }

        public int getNr(){
            return nr;
        }
        
        public Punct getV1(){
            return v1;
        }
        
        public Punct getV2(){
            return v2;
        }
        
        public int getF1(){
            return f1;
        }
        
        public int getF2(){
            return f2;
        }
        
        public int getP1(){
            return p1;
        }
        
        public int getP2(){
            return p2;
        }

        public void inverseaza(){
            Punct p;
            p = v1;
            v1=v2;
		    v2=p;
		
		    f1=f1+f2;
		    f2=f1-f2;
		    f1=f1-f2;
		
		    p1=p1+p2;
		    p2=p1-p2;
		    p2=p1-p2;
        }   
    }

    
}
