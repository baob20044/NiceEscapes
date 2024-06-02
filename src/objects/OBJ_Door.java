package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObject{
    public OBJ_Door(){
        setName("Door");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/door1.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
