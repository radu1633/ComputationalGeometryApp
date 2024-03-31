import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poligon extends JPanel implements MouseListener{
    private JPanel titlu;

    private Punct axaOx1, axaOx2, axaOy1, axaOy2, A, B, C, D, E, F, G, H, I, J, M;
    private JLabel labelA, labelB, labelC, labelD, labelE, labelF, labelG, labelH, labelI, labelJ, rezultat;
    private Punct[] puncte;
    private JPanel poligon;



    public Poligon(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel("Localizare intr-un poligon simplu");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        puncte = new Punct[11];
        rezultat = new JLabel(" ");

        axaOx1 = new Punct(100, 300);
        axaOx2 = new Punct(600, 300);

        axaOy1 = new Punct(350, 100);
        axaOy2 = new Punct(350, 600);

        

        A = new Punct(350, 150); puncte[0] = A;
        B = new Punct(350, 300); puncte[1] = B;
        C = new Punct(450, 300); puncte[2] = C;
        D = new Punct(400, 200); puncte[3] = D;
        E = new Punct(550, 400); puncte[4] = E;
        F = new Punct(385, 450); puncte[5] = F;
        G = new Punct(400, 370); puncte[6] = G;
        H = new Punct(250, 370); puncte[7] = H;
        I = new Punct(320, 275); puncte[8] = I;
        J = new Punct(250, 225); puncte[9] = J;
        puncte[10] = A;
        
                  
        poligon = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }

            public void drawLines(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);
                g2d.drawLine(axaOx1.getX(), axaOx1.getY(), axaOx2.getX(), axaOx2.getY());
                g2d.drawLine(axaOy1.getX(), axaOy1.getY(), axaOy2.getX(), axaOy2.getY());
                g2d.setColor(Color.BLUE);
        
                int i;
                for(i = 0; i < puncte.length - 1; i++){
                    g2d.drawLine(puncte[i].getX(), puncte[i].getY(), puncte[i+1].getX(), puncte[i+1].getY());
                }
                g2d.setColor(Color.RED);
                if(M != null){
                    g2d.drawOval(M.getX(), M.getY(), 3, 3);
                    g2d.drawLine(M.getX(), M.getY(), M.getX() + 300, M.getY());
                }

            }
        };

        poligon.setMaximumSize(new Dimension(700, 450));

        labelA = new JLabel("A"); labelA.setForeground(Color.BLUE);
        labelB = new JLabel("B"); labelB.setForeground(Color.BLUE);
        labelC = new JLabel("C"); labelC.setForeground(Color.BLUE);
        labelD = new JLabel("D"); labelD.setForeground(Color.BLUE);
        labelE = new JLabel("E"); labelE.setForeground(Color.BLUE);
        labelF = new JLabel("F"); labelF.setForeground(Color.BLUE);
        labelG = new JLabel("G"); labelG.setForeground(Color.BLUE);
        labelH = new JLabel("H"); labelH.setForeground(Color.BLUE);
        labelI = new JLabel("I"); labelI.setForeground(Color.BLUE);
        labelJ = new JLabel("J"); labelJ.setForeground(Color.BLUE);

        poligon.setLayout(null);
        labelA.setBounds(355, 120, 50, 50);
        labelB.setBounds(355, 260, 50, 50);
        labelC.setBounds(450, 290, 50, 50);
        labelD.setBounds(400, 160, 50, 50);
        labelE.setBounds(550, 390, 50, 50);
        labelF.setBounds(385, 440, 50, 50);
        labelG.setBounds(410, 350, 50, 50);
        labelH.setBounds(250 ,360, 50, 50);
        labelI.setBounds(300, 250, 50, 50);
        labelJ.setBounds(235, 210, 50, 50);
        
        poligon.add(labelA);
        poligon.add(labelB);
        poligon.add(labelC);
        poligon.add(labelD);
        poligon.add(labelE);
        poligon.add(labelF);
        poligon.add(labelG);
        poligon.add(labelH);
        poligon.add(labelI);
        poligon.add(labelJ);

        JPanel rezultatPanel = new JPanel();
        this.add(poligon);
        this.add(Box.createVerticalStrut(20));
        rezultatPanel.setMaximumSize(new Dimension(700, 100));
        rezultatPanel.add(rezultat);
        this.add(rezultatPanel);
        

        poligon.addMouseListener(this);
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
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == poligon){
            int x = e.getX();
            int y = e.getY();

            M = new Punct(x, y);
            poligon.repaint();
            verificaPunct(M);
        }
    }

    public void verificaPunct(Punct M){
        int contorIntersectii = 0;

        Punct a = new Punct(0, 0);
        Punct b = new Punct(0, 0);
        
        for(int i = 0; i < puncte.length - 1; i++){
            
            
            if((puncte[i].getY() == puncte[i+1].getY() && puncte[i+1].getY() == M.getY()) && ((M.getX() - puncte[i].getX()) * (M.getX() - puncte[i].getX()) <= 0)){
                rezultat.setText("Punctul se afla pe frontiera!");
                return;
            }

            if(puncte[i].getY() > puncte[i+1].getY()){
                a = new Punct(puncte[i].getX(), puncte[i].getY());
                b = new Punct(puncte[i+1].getX(), puncte[i+1].getY());
            }

            if(puncte[i].getY() < puncte[i+1].getY()){
                a = new Punct(puncte[i+1].getX(), puncte[i+1].getY());
                b = new Punct(puncte[i].getX(), puncte[i].getY());
            }
            int detAMB = calculeazaDeterminant(a, M, b);
            if((puncte[i].getY() != puncte[i+1].getY()) && (M.getY() > b.getY() && M.getY() < a.getY())){
                if(detAMB > 0){
                    contorIntersectii++;
                }
                if(detAMB == 0){
                    rezultat.setText("Punctul se afla pe frontiera!");
                    return;
                }
            }

            if((puncte[i].getY() != puncte[i+1].getY()) && (M.getY() == a.getY())){
                if(M.getX() < a.getX()){
                    contorIntersectii++;
                }
                if(M.getX() == a.getX()){
                    rezultat.setText("Punctul se afla pe frontiera!");
                    return;
                }
            }

            if((puncte[i].getY() != puncte[i+1].getY()) && ((M.getY() == b.getY()) && (M.getX() == b.getX()))){
                rezultat.setText("Punctul se afla pe frontiera!");
                return;
            }
        }
        System.out.println(contorIntersectii);
        if(contorIntersectii % 2 == 0) {
            rezultat.setText("Punctul se afla in exteriorul poligonului!");
        }
        else rezultat.setText("Punctul se afla in interiorul poligonului!");
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
