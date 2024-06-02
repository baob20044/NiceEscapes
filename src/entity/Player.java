package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Key;

public class Player extends Entity{
    KeyHandler keyH;

    public int getHasCat() {
        return hasCat;
    }

    public void setHasCat(int hasCat) {
        this.hasCat = hasCat;
    }

    private int hasCat = 0;
    public int getHasKey() {
        return hasKey;
    }

    public void setHasKey(int hasKey) {
        this.hasKey = hasKey;
    }

    public int getHeart() {
        return Heart;
    }

    public void setHeart(int heart) {
        Heart = heart;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }

    public int getScreenY() {
        return screenY;
    }

    private final int screenX;
    private final int screenY;
    private int hasKey = 0;
    private int Heart = 3;
    private int spawnX;
    private int spawnY;
    private int lockedTile = 0;

    public Boolean getBeNormal() {
        return beNormal;
    }

    private Boolean beNormal = false;

    public boolean isBoatEvent() {
        return boatEvent;
    }

    public void setBoatEvent(boolean boatEvent) {
        this.boatEvent = boatEvent;
    }

    private boolean boatEvent = false;

    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;

        this.screenX = gp.getScreenWidth()/2 - (gp.getTileSize()/2);
        this.screenY = gp.getScreenHeight()/2 - (gp.getTileSize()/2);

        setSolidArea(new Rectangle());
        getSolidArea().x = 16;
        getSolidArea().y = 16;
        getSolidArea().width = 16;
        getSolidArea().height = 28;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        setCollisionOn(true);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        setWorldX(gp.getTileSize() *21);
        setWorldY(gp.getTileSize() *24);
        spawnX = getWorldX();
        spawnY = getWorldY();
        setSpeed(5);
        direction = "down";
    }
    public void getPlayerImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/up2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/down1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/down2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/right2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.isUpPressed() == true || keyH.isDownPressed() == true ||keyH.isLeftPressed() == true || keyH.isRightPressed() == true){
            if(keyH.isUpPressed() == true){
                direction = "up";
            }
            else if(keyH.isDownPressed() == true){
                direction = "down";
            }
            else if(keyH.isLeftPressed() == true){
                direction = "left";
            }
            else if(keyH.isRightPressed() == true){
                direction = "right";
            }
            //CHECK TILE COLLISION
            setCollisionOn(false);
            gp.getcChecker().checkTile(this);
            //

            int objIndex = gp.getcChecker().checkObject(this,true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.getcChecker().checkEntity(this,gp.getNpc());
            interactNPC(npcIndex);
            //IF COLLISION IS FALSE , PLAYER CAN MOVE
            if((gp.getPlayer().isBoatEvent() == true) && isCollisionOn() == false){
                switch (direction){
                    case "up" :setWorldY(getWorldY()-getSpeed()*3); support();                     if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                    case "down":setWorldY(getWorldY()+getSpeed()*3); support();                    if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                    case "left": setWorldX(getWorldX()-getSpeed()*3);support();                     if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                    case "right":setWorldX(getWorldX()+getSpeed()*3); support();                    if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                }
            }else if((gp.getPlayer().getBeNormal() == true)){
                switch (direction){
                    case "up" :setWorldY(getWorldY()-getSpeed()); support();                     if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                    case "down":setWorldY(getWorldY()+getSpeed()); support();                    if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                    case "left": setWorldX(getWorldX()-getSpeed());support();                     if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                    case "right":setWorldX(getWorldX()+getSpeed()); support();                    if (getSpriteNum()==1) setSpriteNum(2);
                    else setSpriteNum(1);break;
                }
            }
            else if(isCollisionOn() == false){
                switch (direction){
                    case "up" :setWorldY(getWorldY()-getSpeed());break;
                    case "down":setWorldY(getWorldY()+getSpeed());break;
                    case "left": setWorldX(getWorldX()-getSpeed());break;
                    case "right":setWorldX(getWorldX()+getSpeed()); break;
                }
            }
            if(isSlowOn() == true){
                setSpeed(3);
            }else if(isFastOn() == true) {
                setSpeed(6);
            }
            else{
                setSpeed(5);
            }
            if(isLooseHeartOn() == true){
                lockedTile++;
                if(lockedTile == 7){
                    Heart-=3;
                    lockedTile = 0;
                }
            }
            if(Heart <= 0){
                disableKey();
            }
            if(isCollisionOn() == false){
                setSpriteCounter(getSpriteCounter()+1);
            }
            if(getSpriteCounter() > 12){
                if(getSpriteNum() == 1){
                    setSpriteNum(2);
                }else if(getSpriteNum() == 2){
                    setSpriteNum(1);
                }
                setSpriteCounter(0);
            }
        }
        if(gp.getCurrentMap() == 3 && isBoatEvent() == true){
            if(getWorldY() > 7*gp.getTileSize() && getWorldY() < 19*gp.getTileSize()){
                gp.setGameStage(3);
            }else if(getWorldY() > 22*gp.getTileSize() && getWorldY() < 25*gp.getTileSize()){
                gp.setGameStage(4);
            }else if(getWorldY() > 25*gp.getTileSize() && getWorldY() < 30*gp.getTileSize()){
                gp.setGameStage(5);
            }else if(getWorldY() > 36*gp.getTileSize() && getWorldY() < 38*gp.getTileSize()){
                gp.setGameStage(6);
            }else if(getWorldY() > 39*gp.getTileSize() && getWorldY() < 40*gp.getTileSize()){
                gp.setGameStage(7);
            }else if(getWorldY() > 41*gp.getTileSize() && getWorldY() < 48*gp.getTileSize()){
                gp.setGameStage(88);
            }
        }
    }
    public void support(){
        gp.getKeyH().setUpPressed(false);
        gp.getKeyH().setDownPressed(false);
        gp.getKeyH().setLeftPressed(false);
        gp.getKeyH().setRightPressed(false);
        gp.getPlayer().setCollisionOn(true);
    }
    public void saveAchieve(){
        try {
            FileWriter  myObj = new FileWriter  ("achievement.txt",true);
            BufferedWriter myWriter = new BufferedWriter (myObj);
            myWriter.write("" + gp.getName() + ": " + gp.getAchiveTime()/60 + "\n");
            myWriter.close();
        } catch (IOException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }
    }
    public void disableKey(){
        if(gp.getCurrentMap() == 2 && gp.getGameStage() == 2) {
            gp.getaSetter().seteTime(0);
            gp.getaSetter().setcTime(0);
            gp.getaSetter().resetMap();
            gp.getaSetter().setNPC3();
            if(gp.getPlayer().Heart<1){
                gp.setGameStage(1);
            }
        }
        if(gp.getPlayer().Heart<1){
            gp.setGameState(1);
            gp.getPlayer().Heart = 3;
            if(gp.getCurrentMap() == 0 || gp.getCurrentMap() == 2){
                gp.getPlayer().spawnX = gp.getTileSize() *1;
                gp.getPlayer().spawnY = gp.getTileSize() *1;
            }else if(gp.getCurrentMap() == 1){
                gp.getPlayer().spawnX = gp.getTileSize() *5;
                gp.getPlayer().spawnY = gp.getTileSize() *15;
            }
            setWorldX(getSpawnX());
            setWorldY(getSpawnY());
            gp.setGameState(gp.getDeathState());
        }
        gp.getKeyH().setUpPressed(false);
        gp.getKeyH().setDownPressed(false);
        gp.getKeyH().setLeftPressed(false);
        gp.getKeyH().setRightPressed(false);
        gp.getPlayer().setCollisionOn(true);
        if(gp.getCurrentMap() == 0){
            gp.getaSetter().setNPC();
        }else if(gp.getCurrentMap() == 1){
            gp.getaSetter().setNPC2();
        }else if(gp.getCurrentMap() == 2){
            gp.getaSetter().setNPC3();
        }else if(gp.getCurrentMap() == 9){
            gp.getaSetter().setNPC0();
        }else if(gp.getCurrentMap() == 3){
            gp.getaSetter().setNPC4();
        }
        hasKey = 0;
    }
    public int bonusSpeed = 0;
    public void pickUpObject(int i) {
        if(i!= 999){
            String objectName = gp.getObj()[i].getName();
            switch (objectName) {
                case "Key":
                    hasKey++;
                    gp.getObj()[i] = null;
                    break;
                case "Door":
                    if (hasKey > 0) {
                        gp.getObj()[i] = null;
                        hasKey--;
                        gp.getObj()[i] = null;
                    }
                    break;
                case "Chest":
                {
                    disableKey();
                    handleChest();
                    break;
                }
                case "Health":
                    Heart = 3;
                    gp.getObj()[i] = null;
                    break;
                case "SKey": {
                    handleSKey(i);
                    break;
                }
                case "Boots":
                    gp.getObj()[i] = null;
                    setBootOn(true);
                    break;
                case "Boat":
                    handleBoat(i);
                    break;
                case "Cat":
                    gp.getObj()[i] = null;
                    hasCat++;
                    beNormal = true;
                    break;
                case "Helicopter":
                    if(hasCat > 0){
                        gp.getObj()[i] = null;
                        saveAchieve();
                        gp.setGameState(gp.getEndState());
                    }
                    break;
            }
        }
    }
    public void handleBoat(int i) {
        if(gp.getGameStage() == 2){
            setBoatEvent(true);
            setWorldX(39*gp.getTileSize());
            setWorldY(12*gp.getTileSize());
            changeToBoat();
            gp.setGameStage(3);
            return;
        }else if(gp.getGameStage() == 3){
            setBoatEvent(false);
            setWorldX(39*gp.getTileSize());
            setWorldY(10*gp.getTileSize());
            changeToPlayer();
            gp.setGameStage(2);
            return;
        }else if(gp.getGameStage() == 4){
            setBoatEvent(false);
            setWorldX(13*gp.getTileSize());
            setWorldY(23*gp.getTileSize());
            gp.setGameStage(8);
            changeToPlayer();
            return;
        }else if(gp.getGameStage() == 8){
            setBoatEvent(true);
            setWorldX(15*gp.getTileSize());
            setWorldY(23*gp.getTileSize());
            changeToBoat();
            gp.setGameStage(4);
            return;
        }else if(gp.getGameStage() == 5){
            setBoatEvent(false);
            setWorldX(39*gp.getTileSize());
            setWorldY(25*gp.getTileSize());
            gp.setGameStage(9);
            changeToPlayer();
            return;
        }else if(gp.getGameStage() == 9){
            setBoatEvent(true);
            setWorldX(39*gp.getTileSize());
            setWorldY(27*gp.getTileSize());
            changeToBoat();
            gp.setGameStage(5);
            return;
        }else if(gp.getGameStage() == 6){
            setBoatEvent(false);
            setWorldX(9*gp.getTileSize());
            setWorldY(37*gp.getTileSize());
            gp.setGameStage(10);
            changeToPlayer();
            return;
        }else if(gp.getGameStage() == 10){
            setBoatEvent(true);
            setWorldX(7*gp.getTileSize());
            setWorldY(37*gp.getTileSize());
            changeToBoat();
            gp.setGameStage(6);
            return;
        }else if(gp.getGameStage() == 7){
            setBoatEvent(false);
            setWorldX(31*gp.getTileSize());
            setWorldY(40*gp.getTileSize());
            gp.setGameStage(11);
            changeToPlayer();
            return;
        }else if(gp.getGameStage() == 11){
            setBoatEvent(true);
            setWorldX(29*gp.getTileSize());
            setWorldY(40*gp.getTileSize());
            changeToBoat();
            gp.setGameStage(6);
            return;
        }

    }
    public void changeToBoat() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/player/boat/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/player/boat/up2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/player/boat/down1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/player/boat/down2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/boat/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/boat/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/player/boat/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/player/boat/right2.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changeToPlayer()  {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/up2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/down1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/down2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/player/playerFantastic/right2.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void handleSKey(int i){
        if(hasKey == 0){
            gp.getObj()[i].setWorldX(25*gp.getTileSize());
            gp.getObj()[i].setWorldY(24*gp.getTileSize());
        }
        if(hasKey == 1){
            gp.getObj()[i].setWorldX(42*gp.getTileSize());
            gp.getObj()[i].setWorldY(27*gp.getTileSize());
        }
        if(hasKey == 2){
            gp.getObj()[i].setWorldX(44*gp.getTileSize());
            gp.getObj()[i].setWorldY(24*gp.getTileSize());
        }
        if(hasKey == 3){
            gp.getObj()[i].setWorldX(24*gp.getTileSize());
            gp.getObj()[i].setWorldY(28*gp.getTileSize());
        }
        if(hasKey == 4){
            gp.getObj()[i].setWorldX(36*gp.getTileSize());
            gp.getObj()[i].setWorldY(25*gp.getTileSize());
        }
        if(hasKey == 5){
            gp.getObj()[i].setWorldX(27*gp.getTileSize());
            gp.getObj()[i].setWorldY(23*gp.getTileSize());
        }
        if(hasKey == 6){
            gp.getObj()[i].setWorldX(41*gp.getTileSize());
            gp.getObj()[i].setWorldY(27*gp.getTileSize());
        }
        if(hasKey == 7){
            gp.getObj()[i].setWorldX(41*gp.getTileSize());
            gp.getObj()[i].setWorldY(24*gp.getTileSize());
        }
        if(hasKey == 8){
            gp.getObj()[i].setWorldX(26*gp.getTileSize());
            gp.getObj()[i].setWorldY(26*gp.getTileSize());
        }
        if(hasKey == 9){
            gp.getObj()[i].setWorldX(36*gp.getTileSize());
            gp.getObj()[i].setWorldY(28*gp.getTileSize());
            gp.getObj()[i] = null;
        }
        hasKey++;
    }
    public void handleChest(){
        if(gp.getCurrentMap() == 9){
            gp.setGameStage(1);
            gp.setCurrentMap(0);
            setWorldX(gp.getTileSize()*1);
            setWorldY(gp.getTileSize()*1);
            spawnX = getWorldX();
            spawnY = getSpawnY();
            gp.getaSetter().setNPC();
            return;
        }
        if(gp.getCurrentMap() == 0){
            if(gp.getGameStage() == 1){
                setWorldX(gp.getTileSize()*14);
                setWorldY(gp.getTileSize()*1);
                gp.setGameStage(2);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if(gp.getGameStage() == 2){
                setWorldX(gp.getTileSize()*31);
                setWorldY(gp.getTileSize()*8);
                gp.setGameStage(3);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if(gp.getGameStage() == 3){
                setWorldX(gp.getTileSize()*28) ;
                setWorldY(gp.getTileSize()*10);
                gp.setGameStage(4);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if(gp.getGameStage() == 4){
                setWorldX(gp.getTileSize()*25);
                setWorldY(gp.getTileSize()*48);
                gp.setGameStage(5);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if(gp.getGameStage() == 5){
                setWorldX(gp.getTileSize()*5);
                setWorldY(gp.getTileSize()*15);
                spawnX = getWorldX();
                spawnY = getWorldY();
                gp.setCurrentMap(1);
                gp.setGameStage(1);
                gp.getaSetter().resetMap();
                gp.getaSetter().setNPC2();
                return;
            }
        }
        if(gp.getCurrentMap() == 1) {
            if (gp.getGameStage() == 1) {
                setWorldX(gp.getTileSize() * 18);
                setWorldY(gp.getTileSize() * 20);
                gp.setGameStage(2);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if (gp.getGameStage() == 2) {
                setWorldX(gp.getTileSize() * 20);
                setWorldY(gp.getTileSize() * 20);
                gp.setGameStage(3);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if (gp.getGameStage() == 3) {
                setWorldX(gp.getTileSize() * 45);
                setWorldY(gp.getTileSize() * 33);
                gp.setGameStage(4);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if (gp.getGameStage() == 4) {
                setWorldX(gp.getTileSize() * 1);
                setWorldY(gp.getTileSize() * 1);
                gp.setGameStage(1);
                spawnX = getWorldX();
                spawnY = getWorldY();
                gp.setCurrentMap(2);
                gp.getaSetter().resetMap();
                gp.getaSetter().setNPC3();
                return;
            }
        }
        if(gp.getCurrentMap() == 2) {
            if (gp.getGameStage() == 1) {
                setWorldX(gp.getTileSize() * 25);
                setWorldY(gp.getTileSize() * 36);
                gp.setGameStage(2);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
            if (gp.getGameStage() == 2) {
                setWorldX(gp.getTileSize() * 1);
                setWorldY(gp.getTileSize() * 1);
                gp.setGameStage(1);
                gp.setCurrentMap(3);
                spawnX = getWorldX();
                spawnY = getWorldY();
                return;
            }
        }
        if(gp.getCurrentMap() == 3) {
            if(gp.getGameStage() == 1){
                setWorldX(gp.getTileSize() * 25);
                setWorldY(gp.getTileSize() * 3);
                gp.setGameStage(2);
                spawnX = getWorldX();
                spawnY = getWorldY();
            }
        }
    }
    public void interactNPC(int i){
        if(i!=999){
            Heart--;
            gp.getPlayer().disableKey();
            gp.getPlayer().setWorldX(spawnX);
            gp.getPlayer().setWorldY(spawnY);
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(getSpriteNum() == 1){
                    image = getUp1();
                }else if(getSpriteNum() == 2){
                    image = getUp2();
                }
                break;
            case "down":
                if(getSpriteNum() == 1){
                    image = getDown1();
                }else if(getSpriteNum() == 2){
                    image = getDown2();
                }
                break;
            case "left":
                if(getSpriteNum() == 1){
                    image = getLeft1();
                }else if(getSpriteNum() == 2){
                    image = getLeft2();
                }
                break;
            case "right":
                if(getSpriteNum() == 1){
                    image = getRight1();
                }else if(getSpriteNum() == 2){
                    image = getRight2();
                }
                break;
        }
        g2.drawImage(image,screenX,screenY,gp.getTileSize(), gp.getTileSize(),null);
       }
}
