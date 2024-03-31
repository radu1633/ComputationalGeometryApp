import javax.swing.*;
import java.awt.*;

public class TitluriStangaPanel extends JPanel{
    private JPanel gap;
    private JLabel numeLabel;

    public TitluriStangaPanel(String nume){

        numeLabel = new JLabel(nume);
        numeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        numeLabel.setFont(new Font("Segoe UI Light", 0, 16));
        numeLabel.setForeground(new Color(0, 153, 153));

        gap = new JPanel();
        gap.setMaximumSize(new Dimension(5, 40));

        this.setMaximumSize(new Dimension(300, 40));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(gap);
        this.add(Box.createHorizontalStrut(20));
        this.add(numeLabel);
        this.setBackground(new Color(30, 30, 30));
    }
}
