package networking.interpolation.sandbox.display;

import javax.swing.*;
import java.awt.*;

public class FixedDisplayFrame extends JFrame{

    private static final long serialVersionUID = -3604441771474123108L;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Container c;

    public FixedDisplayFrame(String title, int width, int height){
        super(title);
        this.setBounds((int)(d.getWidth()-width)/2, (int)(d.getHeight()-height)/2, width, height);
        c=this.getContentPane();
    }

    public void addPanel(JPanel p){
        c.add(p);
    }

    public void removePanel(JPanel p){
        c.remove(p);
    }

    public void showFrame(boolean undecorated){
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(undecorated);
        this.setVisible(true);
    }

}