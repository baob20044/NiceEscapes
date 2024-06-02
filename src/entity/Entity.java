    package entity;

    import main.GamePanel;

    import javax.imageio.ImageIO;
    import javax.swing.text.Utilities;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;

    public class Entity {
        GamePanel gp;
        private int worldX, worldY;

        public int getWorldX() {
            return worldX;
        }

        public void setWorldX(int worldX) {
            this.worldX = worldX;
        }

        public int getWorldY() {
            return worldY;
        }

        public void setWorldY(int worldY) {
            this.worldY = worldY;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        private int speed;
        private BufferedImage up1;
        private BufferedImage up2;
        private BufferedImage down1;
        private BufferedImage down2;
        private BufferedImage left1;
        private BufferedImage left2;
        private BufferedImage right1;

        public BufferedImage getUp1() {
            return up1;
        }

        public void setUp1(BufferedImage up1) {
            this.up1 = up1;
        }

        public BufferedImage getUp2() {
            return up2;
        }

        public void setUp2(BufferedImage up2) {
            this.up2 = up2;
        }

        public BufferedImage getDown1() {
            return down1;
        }

        public void setDown1(BufferedImage down1) {
            this.down1 = down1;
        }

        public BufferedImage getDown2() {
            return down2;
        }

        public void setDown2(BufferedImage down2) {
            this.down2 = down2;
        }

        public BufferedImage getLeft1() {
            return left1;
        }

        public void setLeft1(BufferedImage left1) {
            this.left1 = left1;
        }

        public BufferedImage getLeft2() {
            return left2;
        }

        public void setLeft2(BufferedImage left2) {
            this.left2 = left2;
        }

        public BufferedImage getRight1() {
            return right1;
        }

        public void setRight1(BufferedImage right1) {
            this.right1 = right1;
        }

        public BufferedImage getRight2() {
            return right2;
        }

        public void setRight2(BufferedImage right2) {
            this.right2 = right2;
        }

        private BufferedImage right2;
        public String direction;

        public int getSpriteCounter() {
            return spriteCounter;
        }

        public void setSpriteCounter(int spriteCounter) {
            this.spriteCounter = spriteCounter;
        }

        private int spriteCounter = 0; // Dem va thay doi sprite theo time

        public int getSpriteNum() {
            return spriteNum;
        }

        public void setSpriteNum(int spriteNum) {
            this.spriteNum = spriteNum;
        }

        private int spriteNum = 1; // Thay doi sprite (ban dau la 1)

        public Rectangle getSolidArea() {
            return solidArea;
        }

        public void setSolidArea(Rectangle solidArea) {
            this.solidArea = solidArea;
        }

        private Rectangle solidArea = new Rectangle(0,0,48,48);
        private int solidAreaDefaultX, solidAreaDefaultY;

        public int getSolidAreaDefaultX() {
            return solidAreaDefaultX;
        }

        public void setSolidAreaDefaultX(int solidAreaDefaultX) {
            this.solidAreaDefaultX = solidAreaDefaultX;
        }

        public int getSolidAreaDefaultY() {
            return solidAreaDefaultY;
        }

        public void setSolidAreaDefaultY(int solidAreaDefaultY) {
            this.solidAreaDefaultY = solidAreaDefaultY;
        }

        public boolean isCollisionOn() {
            return collisionOn;
        }

        public void setCollisionOn(boolean collisionOn) {
            this.collisionOn = collisionOn;
        }

        public boolean isSlowOn() {
            return slowOn;
        }

        public void setSlowOn(boolean slowOn) {
            this.slowOn = slowOn;
        }

        public boolean isFastOn() {
            return fastOn;
        }

        public void setFastOn(boolean fastOn) {
            this.fastOn = fastOn;
        }

        public boolean isLooseHeartOn() {
            return looseHeartOn;
        }

        public void setLooseHeartOn(boolean looseHeartOn) {
            this.looseHeartOn = looseHeartOn;
        }

        public boolean isBootOn() {
            return bootOn;
        }

        public void setBootOn(boolean bootOn) {
            this.bootOn = bootOn;
        }

        private boolean collisionOn = false;
        private boolean slowOn = false;
        private boolean fastOn = false;
        private boolean looseHeartOn = false;
        private boolean bootOn = false;
        private int actionLockCounter = 0;
        private int locked = 0;

        public int getActionLockCounter() {
            return actionLockCounter;
        }

        public void setActionLockCounter(int actionLockCounter) {
            this.actionLockCounter = actionLockCounter;
        }

        public int getLocked() {
            return locked;
        }

        public void setLocked(int locked) {
            this.locked = locked;
        }

        public Entity(GamePanel gp){
            this.gp = gp;
        }

        public void setAction(){
        }

        public void update(boolean checkTile, boolean checkObject){
            locked--;
            setAction();
            collisionOn = false;
            if(checkTile == true){
                gp.getcChecker().checkTile(this);
            }
            if(checkObject == true){
                gp.getcChecker().checkObject(this,false);
            }
            gp.getcChecker().checkPlayer(this);

            if(collisionOn == false && locked <=0){
                switch (direction){
                    case "up" :worldY-=speed;  break;
                    case "down":worldY+=speed; break;
                    case "left": worldX-=speed; break;
                    case "right":worldX+=speed; break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        public void draw(Graphics2D g2, int Multi){
            BufferedImage image = null;
            int screenX = worldX - gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX();
            int screenY = worldY - gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY();
            if(     worldX + gp.getTileSize() > gp.getPlayer().getWorldX()  - gp.getPlayer().getScreenX() &&
                    worldX - gp.getTileSize() < gp.getPlayer().getWorldX()  + gp.getPlayer().getScreenX() &&
                    worldY + gp.getTileSize() > gp.getPlayer().getWorldY()  - gp.getPlayer().getScreenY() &&
                    worldY- gp.getTileSize() < gp.getPlayer().getWorldY()  + gp.getPlayer().getScreenY()
            ){
                switch (direction){
                    case "up":
                        if(spriteNum == 1){
                            image = up1;
                        }else if(spriteNum == 2){
                            image = up2;
                        }
                        break;
                    case "down":
                        if(spriteNum == 1){
                            image = down1;
                        }else if(spriteNum == 2){
                            image = down2;
                        }
                        break;
                    case "left":
                        if(spriteNum == 1){
                            image = left1;
                        }else if(spriteNum == 2){
                            image = left2;
                        }
                        break;
                    case "right":
                        if(spriteNum == 1){
                            image = right1;
                        }else if(spriteNum == 2){
                            image = right2;
                        }
                        break;
                }
                g2.drawImage(image,screenX,screenY,gp.getTileSize()*Multi, gp.getTileSize()*Multi,null);
            }
        }public void drawPoison(Graphics2D g2, int Multi){
            BufferedImage image = null;
            int screenX = worldX - gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX();
            int screenY = worldY - gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY();
            if(     worldX + gp.getTileSize() > gp.getPlayer().getWorldX() - gp.getPlayer().getScreenX() &&
                    worldX - gp.getTileSize() < gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX() &&
                    worldY + gp.getTileSize() > gp.getPlayer().getWorldY() - gp.getPlayer().getScreenY() &&
                    worldY- gp.getTileSize() < gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY()
            ){
                switch (direction){
                    case "up":
                        if(spriteNum == 1){
                            image = up1;
                        }else if(spriteNum == 2){
                            image = up2;
                        }
                        break;
                    case "down":
                        if(spriteNum == 1){
                            image = down1;
                        }else if(spriteNum == 2){
                            image = down2;
                        }
                        break;
                    case "left":
                        if(spriteNum == 1){
                            image = left1;
                        }else if(spriteNum == 2){
                            image = left2;
                        }
                        break;
                    case "right":
                        if(spriteNum == 1){
                            image = right1;
                        }else if(spriteNum == 2){
                            image = right2;
                        }
                        break;
                }
                g2.drawImage(image,screenX,screenY,gp.getTileSize()*Multi-28, gp.getTileSize()*Multi-28,null);
            }
        }
    }
