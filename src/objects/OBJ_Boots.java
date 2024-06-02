package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Boots extends SuperObject{
    public OBJ_Boots(){
        setName("Boots");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/boot.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
