package entity.Map1;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Demon extends Entity {
    private int rMove;
        public Demon(GamePanel gp, int rMove) {
            super(gp);
            direction = "down";
            setSpeed(6);
            getImage();
            getSolidArea().x = 0;
            getSolidArea().y = 0;
            getSolidArea().width = gp.getTileSize();
            getSolidArea().height = gp.getTileSize() - 10;
            setSolidAreaDefaultX(getSolidArea().x);
            setSolidAreaDefaultY(getSolidArea().y);
            this.rMove = rMove;
        }

        public void getImage() {
            try {
                setUp1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/demon/up1.png")));
                setUp2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/demon/up2.png")));
                setDown1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/demon/up1.png")));
                setDown2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/demon/up2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void setAction() {
        setActionLockCounter(getActionLockCounter()+1);
        if (getActionLockCounter() == rMove) {
            if (direction == "up") {
                direction = "down";
            } else {
                direction = "up";
            }
            setActionLockCounter(0);
        }
    }
    }