package entity.Map3;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Scorpia extends Entity {
    private int rMove;
    public Scorpia(GamePanel gp, int rMove) {
        super(gp);
        direction = "right";
        setSpeed(0);
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
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/scorpia/left1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/scorpia/left2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/scorpia/right1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/monster/Map03/scorpia/right2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
    }
}
