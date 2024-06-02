package main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mouse implements MouseListener {
    GamePanel gp;
    public Mouse(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(gp.getGameState() == gp.getPlayState()){
            if((x > 18*gp.getTileSize() && x<19*gp.getTileSize())&& (y > gp.getTileSize()/2 && y<gp.getTileSize() +gp.getTileSize()/2 )){
                gp.setGameState(gp.getPauseState());
            }
            if(gp.getCurrentMap() == 9){
                if((x > 5*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 2*gp.getTileSize() && y<5*gp.getTileSize() - 28 )){
                    try {
                        File myObj = new File("savegame.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            int data = myReader.nextInt();
                            gp.setCurrentMap(data);
                            if(gp.getCurrentMap() == 0 || gp.getCurrentMap() == 2){
                                gp.getPlayer().setWorldX(gp.getTileSize() *1);
                                gp.getPlayer().setWorldY(gp.getTileSize() *1);
                                gp.getPlayer().setSpawnX(gp.getPlayer().getWorldX());
                                gp.getPlayer().setSpawnY(gp.getPlayer().getWorldY());
                            }else if(gp.getCurrentMap() == 1){
                                gp.getPlayer().setWorldX(gp.getTileSize() *5);
                                gp.getPlayer().setWorldY(gp.getTileSize() *15);
                                gp.getPlayer().setSpawnX(gp.getPlayer().getWorldX());
                                gp.getPlayer().setSpawnY(gp.getPlayer().getWorldY());
                            }else if(gp.getCurrentMap() == 3){
                                gp.getPlayer().setWorldX(gp.getTileSize() *5);
                                gp.getPlayer().setWorldY(gp.getTileSize() *3);
                                gp.getPlayer().setSpawnX(gp.getPlayer().getWorldX());
                                gp.getPlayer().setSpawnY(gp.getPlayer().getWorldY());
                            }
                            gp.getPlayer().disableKey();
                        }
                        myReader.close();
                    } catch (FileNotFoundException f) {
                        System.out.println("An error occurred.");
                        f.printStackTrace();
                    }
                }
                if((x > 5*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 8*gp.getTileSize()-28 && y<11*gp.getTileSize() - 28 -28 )){
                    gp.getKeyH().setRightPressed(true);
                }
            }
        }
        if(gp.getGameState() == gp.getTitleState()){
            if((x > 5*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 4*gp.getTileSize() && y<6*gp.getTileSize() - 28 )){
                gp.setGameState(gp.getPlayState());
            }
            else if((x > 5*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 8*gp.getTileSize() && y<10*gp.getTileSize() - 28 )){
                System.exit(0);
            }else if(((x > 5*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 6*gp.getTileSize() && y<8*gp.getTileSize() - 28 ))){
                gp.setGameState(gp.getSettingState());
            }else if((x > 16* gp.getTileSize() && x<16* gp.getTileSize()+gp.getScreenWidth()/6)&& (y > 9*gp.getTileSize() && y<9*gp.getTileSize() + gp.getScreenHeight()/5 )){
                gp.setGameState(gp.getAchiveState());
            }
        }else if(gp.getGameState() == gp.getAchiveState()){
            if((x > 1* gp.getTileSize() && x<1*gp.getTileSize()+gp.getScreenWidth()/10)&& (y > 11*gp.getTileSize()-32 && y<11*gp.getTileSize()+gp.getScreenHeight()/8 )){
                gp.setGameState(gp.getTitleState());
            }
        }
        else if(gp.getGameState() == gp.getSettingState()) {
            if((x > 5*gp.getTileSize() && x<7*gp.getTileSize())&& (y > 4*gp.getTileSize() && y<6*gp.getTileSize() - 28 )){
                try{
                    gp.setVolume(gp.getVolume()-0.1f);
                    if(gp.getVolume()< 0.1f){
                        gp.setVolume(0);
                    }
                    gp.getSound().setVolume(gp.getVolume());
                }catch(IllegalArgumentException f){
                    System.out.println("Below 0");
                }
            }
            if((x > 13*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 4*gp.getTileSize() && y<6*gp.getTileSize() - 28 )){
                gp.setVolume(gp.getVolume()+0.1f);
                gp.getSound().setVolume(gp.getVolume());
                if(gp.getVolume()>1){
                    gp.setVolume(1);
                }
            }
            if((x > 5*gp.getTileSize() && x<15*gp.getTileSize())&& (y > 8*gp.getTileSize() && y<10*gp.getTileSize() - 28 )){
                gp.setGameState(gp.getTitleState());
            }else if((x > 5 * gp.getTileSize()-18 && x<5 * gp.getTileSize()-18 +gp.getScreenWidth()/11)&& (y > 6 * gp.getTileSize() && y<6 * gp.getTileSize() +  gp.getScreenHeight()/10)){
                gp.setLanguage(gp.getEng());
            }else if((x > 8 * gp.getTileSize()-18 && x<8 * gp.getTileSize()-18 +gp.getScreenWidth()/11)&& (y > 6 * gp.getTileSize() && y<6 * gp.getTileSize() +  gp.getScreenHeight()/10)){
                gp.setLanguage(gp.getVie());
            }else if((x > 11 * gp.getTileSize()-18 && x<11 * gp.getTileSize()-18 +gp.getScreenWidth()/11)&& (y > 6 * gp.getTileSize() && y<6 * gp.getTileSize() +  gp.getScreenHeight()/10)){
                gp.setLanguage(gp.getFra());
            }else if((x > 14 * gp.getTileSize()-18 && x<14 * gp.getTileSize()-18 +gp.getScreenWidth()/11)&& (y > 6 * gp.getTileSize() && y<6 * gp.getTileSize() +  gp.getScreenHeight()/10)){
                gp.setLanguage(gp.getChi());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
