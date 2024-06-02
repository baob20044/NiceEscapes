package entity;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Fire extends Entity {
    private int defaultX;
    private int defaultY;
    private int limitX;
    private int limitY;
    public Fire(GamePanel gp,int defaultX, int limitX,String direction){
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
    }
    public void getImage(){
        try {
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/fire/fire1l.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/fire/fire2l.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/fire/fire1r.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/fire/fire2r.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){
        if(direction == "left"){
            if(getWorldX() < limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
            }
        }else{
            if(getWorldX() > limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
            }
        }
    }
}
