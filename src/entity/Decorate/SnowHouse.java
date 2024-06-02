package entity;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class SnowHouse extends Entity {
    public SnowHouse(GamePanel gp){
        super(gp);
        this.direction = "up";
        setSpeed(0);
        getImage();
        getSolidArea().x = 0;
        getSolidArea().y = 0;
        getSolidArea().width = 0;
        getSolidArea().height = 0;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
    }
    public void getImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowHouse/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/snowHouse/up1.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){;
    }
}
