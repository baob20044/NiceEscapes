package objects;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Health extends SuperObject{
    public OBJ_Health(){
        setName("Health");
        try{
            setImage(ImageIO.read(getClass().getResourceAsStream("/objects/health.png")));
        }catch(IOException e){
            e.printStackTrace();
        }
        setCollision(true);
    }
}
