import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Graham2 extends JFrame implements ActionListener{

        Point G, Ox1, Ox2, Oy1, Oy2;
        JPanel panel1,panel2;
        JButton b1;
        ArrayList<Point> puncte = new ArrayList<>();
        ArrayList<Point> puncte1;
        int x1,x2,y1,y2;

        Graham2(){
            super("Graham");
            puncte.add(new Point(2,2));
            puncte.add(new Point(4,6));
            puncte.add(new Point(3,11));
            puncte.add(new Point(7,3));
            puncte.add(new Point(8,8));
            puncte.add(new Point(12,10));
            puncte.add(new Point(10,5));
            puncte.add(new Point(14,3));

            Ox1 = new Point(-150, 0);
            Ox2 = new Point(150, 0);
            Oy1 = new Point(0, 120);
            Oy2 = new Point(0, -120);


            panel1 = new JPanel(){
                public void paint(Graphics g){
                    super.paint(g);
                    drawLines(g);
                }
                public void drawLines(Graphics g){
                    Graphics2D g2d = (Graphics2D)g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Stroke stroke = new BasicStroke(2f);
                    g2d.setStroke(stroke);

                    g.translate(200, 150);
                    g2d.drawLine(Ox1.getX(), -Ox1.getY(), Ox2.getX(), -Ox2.getY());
                    g2d.drawLine(Oy1.getX(), -Oy1.getY(), Oy2.getX(), -Oy2.getY());

                    g.setColor(Color.magenta);
                    for(int i = 0; i < puncte.size(); i++){
                        g.fillOval(puncte.get(i).getX() * 10, -puncte.get(i).getY() * 10, 3, 3);
                    }
                    g.setColor(Color.PINK);
                    if(puncte1 != null){
                        for(int i = 0; i < puncte1.size() - 1; i++)
                            g2d.drawLine(puncte1.get(i).getX() * 10, -puncte1.get(i).getY() * 10, puncte1.get(i + 1).getX() * 10, -puncte1.get(i + 1).getY() * 10);
                        g2d.drawLine(puncte1.get(0).getX() * 10, -puncte1.get(0).getY() * 10, puncte1.get(puncte1.size()-1).getX() * 10, -puncte1.get(puncte1.size() - 1).getY() * 10);
                    }
                }

            };

            b1 = new JButton("Verifica"); b1.setFocusable(false); b1.setBackground(Color.darkGray); b1.setForeground(Color.white);
           
            panel1.setMaximumSize(new Dimension(400, 300));
            panel2 = new JPanel();
            panel2.setPreferredSize(new Dimension(400,120));
            panel2.add(b1);
            this.add(panel2, BorderLayout.SOUTH);
            this.add(panel1);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(400, 500);
            this.setVisible(true);
            this.setLayout(null);

            b1.addActionListener(this);
    }
    
    public static void main(String[] args) {
        new Graham2();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            check();
        }
    }

    public void check(){
        G = calculeazaCentruGreutate(puncte.get(0), puncte.get(3), puncte.get(4));
        for(int i = 0; i < puncte.size() ; i++){
            puncte.get(i).setX(puncte.get(i).getX() - G.getX());
            puncte.get(i).setY(puncte.get(i).getY() - G.getY());
        }
        G.setX(0); G.setY(0);
        panel1.repaint();
        
        Point minim = puncte.get(0);
        for(Point p:puncte){
            if(p.getY() < minim.getY()) minim = p;
        }
        setUrmAnt();
        graham(minim);
        panel1.repaint();
        
    }

    public void setUrmAnt(){
        puncte.get(0).setUrm(puncte.get(1));
        puncte.get(0).setAnt(puncte.get(puncte.size() - 1));

        for(int i = 1; i < puncte.size() - 1; i++){
            puncte.get(i).setUrm(puncte.get(i+1));
            puncte.get(i).setAnt(puncte.get(i-1));
        }

        puncte.get(puncte.size() - 1).setUrm(puncte.get(0));
        puncte.get(puncte.size() - 1).setAnt(puncte.get(puncte.size() - 2));

    }

    public void graham(Point p){
        puncte1 = new ArrayList<>();
        for(Point x:puncte) puncte1.add(x);

        while(p.getUrm() != puncte1.get(0)){
            if(calculeazaDeterminant(p, p.getUrm(), p.getUrm().getUrm()) > 0) p = p.getUrm();
            else{
                Point del = p.getUrm();
                p.getUrm().getUrm().setAnt(p);
                p.setUrm(p.getUrm().getUrm());
                puncte1.remove(del);
                if(p != puncte1.get(0)) p = p.getAnt();
            }
        }
    }

    public Point calculeazaCentruGreutate(Point A, Point B, Point C){
        int x = (A.getX() + B.getX() + C.getX()) / 3;
        int y = (A.getY() + B.getY() + C.getY()) / 3;
        Point S = new Point(x, y);

        return S;
    }

    public int calculeazaDeterminant(Point A, Point M, Point B){
        int a[][] = new int[3][3];
        a[0][0] = A.getX(); a[0][1] = -A.getY(); a[0][2] = 1;
        a[1][0] = M.getX(); a[1][1] = -M.getY(); a[1][2] = 1;
        a[2][0] = B.getX(); a[2][1] = -B.getY(); a[2][2] = 1;

        int x = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[0][1] * a[1][2] * a[2][0]);
        int y = (a[0][2] * a[1][1] * a[2][0]) + (a[2][1] * a[1][2] * a[0][0]) + (a[1][0] * a[0][1] * a[2][2]);

        return x - y;
    }

    class Point{
        Point urm;
        Point ant;
        int x, y;

        Point(int xPunct, int yPunct){
            this.x = xPunct;
            this.y = yPunct;
        }

        public int getX(){
            return x;
        }
    
        public int getY(){
            return y;
        }
    
        public void setX(int x){
            this.x = x; 
        }
    
        public void setY(int y){
            this.y = y;
        }

        public void setUrm(Point p){
            this.urm = p;
        }

        public void setAnt(Point p){
            this.ant = p;
        }

        public Point getUrm(){
            return urm;
        }
        
        public Point getAnt(){
            return ant;
        }
    }
}
