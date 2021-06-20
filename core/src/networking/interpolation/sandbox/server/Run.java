package networking.interpolation.sandbox.server;

import networking.interpolation.sandbox.display.FixedDisplayFrame;
import networking.interpolation.sandbox.display.Page;
import networking.interpolation.sandbox.display.Window;
import networking.interpolation.sandbox.server.mainpage.MainPage;

public class Run {

    public static void main(String[] args){
        Window window = new Window(new FixedDisplayFrame("Game", 1000, 600), 60);
        Page mainPage = new MainPage(window);
        window.start(mainPage, false);
    }

}