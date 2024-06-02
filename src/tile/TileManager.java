package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    private Tile[] tile;

    public Tile[] getTile() {
        return tile;
    }

    public void setTile(Tile[] tile) {
        this.tile = tile;
    }

    public int[][][] getMapTileNum() {
        return mapTileNum;
    }

    public void setMapTileNum(int[][][] mapTileNum) {
        this.mapTileNum = mapTileNum;
    }

    private int mapTileNum[][][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.tile = new Tile[200];
        mapTileNum = new int[gp.getMaxMap()][gp.getMaxWorldCol()][gp.getMaxWorldRow()];

        getTileManager();
        loadMap("/maps/Map0r.tmx",9);
        loadMap("/maps/M010r.tmx",0);
        loadMap("/maps/M2_011r.tmx",1);
        loadMap("/maps/M3_002r.tmx",2);
        loadMap("/maps/M4_005.tmx",3);
    }
    public void getTileManager(){
        try {
            for(int i =11;i<115;i++){
                tile[i] = new Tile();
                tile[i].setImage(ImageIO.read(getClass().getResourceAsStream("/myTile/"+(i-1)+".png")));
            }
            tile[19].setImage(tile[25].getImage());
            tile[24].setImage(tile[26].getImage());
        }catch(IOException e){
            e.printStackTrace();
        }
        tile[28].setSlowBlock(true);
        tile[34].setFastBlock(true);
        tile[58].setLooseHeartBlock(true);

        tile[24].setCollision(true);
        tile[29].setCollision(true);
        tile[33].setCollision(true);
        tile[36].setCollision(true);
        tile[37].setCollision(true);
        tile[38].setCollision(true);
        tile[39].setCollision(true);

        tile[49].setCollision(true);
        tile[50].setCollision(true);
        tile[51].setCollision(true);
        tile[52].setCollision(true);
        tile[56].setCollision(true);
        tile[57].setCollision(true);
        tile[59].setCollision(true);
        tile[61].setCollision(true);
        tile[65].setCollision(true);
        tile[66].setCollision(true);
        tile[82].setCollision(true);
        tile[81].setCollision(true);
        tile[68].setCollision(true);
        tile[67].setCollision(true);
        tile[83].setCollision(true);
        tile[84].setCollision(true);
        tile[85].setCollision(true);
        tile[109].setCollision(true);

        tile[111].setCollision(true);
        tile[112].setCollision(true);
        tile[113].setCollision(true);
        tile[114].setCollision(true);

        for(int i =11;i<19;i++){
            tile[i].setCollision(true);
        }
        for(int i =40;i<48;i++){
            tile[i].setFastBlock(true);
        }
    }

    public void loadMap(String filepath, int map){
        try{
            //Doc file map
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col < gp.getMaxWorldCol() && row < gp.getMaxWorldRow()){
                String line = br.readLine(); // doc 1 dong
                while(col < gp.getMaxWorldCol()){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if(col == gp.getMaxWorldCol()){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        if(gp.getCurrentMap() == 0 || gp.getCurrentMap() == 9){
            g2.setColor(new Color(	75,144,72));
            g2.fillRect(0,0,gp.getScreenWidth(), gp.getScreenHeight());
        }else if(gp.getCurrentMap() == 1){
            g2.setColor(new Color(245,245,248));
            g2.fillRect(0,0,gp.getScreenWidth(), gp.getScreenHeight());
        }else if(gp.getCurrentMap() == 2){
            g2.setColor(new Color(190,161,117));
            g2.fillRect(0,0,gp.getScreenWidth(), gp.getScreenHeight());
        }else if(gp.getCurrentMap() == 3){
            g2.setColor(new Color(255,68,52));
            g2.fillRect(0,0,gp.getScreenWidth(), gp.getScreenHeight());
        }

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.getMaxWorldCol() && worldRow < gp.getMaxWorldRow()){
            int tileNum = mapTileNum[gp.getCurrentMap()][worldCol][worldRow];
            int worldX = worldCol * gp.getTileSize();
            int worldY = worldRow * gp.getTileSize();
            int screenX = worldX - gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX();
            int screenY = worldY - gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY();
            if(     worldX + gp.getTileSize() > gp.getPlayer().getWorldX() - gp.getPlayer().getScreenX() &&
                    worldX - gp.getTileSize() < gp.getPlayer().getWorldX() + gp.getPlayer().getScreenX() &&
                    worldY + gp.getTileSize() > gp.getPlayer().getWorldY() - gp.getPlayer().getScreenY() &&
                    worldY- gp.getTileSize() < gp.getPlayer().getWorldY() + gp.getPlayer().getScreenY()
            ){
                g2.drawImage(tile[tileNum].getImage() ,screenX,screenY,gp.getTileSize(), gp.getTileSize(),null);
            }
            worldCol++;

            if(worldCol == gp.getMaxWorldCol()){
                worldCol=0;
                worldRow++;
            }
        }
    }
}
