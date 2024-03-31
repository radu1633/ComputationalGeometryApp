import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Graham extends JPanel implements ActionListener{
    private JPanel desen;
    private Punct[] puncte;
    private Punct V1, V2, V3, V4, V5, V6, V7, V8, V9, V10;
    private JButton check;

    private JPanel titlu;

    public Graham(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel("Algoritmul Graham");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);

        puncte = new Punct[10];

        V1 = new Punct(9, 17);
        V2 = new Punct(12, 2); 
        V3 = new Punct(5, 13);
        V4 = new Punct(5, 19);
        V5 = new Punct(20, 20);
        V6 = new Punct(2, 3);
        V7 = new Punct(7, 4);
        V8 = new Punct(22, 12);
        V9 = new Punct(15, 8);
        V10 = new Punct(13, 21);

        puncte[0] = V1;
        puncte[1] = V2;
        puncte[2] = V3;
        puncte[3] = V4;
        puncte[4] = V5;
        puncte[5] = V6;
        puncte[6] = V7;
        puncte[7] = V8;
        puncte[8] = V9;
        puncte[9] = V10;
        
        desen = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                drawLines(g);
            }

            public void drawLines(Graphics g){
                Graphics2D g2d =(Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.translate(350, 250);

                g2d.drawLine(0, 200, 0, -200);
                Stroke stroke = new BasicStroke(2f);
                g2d.setStroke(stroke);
                g2d.drawLine(-250, 0, 250, 0);
                
                stroke = new BasicStroke(4f);
                g2d.setStroke(stroke);
                g2d.setColor(Color.RED); 

                for(int i = 0; i < puncte.length; i++){
                    g2d.drawLine(puncte[i].getX() * 10, -puncte[i].getY()*10, puncte[i].getX() * 10, -puncte[i].getY()*10);
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
        
    }
    

    
}
