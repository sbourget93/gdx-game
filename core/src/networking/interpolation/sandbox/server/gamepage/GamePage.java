package networking.interpolation.sandbox.server.gamepage;

import networking.interpolation.sandbox.display.MenuBarSubPage;
import networking.interpolation.sandbox.display.Page;
import networking.interpolation.sandbox.display.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class GamePage extends Page {

    public int areaLeft;
    public int areaRight;
    public int areaTop;
    public int areaBottom;
    public int width;
    public int height;

    public int playerX;
    public int playerY;
    public int playerSize;
    public int playerXSpeed;
    public int playerYSpeed;

    public GamePage(Window window){
        super(window, 10, 10, window.getWidth()-20, window.getHeight()-20);
        init();
    }

    private void init(){
        areaLeft = 25;
        areaRight = getWidth() - 25;
        areaTop = 50 + 25;
        areaBottom = getHeight() - 25;
        width = areaRight - areaLeft;
        height = areaBottom - areaTop;

        playerX = areaLeft;
        playerY = areaTop;
        playerSize = 25;
        playerXSpeed = 5;
        playerYSpeed = 5;

        this.setBackground(Color.DARK_GRAY);
        this.add(new MenuBarSubPage(getWindow(), 0, 0, getWidth(), 50, true));
    }

    public void tick(){
        playerX += playerXSpeed;
        playerY += playerYSpeed;

        if(playerX+playerSize >= areaRight){
            playerX = areaRight-playerSize;
            playerXSpeed = -(ThreadLocalRandom.current().nextInt(2, 7 + 1));
        }

        if(playerX <= areaLeft){
            playerX = areaLeft;
            playerXSpeed = ThreadLocalRandom.current().nextInt(2, 7 + 1);
        }

        if(playerY+playerSize >= areaBottom){
            playerY = areaBottom-playerSize;
            playerYSpeed = -(ThreadLocalRandom.current().nextInt(2, 7 + 1));
        }

        if(playerY <= areaTop){
            playerY = areaTop;
            playerYSpeed = ThreadLocalRandom.current().nextInt(2, 7 + 1);
        }
    }

    public void paintComponent(Graphics gc){
        super.paintComponent(gc);
        gc.setColor(Color.BLACK);
        gc.drawRect(areaLeft-1, areaTop-1, width+2, height+2);

        gc.setColor(Color.RED);
        gc.fillRect(playerX, playerY, playerSize, playerSize);
    }

}
