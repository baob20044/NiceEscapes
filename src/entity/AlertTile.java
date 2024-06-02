package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class AlertTile extends Entity {
    public AlertTile(GamePanel gp){
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
            setUp1(ImageIO.read(getClass().getResourceAsStream("/myTile/61.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){;
    }
}
