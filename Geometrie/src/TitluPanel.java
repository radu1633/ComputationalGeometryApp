import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class TitluPanel extends JPanel{
    private JPanel name, culoareHome;
    private JLabel nameLabel, nameLabel2;

    public TitluPanel(String nume){
    name = new JPanel();
        name.setLayout(new FlowLayout(FlowLayout.LEADING));
        name.setMaximumSize(new Dimension(700, 60));
        nameLabel = new JLabel("Marin Radu-George");
        nameLabel.setFont(new Font("Segoe UI Light", 1, 14));
        nameLabel.setForeground(new Color(153, 153, 153));
        nameLabel.setHorizontalAlignment(JLabel.LEADING);
        EmptyBorder border = new EmptyBorder(15, 20, 0, 0);
        nameLabel.setBorder(border);
        name.add(nameLabel);
        
        culoareHome = new JPanel();
        culoareHome.setMaximumSize(new Dimension(700, 120));
        culoareHome.setLayout(new FlowLayout(FlowLayout.LEADING));
        culoareHome.setBackground(Color.lightGray);
        nameLabel2 = new JLabel(nume);
        nameLabel2.setFont(new Font("Segoe UI Light", 1, 28));
        nameLabel2.setForeground(new Color(0, 153, 153));
        EmptyBorder border1 = new EmptyBorder(30, 20, 0, 0);
        nameLabel2.setBorder(border1);
        culoareHome.add(nameLabel2);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(name);
        this.add(culoareHome);
    }   
}
