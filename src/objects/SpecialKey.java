package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SpecialKey extends SuperObject {
    public SpecialKey(){
        setName("SKey");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/key1.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
