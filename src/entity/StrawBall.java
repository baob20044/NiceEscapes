package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class StrawBall extends Entity {
    private int defaultX;
    private int defaultY;
    private int limitX;
    private int limitY;
    private boolean cheo;
    public StrawBall(GamePanel gp, int defaultX, int limitX, String direction, int speed, boolean cheo){
        super(gp);
        this.direction = direction;
        this.setSpeed(5);
        this.cheo = cheo;
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
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/strawball/up2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){
        if(direction == "left"){
            if(getWorldX() < limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
            }
            if(cheo == true) setWorldY(getWorldY()-1);
        }
        else if(direction == "right"){
            if(getWorldX() > limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
            }
            if(cheo == true) setWorldY(getWorldY()-1);
        }
        else if(direction == "up"){
            if(getWorldY() < limitX*gp.getTileSize()){
                setWorldY(gp.getTileSize()*defaultX);
            }
        }
        else if(direction == "down"){
            if(getWorldY() > limitX*gp.getTileSize()){
                setWorldY(gp.getTileSize()*defaultX);
            }
        }
    }
}
