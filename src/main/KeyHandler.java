package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    private boolean upPressed, downPressed, leftPressed, rightPressed;


    public int getAcceptCross() {
        return acceptCross;
    }

    public void setAcceptCross(int acceptCross) {
        this.acceptCross = acceptCross;
    }

    private int acceptCross;

    public boolean isUpPressed() {
        return upPressed;
    }

    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    private boolean saved;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Tra ve nut minh giu
        if(gp.getGameState() == gp.getNameState()){
            if(code == KeyEvent.VK_ENTER && gp.getName() != ""){
                gp.setGameState(gp.getTitleState());
                gp.setTypeName(false);
            }
        }
        if(gp.getGameState() == gp.getDeathState() || gp.getGameState() == gp.getPauseState()){
            if(code == KeyEvent.VK_ENTER){
                gp.setGameState(gp.getPlayState());
            }
            if(code == KeyEvent.VK_Q){
                gp.setGameState(gp.getTitleState());
            }
            if(code == KeyEvent.VK_S){
                try {
                    File myObj = new File("savegame.txt");
                    FileWriter myWriter = new FileWriter("savegame.txt");
                    myWriter.write(gp.getCurrentMap() + "");
                    myWriter.close();
                } catch (IOException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }
                saved = true;
            }
            if(code == KeyEvent.VK_R){
                gp.setCurrentMap(9);
                gp.setGameStage(1);
                gp.getPlayer().setWorldX(21*gp.getTileSize());
                gp.getPlayer().setWorldY(24*gp.getTileSize());
                gp.setGameState(gp.getPlayState());
                gp.getPlayer().setHeart(3);
                gp.getPlayer().disableKey();
                gp.getaSetter().resetMap();
                gp.getaSetter().setNPC0();
                gp.getPlayer().setBoatEvent(false);
                gp.getPlayer().changeToPlayer();
            }
        }
        if(((gp.getPlayer().isBoatEvent() == true)||gp.getPlayer().getBeNormal() == true) && gp.getPlayer().isCollisionOn() == false){
                if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                    upPressed = true;
                }
                else if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                    downPressed = true;
                }
                else if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                    leftPressed = true;
                }
                else if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                    rightPressed = true;
                }
        }
        else if (gp.getPlayer().isCollisionOn() == true) {
            upPressed = false;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
        }
        if (gp.getPlayer().isFastOn() == true) {
            if (code == KeyEvent.VK_SPACE) {
                upPressed = false;
                downPressed = false;
                leftPressed = false;
                rightPressed = false;
                gp.getPlayer().setCollisionOn(true);
            }
        }
        if(gp.getPlayer().isBootOn() == true){
            if (code == KeyEvent.VK_SPACE) {
                gp.getPlayer().setCollisionOn(true);
                gp.getKeyH().upPressed = false;
                gp.getKeyH().downPressed = false;
                gp.getKeyH().leftPressed = false;
                gp.getKeyH().rightPressed = false;
            }
        }
        if(gp.isTypeName() == true){
            if(code == KeyEvent.VK_BACK_SPACE){
                if(gp.getName().length() != 0){
                    gp.setName(gp.getName().substring(0,gp.getName().length()-1));
                }
            }
            if(gp.getName().length()<25){
                char codeChar = e.getKeyChar();
                if((code >= 65 && code <= 90)||code == KeyEvent.VK_SPACE ||(codeChar >= '0' && codeChar <='9')){
                    gp.setName(gp.getName()+ codeChar);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
