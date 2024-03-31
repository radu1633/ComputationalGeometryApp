import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Triunghi extends JPanel implements MouseListener{
    private JPanel titlu;

    
    private JPanel triunghi;
    private Punct A1, A2, B1, B2, C1, C2, A, B, C, M;
    private JLabel rezultat;
    private JLabel labelA, labelB, labelC;

    public Triunghi(){
        initComponents();
    }

    public void initComponents(){
        
        titlu = new TitluPanel("Localizare in partitia indusa de un triunghi");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(titlu);
        
        A = new Punct(303, -114); B = new Punct(203, -291); C = new Punct(402, -391);

        A1 = new Punct(340, 50);
        A2 = new Punct(170, 350);
        B1 = new Punct(160, 270);
        B2 = new Punct(460, 420);
        C1 = new Punct(280, 50);
        C2 = new Punct(420, 440);

        triunghi = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }

            public void drawLines(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);
                g2d.drawLine(A1.getX(), A1.getY(), A2.getX(), A2.getY());
                g2d.drawLine(C1.getX(), C1.getY(), C2.getX(), C2.getY());
                g2d.drawLine(B1.getX(), B1.getY(), B2.getX(), B2.getY());

                g2d.setColor(Color.BLUE);
                if(M != null){
                    g2d.drawOval(M.getX(), -M.getY(), 3, 3);
                }
            }
        };
        triunghi.setMaximumSize(new Dimension(600, 450));
        this.add(triunghi);

        JPanel rezultatPanel = new JPanel();
        rezultatPanel.setMaximumSize(new Dimension(700, 100));
        rezultat = new JLabel();
        rezultatPanel.add(rezultat);
        this.add(rezultatPanel);

        labelA = new JLabel("A");
        labelB = new JLabel("B");
        labelC = new JLabel("C");

        triunghi.setLayout(null);
        labelA.setBounds(313, 95, 50, 50);
        labelB.setBounds(203, 280, 50, 50);
        labelC.setBounds(395, 375, 50, 50);
        triunghi.add(labelA);
        triunghi.add(labelB);
        triunghi.add(labelC);

        

        triunghi.addMouseListener(this);

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == triunghi){
            int x = e.getX();
            int y = e.getY();

            M = new Punct(x, -y);
            triunghi.repaint();

            int detMAB = calculeazaDeterminant(M, A, B);
            int detMBC = calculeazaDeterminant(M, B, C);
            int detMCA = calculeazaDeterminant(M, C, A);

            if (detMAB == 0){
                rezultat.setText("Punctul se afla pe latura AB");
            }
            else if (detMBC == 0){
                rezultat.setText("Punctul se afla pe latura BC");
            }
            else if (detMCA == 0){
                rezultat.setText("Punctul se afla pe latura AC");
            }
            else if((detMAB > 0) && (detMBC > 0) &&  (detMCA > 0)){
                rezultat.setText("Punctul se afla in interiorul triunghiului! -> 1");
            }
            else if (detMAB < 0 && detMBC > 0 && detMCA < 0){
                rezultat.setText("Punctul NU se afla in interiorul triunghiului! -> 2");
            }
            else if (detMAB < 0 && detMBC < 0 && detMCA > 0){
                rezultat.setText("Punctul NU se afla in interiorul triunghiului! -> 3");
            }
            else if (detMAB > 0 && detMBC < 0 && detMCA < 0){
                rezultat.setText("Punctul NU se afla in interiorul triunghiului! -> 4");
            }
            else if (detMAB < 0 && detMBC > 0 && detMCA > 0){
                rezultat.setText("Punctul NU se afla in interiorul triunghiului! -> 5");
            }
            else if (detMAB > 0 && detMBC > 0 && detMCA < 0){
                rezultat.setText("Punctul NU se afla in interiorul triunghiului! -> 6");
            }
            else if (detMAB > 0 && detMBC < 0 && detMCA > 0){
                rezultat.setText("Punctul NU se afla in interiorul triunghiului! -> 7");
            }
            else if (M.getX() == A.getX() && M.getY() == A.getY()){
                rezultat.setText("Punctul coincide cu A!");
            }
            else if (M.getX() == B.getX() && M.getY() == B.getY()){
                rezultat.setText("Punctul coincide cu B!");
            }
            else if (M.getX() == C.getX() && M.getY() == C.getY()){
                rezultat.setText("Punctul coincide cu C!");
            }
            
        }
    }

    public int calculeazaDeterminant(Punct M, Punct X, Punct Y){
        int a[][] = new int[3][3];
        a[0][0] = M.getX(); a[0][1] = M.getY(); a[0][2] = 1;
        a[1][0] = X.getX(); a[1][1] = X.getY(); a[1][2] = 1;
        a[2][0] = Y.getX(); a[2][1] = Y.getY(); a[2][2] = 1;

        int x = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[0][1] * a[1][2] * a[2][0]);
        int y = (a[0][2] * a[1][1] * a[2][0]) + (a[2][1] * a[1][2] * a[0][0]) + (a[1][0] * a[0][1] * a[2][2]);

        return x - y;
    }

    @Override
    public void mousePressed(MouseEvent e){}

    @Override
    public void mouseReleased(MouseEvent e){}
        
    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

}