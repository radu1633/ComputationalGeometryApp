import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class ColiniaritatePanel extends JPanel implements ActionListener{
    private JPanel titlu;

    private JPanel tabelPanel, A, B, C;
    private JLabel labelA, labelB, labelC;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18;
    private JTextField[] tf;
    private JButton cauta;
    private JLabel rezultat;

    private int[] a, b, c;

    public ColiniaritatePanel(){
        initComponents();
    }

    public void initComponents(){
        
        titlu = new TitluPanel ("Coliniaritate");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);
        
        A = new JPanel();
        B = new JPanel();
        C = new JPanel();

        labelA = new JLabel("A: ");
        labelB = new JLabel("B: ");
        labelC = new JLabel("C: ");

        tf = new JTextField[18];

        tf1 = new JTextField();     
        tf2 = new JTextField();     
        tf3 = new JTextField();     
        tf4 = new JTextField();     
        tf5 = new JTextField();     
        tf6 = new JTextField();     
        tf7 = new JTextField();     
        tf8 = new JTextField();    
        tf9 = new JTextField();     
        tf10 = new JTextField();    
        tf11 = new JTextField();    
        tf12 = new JTextField();    
        tf13 = new JTextField();    
        tf14 = new JTextField();    
        tf15 = new JTextField();    
        tf16 = new JTextField();    
        tf17 = new JTextField();    
        tf18 = new JTextField();    


        tf[0] = tf1;
        tf[1] = tf2;
        tf[2] = tf3;
        tf[3] = tf4;
        tf[4] = tf5;
        tf[5] = tf6;
        tf[6] = tf7;
        tf[7] = tf8;
        tf[8] = tf9;
        tf[9] = tf10;
        tf[10] = tf11;
        tf[11] = tf12;
        tf[12] = tf13;
        tf[13] = tf14;
        tf[14] = tf15;
        tf[15] = tf16;
        tf[16] = tf17;
        tf[17] = tf18;

        for(JTextField t : tf){
            t.setPreferredSize(new Dimension(50, 25));
            t.setBackground(Color.WHITE);
        }

        int i = 0;
        A.add(labelA);
        for(i = 0 ; i < 6; i++){
            if(i % 2 != 0) {
                tf[i].setText("0");
                tf[i].setEditable(false);
            }
            A.add(tf[i]);
        }
        B.add(labelB);
        for(i = 6 ; i < 12; i++){
            if(i % 2 != 0) {
                tf[i].setText("1");
                tf[i].setEditable(false);
            }
            B.add(tf[i]);
        }
        C.add(labelC);
        for(i = 12 ; i < 18; i++){
            if(i % 2 != 0) {
                tf[i].setText("2");
                tf[i].setEditable(false);
            }
            C.add(tf[i]);
        }
        JPanel buton = new JPanel();
        cauta = new JButton("Cauta puncte coliniare");
        cauta.setBackground(new Color(30, 30, 30));
        cauta.setForeground(new Color(0, 153, 153));
        cauta.setFocusable(false);
        buton.add(cauta);

        rezultat = new JLabel();

        tabelPanel = new JPanel();
        tabelPanel.setLayout(new BoxLayout(tabelPanel, BoxLayout.Y_AXIS));
        tabelPanel.add(Box.createVerticalStrut(150));
        tabelPanel.add(A); 
        tabelPanel.add(B); 
        tabelPanel.add(C);
        tabelPanel.add(Box.createVerticalStrut(20));
        tabelPanel.add(buton);
        tabelPanel.add(Box.createVerticalStrut(20));
        tabelPanel.add(rezultat);

        tabelPanel.setMaximumSize(new Dimension(700, 350));
        
        this.add(tabelPanel);
        

        a = new int[3];
        b = new int[3];
        c = new int[3];

        cauta.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cauta){
            int j = 0, i = 0, k = 0, m = 0;
            for(JTextField t : tf){
                if(j < 6) {
                    if(j % 2 == 0){
                        a[i] = Integer.parseInt(t.getText());
                        i++;
                    }
                    j++;
                }
                else if(j >= 6 && j < 12) {
                    if(j % 2 == 0){
                        b[k] = Integer.parseInt(t.getText());
                        k++;
                    }
                    j++;
                }
                else if(j >= 12 && j < 18){
                    if(j % 2 == 0){
                        c[m] = Integer.parseInt(t.getText());
                        m++;
                    }
                    j++;
                } 
                
            }
            
            coliniaritate();
        }
    }

    public void coliniaritate(){
        Arrays.sort(b);
        Arrays.sort(c);

        int[] E = new int[3];
        int[] D = new int[3];

        for(int i = 0; i < 3; i++){
            D[i] = b[i] * 2;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j ++){
                E[j] = a[i] + c[j];
            }

            int j = 0, k = 0;

            while( j < 3 && k < 3){
                if(D[j] == E[k]){
                    rezultat.setText(rezultat.getText() + "A("  + a[i] + ", 0)"  + ", " + "B(" +(D[j]/2) + ", 1)" + ", " + "C(" + (E[k] - a[i]) + ", 2)" + "   |||   ") ;
                    break;
                }
                if(D[j] < E[k]) j++;
                if(D[j] > E[k]) k++;
            }
        }
    }

    
    
}
