import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class MetodaLanturilor extends JPanel implements ActionListener{
    private JPanel titlu;

    private JPanel desenPSLG;
    private ArrayList<Punct> varfuri;
    private Punct V1, V2, V3, V4, V5, V6, V7, V8, M;
    private ArrayList<Muchie> dcel;
    private JButton check;
    private JLabel rezultat;
    private ArrayList<ArrayList<Punct>> L = new ArrayList<>();
    private ArrayList<Punct> lant, desenLant;

    public MetodaLanturilor(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel ("Metoda lanturilor");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        varfuri = new ArrayList<>();

        V1 = new Punct(0, -15); 
        V2 = new Punct(12, -6);
        V3 = new Punct(-7, -4);        
        V4 = new Punct(0, 0);
        V5 = new Punct(15, 5);
        V6 = new Punct(-7, 7);
        V7 = new Punct(6, 11);
        V8 = new Punct(3, 20);
        
        varfuri.add(V1); 
        varfuri.add(V2); 
        varfuri.add(V3); 
        varfuri.add(V4); 
        varfuri.add(V5); 
        varfuri.add(V6); 
        varfuri.add(V7); 
        varfuri.add(V8); 
        V1.setNume("V1");
        V2.setNume("V2");
        V3.setNume("V3");
        V4.setNume("V4");
        V5.setNume("V5");
        V6.setNume("V6");
        V7.setNume("V7");
        V8.setNume("V8");

        desenPSLG = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }

            private void drawLines(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.translate(350, 250); 
                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);

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
                    //V2
                    g2d.drawLine(V2.getX()*10, -V2.getY()*10, V5.getX()*10, -V5.getY()*10);
                    g2d.drawLine(V2.getX()*10, -V2.getY()*10, V4.getX()*10, -V4.getY()*10);
                    //V3
                    g2d.drawLine(V3.getX()*10, -V3.getY()*10, V6.getX()*10, -V6.getY()*10);
                    g2d.drawLine(V3.getX()*10, -V3.getY()*10, V4.getX()*10, -V4.getY()*10);
                    //V4
                    g2d.drawLine(V4.getX()*10, -V4.getY()*10, V5.getX()*10, -V5.getY()*10);
                    g2d.drawLine(V4.getX()*10, -V4.getY()*10, V7.getX()*10, -V7.getY()*10);
                    //V5
                    g2d.drawLine(V5.getX()*10, -V5.getY()*10, V8.getX()*10, -V8.getY()*10);
                    g2d.drawLine(V5.getX()*10, -V5.getY()*10, V7.getX()*10, -V7.getY()*10);
                    //V6
                    g2d.drawLine(V6.getX()*10, -V6.getY()*10, V7.getX()*10, -V7.getY()*10);
                    g2d.drawLine(V6.getX()*10, -V6.getY()*10, V8.getX()*10, -V8.getY()*10);
                    //V7
                    g2d.drawLine(V7.getX()*10, -V7.getY()*10, V8.getX()*10, -V8.getY()*10);
                
                g2d.setColor(Color.BLACK);
                    g2d.drawString("1", V1.getX()*10, -V1.getY()*10 +3);
                    g2d.drawString("2", V2.getX()*10, -V2.getY()*10 +3);
                    g2d.drawString("3", V3.getX()*10, -V3.getY()*10 +3);
                    g2d.drawString("4", V4.getX()*10, -V4.getY()*10 +3);
                    g2d.drawString("5", V5.getX()*10, -V5.getY()*10 +3);
                    g2d.drawString("6", V6.getX()*10, -V6.getY()*10 +3);
                    g2d.drawString("7", V7.getX()*10, -V7.getY()*10 +3);
                    g2d.drawString("8", V8.getX()*10, -V8.getY()*10 +3);

                g2d.setColor(new Color(0,153,0));
                    g2d.drawString("F1", 120, 120);
                    g2d.drawString("F2", 40, 70);
                    g2d.drawString("F3", -30, 70);
                    g2d.drawString("F4", 70, 10);
                    g2d.drawString("F5", -30, -40);
                    g2d.drawString("F6", 60, -50);
                    g2d.drawString("F7", 80, -100);
                    g2d.drawString("F8", 10, -120);

                g2d.setColor(Color.ORANGE);
                    if(M != null) g2d.fillOval(M.getX() * 10, -M.getY() * 10, 10, 10);

                g2d.setColor(Color.GREEN);
                if(desenLant != null){
                    for(int i = 0; i < desenLant.size() - 1; i++){
                        g2d.drawLine(desenLant.get(i).getX() * 10, -desenLant.get(i).getY() * 10, desenLant.get(i+1).getX() * 10, -desenLant.get(i+1).getY() * 10);
                    }
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

    public void creeazaDCEL(){
        dcel = new ArrayList<>();

        dcel.add(new Muchie(1, V1, V3, 3, 1));
        dcel.add(new Muchie(1, V1, V4, 2, 3));
        dcel.add(new Muchie(1, V1, V2, 1, 2)); 
        dcel.add(new Muchie(1, V2, V4, 4, 2));
        dcel.add(new Muchie(1, V2, V5, 1, 4));
        dcel.add(new Muchie(1, V3, V6, 5, 1));
        dcel.add(new Muchie(1, V3, V4, 3, 5));
        dcel.add(new Muchie(1, V4, V7, 6, 5));
        dcel.add(new Muchie(1, V4, V5, 4, 6));
        dcel.add(new Muchie(1, V5, V7, 7, 6));
        dcel.add(new Muchie(1, V5, V8, 1, 7));
        dcel.add(new Muchie(1, V6, V8, 8, 1));
        dcel.add(new Muchie(1, V6, V7, 5, 8));
        dcel.add(new Muchie(1, V7, V8, 7, 8));

        Collections.sort(dcel, (m1, m2) -> {return Integer.compare(m1.getV1().getX(), m2.getV1().getX()); });
    }


    public void schimbaAlfaSiBeta(){
        ArrayList<Muchie> muchii = new ArrayList<>();
        for(int i = 1; i < varfuri.size() - 1; i++){
            int sumaAlfa = 0, sumaBeta = 0;
            muchii.clear();
            for(Muchie M:dcel){
                if(varfuri.get(i) == M.getV2()) sumaAlfa += M.getNr();
                else if(varfuri.get(i) == M.getV1()) {
                    sumaBeta += M.getNr();
                    muchii.add(M);
                }
            }
            Collections.sort(muchii, (p1, p2) -> {return Integer.compare(p1.getV2().getX(), p2.getV2().getX()); });
            if(sumaAlfa > sumaBeta) muchii.get(0).setNr(sumaAlfa - sumaBeta);
        }
        System.out.println();
        for(int i = varfuri.size() - 2; i >=1; i--){
            int sumaAlfa = 0, sumaBeta = 0;
            muchii.clear();
            for(Muchie M:dcel){
                if(varfuri.get(i) == M.getV2()) {
                    sumaAlfa += M.getNr();
                    muchii.add(M);
                }else if(varfuri.get(i) == M.getV1()) sumaBeta += M.getNr();
            }
            Collections.sort(muchii, (p1, p2) -> {return Integer.compare(p1.getV2().getX(), p2.getV2().getX()); });
            if(sumaBeta > sumaAlfa) muchii.get(0).setNr(sumaBeta - sumaAlfa);   
        }
    }

    public void creeazaLanturi(){
        Muchie muchie = null, muchie1 = null;
        ArrayList<Punct> varfuri1 = new ArrayList<>();
        for(Punct varf:varfuri) if(gasesteMuchie(V1, varf) != null) varfuri1.add(varf);
                
        Collections.sort(varfuri1, (V1, V2) -> {return Integer.compare(V1.getX(), V2.getX()); });
        ArrayList<Muchie> temp = new ArrayList<>();
        
        for(int i = 0; i < varfuri1.size(); i++){
            muchie = gasesteMuchie(V1, varfuri1.get(i));  
            while(muchie.getNr() != 0){
                lant = new ArrayList<>();
                lant.add(V1); lant.add(varfuri1.get(i));
                Punct V = varfuri1.get(i);
                while(!lant.contains(V8)){
                    for(int j = 0; j < varfuri.size(); j++){
                        if((muchie1 = gasesteMuchie(V, varfuri.get(j))) != null){
                            if(muchie1.getNr() != 0)
                                temp.add(muchie1);
                        }
                    }
                    Collections.sort(temp, (much1, much2) -> {return Integer.compare(much1.getV1().getX(), much2.getV2().getX()); });
                    V = temp.get(0).getV2();
                    lant.add(V);
                    temp.get(0).setNr(-1);
                    temp.clear();
                }
                muchie.setNr(-1);
                L.add(lant);
            }
        }
    }

    private Muchie gasesteMuchie(Punct V1, Punct V2){
        for(Muchie muchie:dcel){
            if(muchie.getV1() == V1 && muchie.getV2() == V2) return muchie;
        }
        return null;
    }

    public Muchie cautaLant(int st, int dr, ArrayList<Muchie> muchii){ 
        
        while(st<=dr){
            int mij = (st+dr)/2;
            if(mij + 1 == muchii.size()) return muchii.get(mij);
            else {
                if(calculeazaDeterminant(muchii.get(mij).getV1(), M, muchii.get(mij).getV2()) > 0 && calculeazaDeterminant(muchii.get(mij + 1).getV1(), M, muchii.get(mij + 1).getV2()) < 0) return muchii.get(mij);
                else if(calculeazaDeterminant(muchii.get(mij).getV1(), M, muchii.get(mij).getV2()) > 0 && calculeazaDeterminant(muchii.get(mij + 1).getV1(), M, muchii.get(mij + 1).getV2()) > 0) st = mij + 1;
                else if(calculeazaDeterminant(muchii.get(mij).getV1(), M, muchii.get(mij).getV2()) < 0 && calculeazaDeterminant(muchii.get(mij + 1).getV1(), M, muchii.get(mij + 1).getV2()) < 0) dr = mij - 1;
            }
        }
        return null;
    }

    public ArrayList<Muchie> cautaMuchii(){
        ArrayList<Muchie> muchii = new ArrayList<>();
        for(int i = 0; i < dcel.size(); i++){
            if((dcel.get(i).getV1().getY() <= M.getY()) && (dcel.get(i).getV2().getY() >= M.getY())){ 
                muchii.add(dcel.get(i));
            }  
        }
        if(!muchii.isEmpty()) return muchii;
        return null;
    }

    public ArrayList<Punct> cautaMuchieInLant(Muchie muchie){
        for(ArrayList<Punct> lant:L){
            for(int i = 0; i < lant.size() - 1; i++)
                if(lant.get(i) == muchie.getV1() && lant.get(i + 1) == muchie.getV2()) return lant;
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
        creeazaDCEL();
        schimbaAlfaSiBeta();
        creeazaLanturi();

        ArrayList<Muchie> muchii = cautaMuchii();
        Muchie muchie = cautaLant(0, muchii.size() - 1,muchii);
        if(muchie == null){
            rezultat.setText("Punctul M( " + M.getX() + ", " + M.getY() + ") este pe fata 1.");
            return;
        }
        
        desenLant = cautaMuchieInLant(muchie);
        desenPSLG.repaint();

        int fata = -1;
        if(calculeazaDeterminant(muchie.getV1(), M, muchie.getV2()) > 0) fata = muchie.getF1();
        else if(calculeazaDeterminant(muchie.getV1(), M, muchie.getV2()) < 0) fata = muchie.getF2();
        else {
            rezultat.setText("Punctul M( " + M.getX() + ", " + M.getY() + ") este chiar pe muchie");
            return;
        }
        rezultat.setText("Punctul M( " + M.getX() + ", " + M.getY() + ") este pe fata " + fata + ".");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check){
            String nr = JOptionPane.showInputDialog("Introduceti coordonatele punctului M:");
            String[] nr2 = nr.split(",");
            M = new Punct(Integer.parseInt(nr2[0]), Integer.parseInt(nr2[1]));
            System.out.println("M(" + M.getX() + ", " + M.getY() + ")");
            desenPSLG.repaint();
            gasestePunct();
        }
    }

    class Muchie{
        private int nr,f1,f2;
	    private Punct v1,v2;

        public Muchie(int nr, Punct v1, Punct v2, int f1, int f2){
            this.nr = nr;
            this.v1 = v1;
            this.v2 = v2;
            this.f1 = f1;
            this.f2 = f2;
        }

        public int getNr(){
            return nr;
        }

        public void setNr(int i){
            nr += i;
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

        public void inverseaza(){
            Punct p;
            p = v1;
            v1=v2;
		    v2=p;
		
		    f1=f1+f2;
		    f2=f1-f2;
		    f1=f1-f2;
        }
    }


    
}
