package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Key extends SuperObject {
    public OBJ_Key(){
        setName("Key");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/key1.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
