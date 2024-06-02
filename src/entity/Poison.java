package entity;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Poison extends Entity {
    private int defaultX;
    private int defaultY;
    private int limitX;
    private int limitY;
    public Poison(GamePanel gp,int defaultX, int limitX,String direction){
        super(gp);
        this.direction = direction;
        setSpeed(2);
        getImage();
        getSolidArea().x = 0;
        getSolidArea().y = 0;
        getSolidArea().width = gp.getTileSize();
        getSolidArea().height = gp.getTileSize();
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        this.defaultX = defaultX;
        this.limitX = limitX;
        setLocked(30);
    }
    public void getImage(){
        try {
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/poison/left.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/poison/left.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/poison/right.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/poison/right.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){
        if(direction == "left"){
            if(getWorldX() < limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
                setLocked(30);
            }
        }else{
            if(getWorldX() > limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
                setLocked(30);
            }
        }
    }
}
