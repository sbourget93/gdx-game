package networking.interpolation.sandbox.display;

import networking.interpolation.sandbox.server.mainpage.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuBarSubPage extends Page{

    private JButton menuButton;
    private JButton quitButton;

    public MenuBarSubPage(Window window, int x, int y, int width, int height, boolean includeMenu){
        super(window, x, y, width, height);
        init(includeMenu);
    }

    private void init(boolean includeMenu){
        this.setBackground(Color.LIGHT_GRAY);

        if(includeMenu) {
            menuButton = new JButton("Main Menu");
            menuButton.setBounds(10, 10, 120, getHeight() - 20);
            menuButton.addActionListener(this);
            add(menuButton);
        }

        quitButton = new JButton("Quit");
        quitButton.setBounds(getWidth() - 110, 10, 100, getHeight() - 20);
        quitButton.addActionListener(this);
        add(quitButton);
    }

    public synchronized void actionPerformed(ActionEvent e){
        if(e.getSource() == menuButton){
            getWindow().switchPage(new MainPage(getWindow()));
        }else if(e.getSource() == quitButton) {
            System.exit(0);
        }
    }

}
