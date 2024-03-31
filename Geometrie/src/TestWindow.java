import javax.swing.JFrame;

public class TestWindow {
    public static void main(String[] args) throws Exception {
        JFrame mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setSize(1000, 800);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
    

    }
}