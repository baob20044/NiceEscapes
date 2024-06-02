package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SnowBall extends Entity {
    private int defaultX;
    private int defaultY;
    private int limitX;
    private int limitY;
    public SnowBall(GamePanel gp, int defaultX, int limitX, String direction){
        super(gp);
        this.direction = direction;
        setSpeed(3);
        getImage();
        getSolidArea().x = 0;
        getSolidArea().y = 0;
        getSolidArea().width = gp.getTileSize();
        getSolidArea().height = gp.getTileSize();
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        this.defaultX = defaultX;
        this.limitX = limitX;
        setLocked(120);
    }
    public void getImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowball/ball.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){
        if(direction == "left"){
            if(getWorldX() < limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
                setLocked(120);
            }
        }
        if(direction == "right"){
            if(getWorldX() > limitX*gp.getTileSize()){
                setWorldX(gp.getTileSize()*defaultX);
                setLocked(120);
            }
        }
        if(direction == "up"){
            if(getWorldY() < limitX*gp.getTileSize()){
                setWorldY(gp.getTileSize()*defaultX) ;
                setLocked(120);
            }
        }
        if(direction == "down"){
            if(getWorldY() > limitX*gp.getTileSize()){
                setWorldY(gp.getTileSize()*defaultX) ;
                setLocked(120);
            }
        }
    }
}
