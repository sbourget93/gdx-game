package networking.interpolation.sandbox.display;

import networking.interpolation.sandbox.util.tickspersecond.Limiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JPanel implements KeyListener{

    private Limiter limiter;
    private static final long serialVersionUID = 5836908977890445638L;
    private FixedDisplayFrame fixedDisplayFrame;
    private Page page;

    //Constructor
    public Window(FixedDisplayFrame fdf, int ticksPerSecond){
        fixedDisplayFrame = fdf;
        fixedDisplayFrame.setLayout(null);//Necessary to control the panels the way I want to.
        setBounds(0, 0, fdf.getWidth(), fdf.getHeight());//The size of the window
        limiter = new Limiter(ticksPerSecond);
    }

    public void start(Page startPage, boolean undecorated){
        this.setFocusable(true);
        this.addKeyListener(this);
        page = startPage;
        setLayout(null);//Necessary to place all of the components where I want to.
        setBackground(Color.BLUE);
        add(page);
        fixedDisplayFrame.addPanel(this);//Adds the engine panel to the window (JFrame).
        fixedDisplayFrame.showFrame(undecorated);//The game is now visible.

        while(!Thread.currentThread().isInterrupted()){
            limiter.waitTick();
            page.tick();
            repaint();
        }

    }

    public void switchPage(Page p){
        remove(page);
        page = p;
        add(page);
        revalidate();
        repaint();
    }

    public void minimize(){
        fixedDisplayFrame.setState(Frame.ICONIFIED);
    }

    public void keyTyped(KeyEvent e){
        page.keyTyped(e);
    }

    public void keyPressed(KeyEvent e){
        page.keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        page.keyReleased(e);
    }

}