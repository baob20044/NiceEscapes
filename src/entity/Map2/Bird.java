package entity.Map2;

import entity.Entity;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Bird extends Entity {
    int rMove;
    public Bird(GamePanel gp,int rMove, int speed){
        super(gp);
        direction = "down";
        this.setSpeed(speed);
        getImage();
        getSolidArea().x = 8;
        getSolidArea().y = 8;
        getSolidArea().width = 32;
        getSolidArea().height = 32;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        this.rMove = rMove;
    }
    public void getImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/up2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/down1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/down2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/wingbird/right2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){
        setActionLockCounter(getActionLockCounter()+1);

        //Hinh Vuong
        if (getActionLockCounter() == rMove) {
            if(direction == "down"){
                direction = "right";
            }else if(direction == "right"){
                direction = "up";
            }else if(direction == "up"){
                direction = "left";
            }else{
                direction = "down";
            }
            setActionLockCounter(0);
        }
    }
}
