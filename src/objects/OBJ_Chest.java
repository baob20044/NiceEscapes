package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{
    public OBJ_Chest(){
        setName("Chest");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/chest1.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
