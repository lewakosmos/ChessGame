package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        GamePanel gp = new GamePanel();
        setLayout(new BorderLayout());
        setTitle("Chess Game");
        setSize(new Dimension(500, 500));
        add(BorderLayout.CENTER, gp.panelCreator());
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    //constructor for game frame
}
