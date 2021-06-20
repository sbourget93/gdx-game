package networking.interpolation.sandbox.server.mainpage;

import networking.interpolation.sandbox.display.MenuBarSubPage;
import networking.interpolation.sandbox.display.Page;
import networking.interpolation.sandbox.display.Window;
import networking.interpolation.sandbox.server.gamepage.GamePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainPage extends Page {

    private JButton gameButton;

    public MainPage(Window window){
        super(window, 10, 10, window.getWidth()-20, window.getHeight()-20);
        init();
    }

    private void init(){
        this.setBackground(Color.DARK_GRAY);
        this.add(new MenuBarSubPage(getWindow(), 0, 0, getWidth(), 50, false));
        initButtons();
    }

    private void initButtons(){
        gameButton = new JButton("Run Game");
        gameButton.setBounds(50, 100, this.getWidth()-100, this.getHeight() - 150);
        gameButton.addActionListener(this);
        add(gameButton);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == gameButton){
            getWindow().switchPage(new GamePage(getWindow()));
        }
    }

}
