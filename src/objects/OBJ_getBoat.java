package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_getBoat extends SuperObject{
    public OBJ_getBoat(){
        setName("Boat");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/blank.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
