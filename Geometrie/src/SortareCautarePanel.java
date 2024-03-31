import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SortareCautarePanel extends JPanel implements ActionListener{
    private JPanel titlu;

    private int[] array;
    private JPanel vectorPanel, buttons;
    private JTextField[] tf;
    private JButton sort, search;
    private JLabel booleanLabel;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10;

    public SortareCautarePanel(){
        initComponents();
    }

    public void initComponents(){

        array = new int[11];
        genereazaVector();

        titlu = new TitluPanel("Sortare & Cautare Binara");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        vectorPanel = new JPanel();
        vectorPanel.setMaximumSize(new Dimension(700, 40));

        tf = new JTextField[10]; 
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

        

        int i = 0;  
        for(JTextField t : tf){
            t.setPreferredSize(new Dimension(50, 30));
            t.setText(String.valueOf(array[i])); i++;
            t.setHorizontalAlignment(JTextField.CENTER);
            t.setEditable(false);
            t.setBackground(Color.WHITE);
            vectorPanel.add(t);
        }


        buttons = new JPanel();
        sort = new JButton("Sorteaza", null);
        search = new JButton("Cauta", null);

        sort.setPreferredSize(new Dimension(100, 30));
        search.setPreferredSize(new Dimension(100, 30));
        sort.setFocusable(false);
        search.setFocusable(false);
        search.setEnabled(false);

        sort.setBackground(new Color(30, 30, 30));
        search.setBackground(new Color(30, 30, 30));
        sort.setForeground(new Color(0, 153, 153));
        search.setForeground(new Color(0, 153, 153));

        buttons.setMaximumSize(new Dimension(700, 40));

        buttons.add(sort); buttons.add(search);
        
        booleanLabel = new JLabel();

        this.add(titlu);
        this.add(Box.createVerticalStrut(200));
        this.add(vectorPanel);
        this.add(Box.createVerticalStrut(10));
        this.add(booleanLabel);
        this.add(Box.createVerticalStrut(10));
        this.add(buttons);

        sort.addActionListener(this);
        search.addActionListener(this);
        
    }

    public void genereazaVector(){
        for(int i = 0 ; i < 10; i++){
            array[i] = (int)(Math.random() * 101) + 0;
        }
    }

    
    public void actionPerformed(ActionEvent e) {
        SortareSiCautareBinara ssc = new SortareSiCautareBinara();
        if(e.getSource() == sort){
            
            ssc.sort(array, 0, array.length - 1); 
            int i = 0;
            for(JTextField t : tf){
                t.setText(String.valueOf(array[i])); i++;
                t.setHorizontalAlignment(JTextField.CENTER);
            }
            
            search.setEnabled(true);
            sort.setEnabled(false);
        }

        if(e.getSource() == search){
            String s = JOptionPane.showInputDialog("Care este elementul cautat?");
            if(s.equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati tastat niciun numar!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String[] s1 = s.split(" ");
                int nr = Integer.parseInt(s1[0]);
                if(s1.length > 1) {
                    JOptionPane.showMessageDialog(null, "Ati tastat mai multe numere. Incercati din nou.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    
                    int bs = ssc.binarySearch(array, nr, 0, array.length-1);
                    if(bs == -1 ) {
                        booleanLabel.setText("Da");
                        booleanLabel.setForeground(Color.GREEN);
                    }
                    else {
                        booleanLabel.setText("Nu");
                        booleanLabel.setForeground(Color.RED);
                    }
                }
            }
            
        }
    }
}
