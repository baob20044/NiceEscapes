package entity.Map1;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Monster1 extends Entity {
    private int rMove;
    public Monster1(GamePanel gp, int rMove) {
        super(gp);
        direction = "right";
        setSpeed(16);
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
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/monster1/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/monster1/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/monster1/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map01/monster1/right2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        setActionLockCounter(getActionLockCounter()+1);
        if (getActionLockCounter() == rMove) {
            if (direction == "left") {
                direction = "right";
            } else {
                direction = "left";
            }
            setActionLockCounter(0);
        }
    }
}
