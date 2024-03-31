import javax.swing.*;

public class HomePanel extends JPanel{
    private JPanel titlu;

    public HomePanel(){
        initComponents();
    }

    public void initComponents(){
        titlu = new TitluPanel("Home");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(titlu);
        
    }
}