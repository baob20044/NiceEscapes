package entity.Decorate;

import entity.Entity;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC_RedHair extends Entity {
    public NPC_RedHair(GamePanel gp){
        super(gp);
        direction = "up";
        setSpeed(0);
        getImage();
    }
    public void getImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/redhairboy/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/redhairboy/up2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction() {
    }
}
