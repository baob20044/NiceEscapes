package main;

import entity.Entity;
import entity.Player;
import objects.OBJ_Chest;
import objects.SuperObject;
import tile.TileManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; // 16x16
    final int scale = 3; // tang len de phu hop voi man hinh 16 * 3

    public int getTileSize() {
        return TileSize;
    }

    private final int TileSize = originalTileSize*scale;
    private final int maxScreenCol = 20; //16 o Tile be ngang
    private final int maxScreenRow = 12; // 12 o Tile be doc
    private final int screenWidth = TileSize*maxScreenCol;

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getMaxMap() {
        return maxMap;
    }

    private final int screenHeight = TileSize*maxScreenRow;

    //WORLD SETTINGS
    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;
    private final int maxMap = 10;

    public int getAchiveTime() {
        return achiveTime;
    }

    public void setAchiveTime(int achiveTime) {
        this.achiveTime = achiveTime;
    }

    private int achiveTime = 0;

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }

    private String Name = "";

    public int getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(int currentMap) {
        this.currentMap = currentMap;
    }

    private int currentMap = 0;
    //FPS
    int FPS = 60;

    public KeyHandler getKeyH() {
        return keyH;
    }

    public void setKeyH(KeyHandler keyH) {
        this.keyH = keyH;
    }

    //SYSTEM
    private KeyHandler keyH = new KeyHandler(this);
    private Mouse mH = new Mouse(this);

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    private UI ui = new UI(this);

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    private Thread gameThread;

    public CollisionChecker getcChecker() {
        return cChecker;
    }

    public void setcChecker(CollisionChecker cChecker) {
        this.cChecker = cChecker;
    }

    private CollisionChecker cChecker = new CollisionChecker(this);
    TileManager tileM = new TileManager(this);

    public AssetSetter getaSetter() {
        return aSetter;
    }

    public void setaSetter(AssetSetter aSetter) {
        this.aSetter = aSetter;
    }

    private AssetSetter aSetter = new AssetSetter(this);

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public SuperObject[] getObj() {
        return obj;
    }

    public void setObj(SuperObject[] obj) {
        this.obj = obj;
    }

    //ENTITY AND OBJECT
    private Player player = new Player(this,keyH);
    private SuperObject obj[] = new SuperObject[100];

    public Entity[] getNpc() {
        return npc;
    }

    public void setNpc(Entity[] npc) {
        this.npc = npc;
    }

    private Entity npc[] = new Entity[100];

    public SuperObject[] getDecor() {
        return decor;
    }

    public void setDecor(SuperObject[] decor) {
        this.decor = decor;
    }

    private SuperObject decor[] = new SuperObject[30];

    public Entity[] getDragon() {
        return dragon;
    }

    public void setDragon(Entity[] dragon) {
        this.dragon = dragon;
    }

    private Entity dragon[] = new Entity[30];

    public Entity[] getFire() {
        return fire;
    }

    public void setFire(Entity[] fire) {
        this.fire = fire;
    }

    private Entity fire[] = new Entity[30];

    public Entity[] getAlert() {
        return alert;
    }

    public void setAlert(Entity[] alert) {
        this.alert = alert;
    }

    private Entity alert[] = new Entity[100];

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    //GAME STATE
    private int gameState;
    private final int playState = 1;
    private final int pauseState = 2;
    private final int titleState = 0;

    public int getAchiveState() {
        return achiveState;
    }

    private final int achiveState = 6;

    public int getNameState() {
        return nameState;
    }

    private final int nameState = 7;

    public int getPlayState() {
        return playState;
    }

    public int getPauseState() {
        return pauseState;
    }

    public int getTitleState() {
        return titleState;
    }

    public int getDeathState() {
        return deathState;
    }

    public int getEndState() {
        return endState;
    }

    public int getSettingState() {
        return settingState;
    }

    private final int deathState = 3;
    private final int endState = 4;
    private final int settingState = 5;

    public int getGameStage() {
        return gameStage;
    }

    public void setGameStage(int gameStage) {
        this.gameStage = gameStage;
    }

    private int gameStage;

    //Volume
    URL soundURL = Sound.class.getResource("/sound/tetris.wav");

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    private Sound sound = new Sound(soundURL);

    public boolean isTypeName() {
        return typeName;
    }

    public void setTypeName(boolean typeName) {
        this.typeName = typeName;
    }

    private boolean typeName = true;

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    private float volume = 0.5f;

    private int Eng = 1;

    public int getEng() {
        return Eng;
    }

    public int getVie() {
        return Vie;
    }

    public int getFra() {
        return Fra;
    }

    public int getChi() {
        return Chi;
    }

    private int Vie = 2;
    private int Fra = 3;
    private int Chi = 4;

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    private int language;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight)); // Set chieu dai rong cua cua so
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // tang hieu suat cua anh cho vao (render anh tot hon)

        this.addKeyListener(keyH); //Them nut an vao gamepanel
        this.setFocusable(true); // tap trung nhan nut an
        this.addMouseListener(mH);
    }

    public void setupGame(){
        aSetter.setObject();
        playMusic();
        gameState = nameState;
        gameStage = 1;
        currentMap = 9;
        aSetter.setNPC0();
        setLanguage(Eng);
    }

    public void StartGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            update(); // Cap nhat nv
            repaint(); // Ve nv


            try { //Xu li phan thoi gian
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Update
    public void update(){
        if(gameState == playState){
                setAchiveTime(getAchiveTime()+1);
                for(int i = 0;i<dragon.length;i++) {
                    if(fire[i]!=null){
                        fire[i].update(false,false);
                    }
                    if(dragon[i]!=null){
                        dragon[i].update(false,true);
                    }
                }
                for(int i = 0;i<npc.length;i++){
                    if(npc[i]!=null){
                        npc[i].update(true,false);
                    }
                    if(alert[i]!=null){
                        alert[i].update(false,false);
                    }
                }
            player.update();
                if(currentMap == 2 && gameStage == 2){
                    if(aSetter.isEndMiniGame() == false){
                        aSetter.miniGame();
                    }
                }
        }
        if(gameState == pauseState){
        }
        if(gameState == deathState){
        }
    }

    //Draw
    public void paintComponent(Graphics g){
        super.paintComponent(g); // Muon su dung paintComponent thi phai type lenh nay truoc
        Graphics2D g2 = (Graphics2D) g; // Graphic2D co nhieu chuc nang hon

        //TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }
        else if(gameState == deathState){
            ui.draw(g2);
        }
        else if(gameState == endState){
            ui.draw(g2);
        }
        else{
            tileM.draw(g2);
                for(int i = 0;i< obj.length;i++){
                    if(obj[i]!=null){
                        obj[i].draw(g2,this);
                    }
                }
                for(int i = 0;i< decor.length;i++) {
                    if (decor[i] != null) {
                        decor[i].draw(g2,this);
                    }
                    if(fire[i]!=null) {
                        fire[i].draw(g2,1);
                    }
                    if(dragon[i]!=null){
                        dragon[i].draw(g2,3);
                    }
                }
                for(int i = 0;i< npc.length;i++) {
                    if (npc[i] != null) {
                        npc[i].draw(g2,1);
                    }
                    if(alert[i]!=null){
                        alert[i].draw(g2,1);
                    }
            }
            player.draw(g2);
            ui.draw(g2);

            g2.dispose(); // tiet kiem bo nho
        }
    }

    //Music
    public void playMusic(){
        sound.play(); // Phát âm thanh
        // Giảm âm lượng
        sound.setVolume(volume); // giảm âm lượng còn ..%
        sound.loop();
    }
}
