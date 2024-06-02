package objects;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Helicopter extends SuperObject{
    public OBJ_Helicopter(){
        setName("Helicopter");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/helicopter.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
    public void draw(Graphics2D g2, GamePanel gp){
        int screenX = getWorldX() - gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX();
        int screenY = getWorldY() - gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY();
        if(     getWorldX() + gp.getTileSize() > gp.getPlayer().getWorldX() - gp.getPlayer().getScreenX() &&
                getWorldX() - gp.getTileSize() < gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX() &&
                getWorldY() + gp.getTileSize() > gp.getPlayer().getWorldY() - gp.getPlayer().getScreenY() &&
                getWorldY()- gp.getTileSize() < gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY()
        ){
            g2.drawImage(getImage() ,screenX,screenY,gp.getTileSize()*3, gp.getTileSize()*3,null);
        }
    }
}
