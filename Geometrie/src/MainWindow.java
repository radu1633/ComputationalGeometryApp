import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class MainWindow extends JFrame implements MouseListener{
    private JPanel panelSecundar, stanga, sortareAndcautareBinara, coliniaritate, localizareInTriunghi, home, localizareInPoligonPanel, metodaPenelor,
                   metodaLespezilor, metodaLanturilor, algoritmulBSM, metodaArboreluiBinar, jarvis, graham;
    private JLabel geometrie, computationala;
    private Container contentPane;

    public MainWindow(){
        initComponents();
    }

    private void initComponents(){
        
        stanga = new JPanel();
        home = new TitluriStangaPanel("Home");
        sortareAndcautareBinara = new TitluriStangaPanel("Sortare & Cautare Binara");
        coliniaritate = new TitluriStangaPanel("Coliniaritate");
        localizareInTriunghi = new TitluriStangaPanel("Localizare punct intr-un triunghi");
        localizareInPoligonPanel = new TitluriStangaPanel("Localizare punct intr-un poligon simplu");
        metodaPenelor = new TitluriStangaPanel("Metoda penelor");
        metodaLespezilor = new TitluriStangaPanel("Metoda lespezilor");
        metodaLanturilor = new TitluriStangaPanel("Metoda lanturilor");
        algoritmulBSM = new TitluriStangaPanel("Algoritmul de limitare");
        metodaArboreluiBinar = new TitluriStangaPanel("Metoda arborelui binar");
        jarvis = new TitluriStangaPanel("Algoritmul Jarvis");
        graham = new TitluriStangaPanel("Algortimul Graham");

        stanga.setPreferredSize(new Dimension(300, 500));
        stanga.setBackground(new Color(30, 30, 30));
        
        geometrie = new JLabel("Geometrie");
        geometrie.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        geometrie.setFont(new Font("Segoe UI Light", 1, 36));
        geometrie.setForeground(new Color(0, 153, 153));
       
        computationala = new JLabel("Computationala");
        computationala.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        computationala.setFont(new Font("Segoe UI Light", 0, 24));
        computationala.setForeground(new Color(0, 153, 153));


        stanga.setLayout(new BoxLayout(stanga, BoxLayout.Y_AXIS));
        stanga.add(Box.createVerticalStrut(70));
        stanga.add(geometrie);
        stanga.add(computationala);
        stanga.add(Box.createVerticalStrut(50));
        stanga.add(home);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(sortareAndcautareBinara);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(coliniaritate);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(localizareInTriunghi);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(localizareInPoligonPanel);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(metodaPenelor);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(metodaLespezilor);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(metodaLanturilor);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(algoritmulBSM);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(metodaArboreluiBinar);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(jarvis);
        stanga.add(Box.createVerticalStrut(10));
        stanga.add(graham);
        stanga.add(Box.createVerticalStrut(100));


        panelSecundar = new HomePanel();
        panelSecundar.setPreferredSize(new Dimension(700,500));
        panelSecundar.setBackground(Color.white);
        
    
        this.add(stanga, BorderLayout.WEST);
        this.add(panelSecundar);

        sortareAndcautareBinara.addMouseListener(this);
        coliniaritate.addMouseListener(this);
        home.addMouseListener(this);
        localizareInTriunghi.addMouseListener(this);
        localizareInPoligonPanel.addMouseListener(this);
        metodaPenelor.addMouseListener(this);
        metodaLespezilor.addMouseListener(this);
        metodaLanturilor.addMouseListener(this);
        algoritmulBSM.addMouseListener(this);
        metodaArboreluiBinar.addMouseListener(this);
        jarvis.addMouseListener(this);
        graham.addMouseListener(this);
        
        contentPane = getContentPane();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == sortareAndcautareBinara){
            if(this.getContentPane() != null ) this.getContentPane().remove(panelSecundar);
            panelSecundar = new SortareCautarePanel();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        
        if(e.getSource() == home) {
            if(this.getContentPane() != null ) this.getContentPane().remove(panelSecundar);
            panelSecundar = new HomePanel();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }

        if(e.getSource() == coliniaritate){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new ColiniaritatePanel();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }

        if(e.getSource() == localizareInTriunghi){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new Triunghi();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == localizareInPoligonPanel){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new Poligon();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == metodaPenelor){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new MetodaPenelor();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == metodaLespezilor){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new MetodaLespezilor();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == metodaLanturilor){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new MetodaLanturilor();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == algoritmulBSM){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new BSM();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == metodaArboreluiBinar){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new MetodaArboreluiBinar();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == jarvis){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new Jarvis();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
        if(e.getSource() == graham){
            if(this.getContentPane() != null) this.getContentPane().remove(panelSecundar);
            panelSecundar = new Graham();
            contentPane.add(panelSecundar);
            contentPane.validate();
            setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == sortareAndcautareBinara) sortareAndcautareBinara.setBackground(new Color(102, 102, 102));
        if(e.getSource() == coliniaritate) coliniaritate.setBackground(new Color(102, 102, 102));
        if(e.getSource() == home) home.setBackground(new Color(102, 102, 102));
        if(e.getSource() == localizareInTriunghi) localizareInTriunghi.setBackground(new Color(102, 102, 102));
        if(e.getSource() == localizareInPoligonPanel) localizareInPoligonPanel.setBackground(new Color(102, 102, 102));
        if(e.getSource() == metodaPenelor) metodaPenelor.setBackground(new Color(102, 102, 102));
        if(e.getSource() == metodaLespezilor) metodaLespezilor.setBackground(new Color(102, 102, 102));
        if(e.getSource() == metodaLanturilor) metodaLanturilor.setBackground(new Color(102, 102, 102));
        if(e.getSource() == algoritmulBSM) algoritmulBSM.setBackground(new Color(102, 102, 102));
        if(e.getSource() == metodaArboreluiBinar) metodaArboreluiBinar.setBackground(new Color(102, 102, 102));
        if(e.getSource() == jarvis) jarvis.setBackground(new Color(102, 102, 102));
        if(e.getSource() == graham) graham.setBackground(new Color(102, 102, 102));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == sortareAndcautareBinara) sortareAndcautareBinara.setBackground(new Color(30, 30, 30));
        if(e.getSource() == coliniaritate) coliniaritate.setBackground(new Color(30, 30, 30));
        if(e.getSource() == home) home.setBackground(new Color(30, 30, 30));
        if(e.getSource() == localizareInTriunghi) localizareInTriunghi.setBackground(new Color(30, 30, 30));
        if(e.getSource() == localizareInPoligonPanel) localizareInPoligonPanel.setBackground(new Color(30, 30, 30));
        if(e.getSource() == metodaPenelor) metodaPenelor.setBackground(new Color(30, 30, 30));
        if(e.getSource() == metodaLespezilor) metodaLespezilor.setBackground(new Color(30, 30, 30));
        if(e.getSource() == metodaLanturilor) metodaLanturilor.setBackground(new Color(30, 30, 30));
        if(e.getSource() == algoritmulBSM) algoritmulBSM.setBackground(new Color(30, 30, 30));
        if(e.getSource() == metodaArboreluiBinar) metodaArboreluiBinar.setBackground(new Color(30, 30, 30));
        if(e.getSource() == jarvis) jarvis.setBackground(new Color(30, 30, 30));
        if(e.getSource() == graham) graham.setBackground(new Color(30, 30, 30));
    }

    public void createChangePanel(JPanel panel){
        contentPane.removeAll();
        contentPane.add(panel, BorderLayout.CENTER);
        validate();
        setVisible(true);
    }

    

}