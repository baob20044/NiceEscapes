package main;

import objects.OBJ_Key;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80, arial_20, arial_10,Plus_80,arial_5,arial_end;
    BufferedImage keyImage;
    BufferedImage pause_img;
    BufferedImage heart3_img;
    BufferedImage heart2_img;
    BufferedImage heart1_img;
    BufferedImage cup_img;
    BufferedImage back_img;
    BufferedImage nameBk_img;
    BufferedImage eng;
    BufferedImage vie;
    BufferedImage fra;
    BufferedImage ger;
    private boolean messageOn = false;
    private String message = "";
    int messageCounter = 0;
    private boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80 = new Font("Arial", Font.BOLD, 80);
        arial_20 = new Font("Mona Lisa Solid ITC TT", Font.PLAIN, 40);
        arial_10 = new Font("Mona Lisa Solid ITC TT", Font.PLAIN, 35);
        arial_5 = new Font("Mona Lisa Solid ITC TT", Font.ITALIC, 35);
        Plus_80 = new Font("GB18030 Bitmap", Font.BOLD, 100);
        arial_end = new Font("Arial", Font.BOLD, 45);
        OBJ_Key key = new OBJ_Key();
        try {
            BufferedImage pause_image = ImageIO.read(getClass().getResourceAsStream("/objects/pause1.png"));
            BufferedImage heart3_image = ImageIO.read(getClass().getResourceAsStream("/objects/heart3.png"));
            BufferedImage heart2_image = ImageIO.read(getClass().getResourceAsStream("/objects/heart2.png"));
            BufferedImage heart1_image = ImageIO.read(getClass().getResourceAsStream("/objects/heart1.png"));
            BufferedImage cup_image = ImageIO.read(getClass().getResourceAsStream("/background/cupbadge.png"));
            BufferedImage back_image = ImageIO.read(getClass().getResourceAsStream("/background/back.png"));
            BufferedImage bkName_image = ImageIO.read(getClass().getResourceAsStream("/background/Summer6.png"));
            BufferedImage eng_image = ImageIO.read(getClass().getResourceAsStream("/background/eng.png"));
            BufferedImage vie_image = ImageIO.read(getClass().getResourceAsStream("/background/vie.png"));
            BufferedImage fra_image = ImageIO.read(getClass().getResourceAsStream("/background/fra.png"));
            BufferedImage ger_image = ImageIO.read(getClass().getResourceAsStream("/background/chi.png"));

            pause_img = pause_image;
            heart3_img = heart3_image;
            heart2_img = heart2_image;
            heart1_img = heart1_image;
            cup_img = cup_image;
            back_img = back_image;
            nameBk_img = bkName_image;
            eng = eng_image;
            vie = vie_image;
            fra = fra_image;
            ger = ger_image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        keyImage = key.getImage();
    }


    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);

        //TITLE STATE
        if (gp.getGameState() == gp.getTitleState()) {
            drawTitleScreen();
        }
        if (gp.getGameState() == gp.getPlayState()) {
            playTime += (double) 1 / 60;
            drawPlayScreen();
        }
        if (gp.getGameState() == gp.getEndState()) {
            drawFinishedScreen();
            gp.setGameThread(null);
        }
        if (gp.getGameState() == gp.getPauseState()) {
            drawPauseScreen();
        }
        if (gp.getGameState() == gp.getDeathState()) {
            drawDeathScreen();
        }
        if (gp.getGameState() == gp.getSettingState()) {
            drawSettingScreen();
        }
        if (gp.getCurrentMap() == 2 && gp.getGameStage() == 2) {
            drawMiniGameUI();
        }
        if (gp.getGameState() == gp.getAchiveState()) {
            drawAchieveUI();
        }
        if (gp.getGameState() == gp.getNameState()) {
            drawNameUI();
        }
    }

    public void drawAchieveUI() {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/background/Summer7.png"));
            g2.drawImage(image, 0, 0, gp.getScreenWidth(), gp.getScreenHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setColor(Color.white);
        g2.fillRoundRect(gp.getTileSize() * 4, gp.getTileSize() * 2 + 20, gp.getTileSize() * 12, gp.getTileSize() * 16, 30, 30);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text1 =translate("High Score","Thành tích","Réalisations","Erfolge");
        int x = getXforCenteredText(text1);
        int y = gp.getTileSize() * 2;

        g2.setColor(Color.black);
        g2.drawString(text1, x + 5, y + 5);
        g2.setColor(new Color(245, 116, 97));
        g2.drawString(text1, x, y);

        g2.drawImage(back_img, 1 * gp.getTileSize(), 11 * gp.getTileSize() - 32, gp.getScreenWidth() / 10, gp.getScreenHeight() / 8, null);

        try {
            FileReader fr = new FileReader("achievement.txt");
            BufferedReader br = new BufferedReader(fr);

            int i;
            int gap = 20;
            String text = "";
            g2.setColor(Color.black);
            g2.setFont(arial_10);
            while ((i = br.read()) != -1) {
                text += (char) i;
                if ((char) i == '\n') {
                    g2.drawString(text, getXforCenteredText(text), gp.getTileSize() * 3 + gap);
                    gap += gp.getTileSize();
                    text = "";
                }
            }
            br.close();
            fr.close();
        } catch (Exception f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }
    }

    public void drawNameUI() {
        g2.drawImage(nameBk_img, 0, 0, gp.getScreenWidth(), gp.getScreenHeight(), null);
        g2.setColor(Color.black);
        g2.fillRoundRect(4*gp.getTileSize()+5, gp.getScreenHeight() / 2 - 62+5, 12*gp.getTileSize(), 2 * gp.getTileSize(),60,60);
        g2.setColor(Color.white);
        g2.fillRoundRect(4*gp.getTileSize(), gp.getScreenHeight() / 2 - 62, 12*gp.getTileSize(), 2 * gp.getTileSize(),60,60);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        g2.setFont(Plus_80);
        String text = "";
        int x = getXforCenteredText(text);
        int y = gp.getTileSize() * 3 + 28;

        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y + 5);
        g2.drawString(text, x - 1, y - 1);
        g2.drawString(text, x +1, y + 1);
        g2.setColor(new Color(255, 0, 51));
        g2.drawString(text, x, y);

        g2.setFont(arial_5);
        g2.setColor(new Color(211,211,211));
        String text3 = "Username";
        if(gp.getName() == ""){
            g2.drawString(text3, getXforCenteredText(text3), gp.getScreenHeight() / 2);
        }
        if (gp.isTypeName() == true) {
            g2.setFont(arial_20);
            g2.setColor(Color.BLACK);
            String text2 = gp.getName();
            g2.drawString(gp.getName(), getXforCenteredText(text2), gp.getScreenHeight() / 2);
        }
    }

    public void drawMiniGameUI() {
        g2.setFont(arial_80);
        g2.setColor(Color.WHITE);
        g2.drawString("" + gp.getaSetter().getcTime() / 60, 17 * gp.getTileSize() + 28, 11 * gp.getTileSize());
    }

    public void drawPlayScreen() {
        g2.setFont(arial_40);
        g2.setColor(Color.black);
        g2.drawImage(keyImage, gp.getTileSize() / 2, gp.getTileSize() / 2, gp.getTileSize(), gp.getTileSize(), null);
        g2.drawString("x " + gp.getPlayer().getHasKey(), 75, 65);

        g2.drawImage(pause_img, gp.getTileSize() * 18, gp.getTileSize() / 2, gp.getTileSize() + 20, gp.getTileSize() + 20, null);
        if (gp.getPlayer().getHeart() == 3) {
            g2.drawImage(heart3_img, gp.getTileSize() / 4, gp.getTileSize() * 10, gp.getTileSize() * 6, gp.getTileSize() + 20, null);
        } else if (gp.getPlayer().getHeart() == 2) {
            g2.drawImage(heart2_img, gp.getTileSize() / 4, gp.getTileSize() * 10, gp.getTileSize() * 6, gp.getTileSize() + 20, null);
        } else {
            g2.drawImage(heart1_img, gp.getTileSize() / 4, gp.getTileSize() * 10, gp.getTileSize() * 6, gp.getTileSize() + 20, null);
        }
        g2.setFont(arial_20);
        g2.setColor(Color.WHITE);
        String text1 = translate("Time: " + gp.getAchiveTime() / 60,"Thời gian: " + gp.getAchiveTime() / 60,"Temps: " + gp.getAchiveTime() / 60,"Zeit: "+ gp.getAchiveTime() / 60);
        g2.drawString(text1, getXforCenteredText(text1), gp.getTileSize());

        if (gp.getCurrentMap() == 9) {
            g2.setColor(new Color(105, 132, 51));
            g2.fillRoundRect(5 * gp.getTileSize(), 2 * gp.getTileSize(), 10 * gp.getTileSize(), 3 * gp.getTileSize() - 28, 30, 30);
            g2.fillRoundRect(5 * gp.getTileSize(), 8 * gp.getTileSize() - 28, 10 * gp.getTileSize(), 3 * gp.getTileSize() - 28, 30, 30);
            String text;
            int x;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            g2.setColor(new Color(212, 161, 80));
            text = translate("LOAD GAME","MỞ FILE LƯU","Chargement du jeu","Spiel laden");
            x = getXforCenteredText(text);
            g2.drawString(text, x, 4 * gp.getTileSize() - 20);
            g2.setColor(new Color(17, 69, 93));
            g2.drawString(text, x + 2, 4 * gp.getTileSize() - 20 + 5);

            text = translate("NEW GAME","GAME MỚI","NOUVEAU JEU","NEUES SPIEL");
            x = getXforCenteredText(text);
            g2.setColor(new Color(212, 161, 80));
            g2.drawString(text, x, 9 * gp.getTileSize());
            g2.setColor(new Color(17, 69, 93));
            g2.drawString(text, x + 2, 9 * gp.getTileSize() + 5);
        }
    }

    public void drawDeathScreen() {
        g2.setColor(new Color(105, 105, 105));
        g2.fillRect(0, 0, gp.getScreenWidth(), gp.getScreenHeight());
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/background/Summer3.png"));
            g2.drawImage(image, 0, 0, gp.getScreenWidth(), gp.getScreenHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 96F));
        String text = translate("YOU DIED","BẠN ĐÃ CHẾT","TU ES MORT","DU BIST GESTORBEN");
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = getXforCenteredText(text);
        int y = gp.getScreenHeight() / 2;
        g2.setColor(Color.black);
        g2.drawString(text, x + 4, y + 4);
        g2.setColor(new Color(245, 116, 97));
        g2.drawString(text, x, y);

        g2.setColor(Color.black);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 35F));
        text = translate("Press Enter to continue","Ấn Enter để tiếp tục","Appuyez Entrée continuer","Drücken Eingabeta um fortzufah");
        length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = getXforCenteredText(text);
        y = gp.getScreenHeight() / 2 + gp.getTileSize();

        g2.drawString(text, x, y);
    }

    public void drawSettingScreen() {
        g2.setColor(new Color(0, 126, 135));
        g2.fillRect(0, 0, gp.getScreenWidth(), gp.getScreenHeight());
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/background/Summer5.png"));
            g2.drawImage(image, 0, 0, gp.getScreenWidth(), gp.getScreenHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setColor(new Color(105, 132, 51));
        g2.fillRoundRect(5 * gp.getTileSize(), 4 * gp.getTileSize(), 10 * gp.getTileSize(), 2 * gp.getTileSize() - 28, 30, 30);

        g2.setColor(new Color(34, 139, 34));
        g2.fillRect(5 * gp.getTileSize(), 4 * gp.getTileSize(), 2 * gp.getTileSize(), 2 * gp.getTileSize() - 28);
        g2.fillRect(13 * gp.getTileSize(), 4 * gp.getTileSize(), 2 * gp.getTileSize(), 2 * gp.getTileSize() - 28);

        g2.setColor(new Color(105, 132, 51));
        g2.fillRoundRect(5 * gp.getTileSize(), 8 * gp.getTileSize(), 10 * gp.getTileSize(), 2 * gp.getTileSize() - 28, 30, 30);

        String text ="";
        int x;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
        g2.setColor(new Color(245, 116, 97));
        text = translate("VOLUME ADJUST","CHỈNH ÂM LƯỢNG","AJUSTEMENT DU VOLUME","LAUTSTÄRKEREGLER");
        x = getXforCenteredText(text);
        g2.drawString(text, x, 3 * gp.getTileSize());

        g2.setColor(new Color(17, 69, 93));
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
        text = "+";
        x = getXforCenteredText(text);
        g2.drawString(text, 13 * gp.getTileSize() + 28, 5 * gp.getTileSize() + 8);

        text = "-";
        x = getXforCenteredText(text);
        g2.drawString(text, 5 * gp.getTileSize() + 33, 5 * gp.getTileSize() + 8);

        float num = gp.getVolume() * 100;
        text = "" + (int) num + "%";
        if (gp.getVolume() <= 0) {
            text = "" + 0 + "%";
        }
        x = getXforCenteredText(text);
        g2.drawString(text, x, 5 * gp.getTileSize() + 8);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 45F));
        text = translate("BACK","QUAY LẠI","DOS","ZURÜCK");
        x = getXforCenteredText(text);
        g2.drawString(text, x, 9 * gp.getTileSize());

        g2.drawImage(eng, 5 * gp.getTileSize()-18, 6 * gp.getTileSize(), gp.getScreenWidth()/11, gp.getScreenHeight()/10, null);
        g2.drawImage(vie, 8 * gp.getTileSize()-18, 6 * gp.getTileSize(), gp.getScreenWidth()/11, gp.getScreenHeight()/10, null);
        g2.drawImage(fra, 11 * gp.getTileSize()-18, 6 * gp.getTileSize(), gp.getScreenWidth()/11, gp.getScreenHeight()/10, null);
        g2.drawImage(ger, 14 * gp.getTileSize()-18, 6 * gp.getTileSize(), gp.getScreenWidth()/11, gp.getScreenHeight()/10, null);
    }

    public void drawFinishedScreen() {
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/background/Summer8.png"));
            g2.drawImage(image, 0, 0, gp.getScreenWidth(), gp.getScreenHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setFont(arial_end);
        String text;
        int textLength;
        int x;
        int y;

        text = gp.getName() + translate(" get a Nice Escape"," trốn thoát thành công"," obtenez une belle évasion"," gönnen Sie sich eine schöne Auszeit");
        text = text.toUpperCase();
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.getScreenWidth() / 2 - textLength / 2;
        y = gp.getScreenHeight() / 2 - (gp.getTileSize() * 3);
        g2.setColor(Color.black);
        g2.drawString(text, x+3, y+3);
        g2.setColor(new Color(203,65,84));
        g2.drawString(text, x, y);
        //
        text = translate("Your time is : ","Thời gian hoàn thành : ","Votre heure est  : ","Ihre Zeit ist : ") + gp.getAchiveTime()/60 + "!";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.getScreenWidth() / 2 - textLength / 2;
        y = gp.getScreenHeight() / 2 + (gp.getTileSize() * 4);
        g2.setColor(Color.black);
        g2.drawString(text, x+3, y+3);
        g2.setColor(new Color(203,65,84));
        g2.drawString(text, x, y);
        //
        g2.setFont(arial_80);
        text = translate("Congratulations","Chúc mừng","Toutes nos félicitations","Glückwunsch");
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.getScreenWidth() / 2 - textLength / 2;
        y = gp.getScreenHeight() / 2 + (gp.getTileSize() * 2);
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        g2.setColor(Color.yellow);
        g2.drawString(text, x, y);

        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/background/trophy.png"));
            g2.drawImage(image, gp.getTileSize()*8-18, gp.getTileSize()*3-18, gp.getTileSize()*5, gp.getTileSize()*5, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        gp.setGameThread(null);
    }

    public void drawTitleScreen() {
        g2.setColor(new Color(0, 126, 135));
        g2.fillRect(0, 0, gp.getScreenWidth(), gp.getScreenHeight());
        //TITLE NAME
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/background/Summer.png"));
            g2.drawImage(image, 0, 0, gp.getScreenWidth(), gp.getScreenHeight(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 100F));
        String text = "Nice Escape";
        int x = getXforCenteredText(text);
        int y = gp.getTileSize() * 3;

        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y + 5);
        g2.setColor(new Color(245, 116, 97));
        g2.drawString(text, x, y);

        g2.setColor(new Color(105, 132, 51));
        g2.fillRoundRect(5 * gp.getTileSize(), 4 * gp.getTileSize(), 10 * gp.getTileSize(), 2 * gp.getTileSize() - 28, 30, 30);

        g2.fillRoundRect(5 * gp.getTileSize(), 6 * gp.getTileSize(), 10 * gp.getTileSize(), 2 * gp.getTileSize() - 28, 30, 30);

        g2.fillRoundRect(5 * gp.getTileSize(), 8 * gp.getTileSize(), 10 * gp.getTileSize(), 2 * gp.getTileSize() - 28, 30, 30);
        text = translate("PLAY GAME","CHƠI MỚI","JOUER AU JEU","SPIEL SPIELEN");
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 45F));
        x = getXforCenteredText(text);
        g2.setColor(new Color(17, 69, 93));
        g2.drawString(text, x, 5 * gp.getTileSize());
        g2.setColor(new Color(212, 161, 80));
        g2.drawString(text, x + 2, 5 * gp.getTileSize() + 2);

        g2.setColor(new Color(17, 69, 93));
        text = translate("Setting","Cài đặt","Paramètre","Einstellung");
        x = getXforCenteredText(text);
        g2.drawString(text, x, 7 * gp.getTileSize());
        text = translate("Exit","Thoát","Sortie","Ausfahrt");
        x = getXforCenteredText(text);
        g2.drawString(text, x, 9 * gp.getTileSize());


        text = translate("Made by: Đinh Quốc Bảo & Trần Minh Hiếu","Làm bởi: Đinh Quốc Bảo & Trần Minh Hiếu","Faite par: Đinh Quốc Bảo & Trần Minh Hiếu","Hergestellt von: Đinh Quốc Bảo & Trần Minh Hiếu");
        g2.setFont(g2.getFont().deriveFont(Font.ITALIC, 20F));
        g2.setColor(Color.white);
        x = getXforCenteredText(text);
        y = gp.getTileSize() * 11;
        g2.drawString(text, x, y);

        g2.drawImage(cup_img, 16 * gp.getTileSize(), 9 * gp.getTileSize(), gp.getScreenWidth() / 6, gp.getScreenHeight() / 5, null);
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = translate("PAUSED","TẠM DỪNG","EN PAUSE","PAUSIERT");
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = getXforCenteredText(text);
        int y = gp.getScreenHeight() / 2;
        g2.setColor(new Color(245, 116, 97));
        g2.drawString(text, x + 6, y);
        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y);
        g2.setColor(new Color(245, 116, 97));
        g2.drawString(text, x, y);

        g2.setColor(Color.white);
        g2.fillRect(0, 0, 30 * gp.getTileSize(), 2 * gp.getTileSize() - 28);

        g2.fillRect(0, 11 * gp.getTileSize() - 28, 30 * gp.getTileSize(), 2 * gp.getTileSize());

        g2.setColor(Color.black);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 35F));
        text = translate("Press Enter to continue","Ấn Enter để tiếp tục","Appuyez Entrée continuer","Drücken Eingabeta um fortzufah");
        length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = getXforCenteredText(text);
        y = gp.getScreenHeight() / 2 + gp.getTileSize();
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        g2.setColor(new Color(0, 126, 135));
        text = translate("Press S to save game","Ấn S để lưu game","Appuyez S pour sauvega partie","Drücken S, um Spiel speiche");
        x = gp.getTileSize() * 13;
        y = gp.getTileSize() * 1;
        g2.drawString(text, x, y);

        text = translate("Press Q to return menu","Ấn Q để quay lại trang chính","Appuyez Q revenir menu","Drücken Q, um Menü zurückzu") ;
        x = gp.getTileSize() - 10;
        y = gp.getTileSize() * 1;
        g2.drawString(text, x, y);

        text = translate("Press R to restart game","Ấn R để chơi lại","Appuyez R redémarrer le jeu","Drücken R, um Spiel starten");
        x = gp.getTileSize() - 10;
        y = gp.getTileSize() * 11 + 20;
        g2.drawString(text, x, y);
        if (gp.getKeyH().isSaved() == true) {
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
            text = translate("SAVED...","ĐÃ LƯU...","ENREGISTRÉE","GERETTET...");
            x = gp.getTileSize() * 14;
            y = gp.getTileSize() * 11 + 28;
            g2.drawString(text, x, y);
        }
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.getScreenWidth() / 2 - length / 2;
        return x;
    }
    public String translate(String eng, String vie, String fra, String ger){
        if(gp.getLanguage()==1){
            return eng;
        }else if(gp.getLanguage() == 2){
            return vie;
        }else if(gp.getLanguage() == 3){
            return fra;
        }else if(gp.getLanguage() == 4){
            return ger;
        }
        return "";
    }
}
