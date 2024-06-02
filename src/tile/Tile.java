package tile;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Tile {
    private BufferedImage image;
    private boolean collision = false;
    private boolean slowBlock = false;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean isSlowBlock() {
        return slowBlock;
    }

    public void setSlowBlock(boolean slowBlock) {
        this.slowBlock = slowBlock;
    }

    public boolean isFastBlock() {
        return fastBlock;
    }

    public void setFastBlock(boolean fastBlock) {
        this.fastBlock = fastBlock;
    }

    public boolean isLooseHeartBlock() {
        return looseHeartBlock;
    }

    public void setLooseHeartBlock(boolean looseHeartBlock) {
        this.looseHeartBlock = looseHeartBlock;
    }

    private boolean fastBlock = false;
    private boolean looseHeartBlock = false;

}
