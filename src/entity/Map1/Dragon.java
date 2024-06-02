package entity.Map1;

import entity.Entity;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Dragon extends Entity {
    public Dragon(GamePanel gp, String direction){
        super(gp);
        this.direction = direction;
        setSpeed(0);
        getImage();
        getSolidArea().x = 35;
        getSolidArea().y = gp.getTileSize();
        getSolidArea().width = gp.getTileSize()*2;
        getSolidArea().height = gp.getTileSize()*2;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
    }
    public void getImage(){
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/right1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/right2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/left1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/left2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/dragon/right2.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void setAction(){;
    }
}
