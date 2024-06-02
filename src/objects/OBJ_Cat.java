package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Cat extends SuperObject {
    public OBJ_Cat(){
        setName("Cat");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/cat.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
