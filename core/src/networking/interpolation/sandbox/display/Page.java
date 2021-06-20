package networking.interpolation.sandbox.display;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public abstract class Page extends JPanel implements ActionListener, MouseListener, MouseMotionListener, ChangeListener {

    private static final long serialVersionUID = -4544569637784519217L;

    private Window window;

    public Page(Window window, int x, int y, int width, int height){
        this.window = window;
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public Window getWindow(){
        return window;
    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    public void tick(){

    }

    public void actionPerformed(ActionEvent e){

    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mouseDragged(MouseEvent e){

    }

    public void mouseMoved(MouseEvent e){

    }

    public void stateChanged(ChangeEvent e) {

    }

    public void refreshState(){

    }

}