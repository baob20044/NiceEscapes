package entity.Map3;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Cactus extends Entity {
    private int rMove;
    public Cactus(GamePanel gp, int rMove) {
        super(gp);
        direction = "left";
        setSpeed(0);
        getImage();
        getSolidArea().x = 0;
        getSolidArea().y = 10;
        getSolidArea().width = gp.getTileSize();
        getSolidArea().height = gp.getTileSize() - 10;
        setSolidAreaDefaultX(getSolidArea().x);
        setSolidAreaDefaultY(getSolidArea().y);
        this.rMove = rMove;
    }

    public void getImage() {
        try {
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/cactus/left2.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/cactus/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/cactus/left1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/cactus/left1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        setActionLockCounter(getActionLockCounter()+1);
        if (getActionLockCounter() == rMove) {
            if (i <= 25) {
                direction = "left";
                setSpeed(1);
            }
            else if (i > 25 && i <= 50) {
                direction = "left";
                setSpeed(1);
            }
            else if (i > 50 && i <= 75) {
                direction = "right";
                setSpeed(1);
            }
            else if (i > 75 && i <= 100) {
                direction = "right";
                setSpeed(1);
            }
            setActionLockCounter(0);
        }
    }
}
