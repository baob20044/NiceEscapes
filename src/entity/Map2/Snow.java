package entity.Map2;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Snow extends Entity {
    public Snow(GamePanel gp) {
        super(gp);
        direction = "up";
        setSpeed(0);
        getImage();
        getSolidArea().x = 0;
        getSolidArea().y = 0;
        getSolidArea().width = gp.getTileSize();
        getSolidArea().height = gp.getTileSize() - 10;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
    }

    public void getImage() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/angrySnow/up1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map02/angrySnow/up2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
    }
}