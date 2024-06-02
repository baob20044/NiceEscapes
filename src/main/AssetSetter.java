package main;

import entity.*;
import entity.Decorate.NPC_GreenHair;
import entity.Decorate.NPC_RedHair;
import entity.Map1.*;
import entity.Map2.Bird;
import entity.Map2.Snow;
import entity.Map3.Cactus;
import entity.Map3.DeadSpider;
import entity.Map3.Scorpia;
import entity.SnowHouse;
import objects.*;

public class AssetSetter {
    GamePanel gp;
    private int eTime = 0;

    public boolean isEndMiniGame() {
        return EndMiniGame;
    }

    public void setEndMiniGame(boolean endMiniGame) {
        EndMiniGame = endMiniGame;
    }

    private boolean EndMiniGame = false ;
    public int geteTime() {
        return eTime;
    }

    public void seteTime(int eTime) {
        this.eTime = eTime;
    }

    public int getcTime() {
        return cTime;
    }

    public void setcTime(int cTime) {
        this.cTime = cTime;
    }

    private int cTime = 0;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){
    }
    public void setNPC0(){
        gp.getObj()[0] = new OBJ_Chest();
        gp.getObj()[0].setWorldX(gp.getTileSize()*28);
        gp.getObj()[0].setWorldY(gp.getTileSize()*24);
    }
    public void setNPC(){
        //1
        gp.getObj()[0] = new OBJ_Chest();
        gp.getObj()[0].setWorldX(gp.getTileSize()*6);
        gp.getObj()[0].setWorldY(gp.getTileSize()*5);

        gp.getObj()[2] = new OBJ_Key();
        gp.getObj()[2].setWorldX(gp.getTileSize()*28);
        gp.getObj()[2].setWorldY(gp.getTileSize()*5);
        //2

        gp.getObj()[1] = new OBJ_Door();
        gp.getObj()[1].setWorldX(gp.getTileSize()*20);
        gp.getObj()[1].setWorldY(gp.getTileSize()*5);

        gp.getObj()[3] = new OBJ_Chest();
        gp.getObj()[3].setWorldX(gp.getTileSize()*14);
        gp.getObj()[3].setWorldY(gp.getTileSize()*8);

        gp.getDragon()[0] = new Dragon(gp,"left");
        gp.getDragon()[0].setWorldX(gp.getTileSize()*25);
        gp.getDragon()[0].setWorldY(gp.getTileSize()*4);

        gp.getFire()[0] = new Fire(gp,25,20,"left");
        gp.getFire()[0].setWorldX(gp.getTileSize()*25);
        gp.getFire()[0].setWorldY(gp.getTileSize()*5);
        //3
        gp.getObj()[4] = new OBJ_Door();
        gp.getObj()[4].setWorldX(gp.getTileSize()*31);
        gp.getObj()[4].setWorldY(gp.getTileSize()*10);

        gp.getObj()[5] = new OBJ_Door();
        gp.getObj()[5].setWorldX(gp.getTileSize()*31);
        gp.getObj()[5].setWorldY(gp.getTileSize()*9);

        gp.getObj()[6] = new OBJ_Key();
        gp.getObj()[6].setWorldX(gp.getTileSize()*32);
        gp.getObj()[6].setWorldY(gp.getTileSize()*3);

        gp.getObj()[7] = new OBJ_Key();
        gp.getObj()[7].setWorldX(gp.getTileSize()*45);
        gp.getObj()[7].setWorldY(gp.getTileSize()*1);

        gp.getObj()[8] = new OBJ_Chest();
        gp.getObj()[8].setWorldX(gp.getTileSize()*30);
        gp.getObj()[8].setWorldY(gp.getTileSize()*16);

        gp.getNpc()[2] = new Monster1V2(gp,120);
        gp.getNpc()[2].setWorldX(gp.getTileSize()*42);
        gp.getNpc()[2].setWorldY(gp.getTileSize()*4);

        gp.getNpc()[3] = new Monster1(gp,120);
        gp.getNpc()[3].setWorldX(gp.getTileSize()*32);
        gp.getNpc()[3].setWorldY(gp.getTileSize()*11);

        gp.getNpc()[4] = new Monster1(gp,120);
        gp.getNpc()[4].setWorldX(gp.getTileSize()*46);
        gp.getNpc()[4].setWorldY(gp.getTileSize()*13);

        gp.getNpc()[5] = new Monster1(gp,120);
        gp.getNpc()[5].setWorldX(gp.getTileSize()*48);
        gp.getNpc()[5].setWorldY(gp.getTileSize()*12);
        //4
        gp.getObj()[9] = new OBJ_Door();
        gp.getObj()[9].setWorldX(gp.getTileSize()*23);
        gp.getObj()[9].setWorldY(gp.getTileSize()*18);

        gp.getObj()[10] = new OBJ_Chest();
        gp.getObj()[10].setWorldX(gp.getTileSize()*22);
        gp.getObj()[10].setWorldY(gp.getTileSize()*17);

        gp.getObj()[11] = new OBJ_Key();
        gp.getObj()[11].setWorldX(gp.getTileSize()*7);
        gp.getObj()[11].setWorldY(gp.getTileSize()*16);

        gp.getNpc()[6] = new Demon(gp,60);
        gp.getNpc()[6].setWorldX(gp.getTileSize()*7);
        gp.getNpc()[6].setWorldY(gp.getTileSize()*10);

        gp.getNpc()[7] = new Demon(gp,60);
        gp.getNpc()[7].setWorldX(gp.getTileSize()*20);
        gp.getNpc()[7].setWorldY(gp.getTileSize()*14);

        gp.getNpc()[8] = new Bird(gp,60,4);
        gp.getNpc()[8].setWorldX(gp.getTileSize()*40);
        gp.getNpc()[8].setWorldY(gp.getTileSize()*16);

        //5

        gp.getObj()[12] = new OBJ_Door();
        gp.getObj()[12].setWorldX(gp.getTileSize()*25);
        gp.getObj()[12].setWorldY(gp.getTileSize()*45);

        gp.getObj()[13] = new OBJ_Key();
        gp.getObj()[13].setWorldX(gp.getTileSize()*18);
        gp.getObj()[13].setWorldY(gp.getTileSize()*40);

        gp.getDragon()[1] = new Dragon(gp,"right");
        gp.getDragon()[1].setWorldX(gp.getTileSize()*21);
        gp.getDragon()[1].setWorldY(gp.getTileSize()*34);

        gp.getFire()[1] = new Fire(gp,23,29,"right");
        gp.getFire()[1].setWorldX(gp.getTileSize()*23);
        gp.getFire()[1].setWorldY(gp.getTileSize()*35);

        gp.getDragon()[2] = new Dragon(gp,"left");
        gp.getDragon()[2].setWorldX(gp.getTileSize()*27);
        gp.getDragon()[2].setWorldY(gp.getTileSize()*39);

        gp.getFire()[2] = new Fire(gp,27,21,"left");
        gp.getFire()[2].setWorldX(gp.getTileSize()*27);
        gp.getFire()[2].setWorldY(gp.getTileSize()*40);

        gp.getNpc()[9] = new Demon(gp,120);
        gp.getNpc()[9].setWorldX(gp.getTileSize()*34);
        gp.getNpc()[9].setWorldY(gp.getTileSize()*28);

        gp.getNpc()[10] = new Demon(gp,120);
        gp.getNpc()[10].setWorldX(gp.getTileSize()*41);
        gp.getNpc()[10].setWorldY(gp.getTileSize()*27);

        gp.getNpc()[11] = new Monster1V2(gp,120);
        gp.getNpc()[11].setWorldX(gp.getTileSize()*20);
        gp.getNpc()[11].setWorldY(gp.getTileSize()*27);

        gp.getNpc()[12] = new Monster1V2(gp,180);
        gp.getNpc()[12].setWorldX(gp.getTileSize()*7);
        gp.getNpc()[12].setWorldY(gp.getTileSize()*28);

        gp.getObj()[14] = new OBJ_Chest();
        gp.getObj()[14].setWorldX(gp.getTileSize()*34);
        gp.getObj()[14].setWorldY(gp.getTileSize()*39);
        //decor
//        gp.obj[15] = new OBJ_Chest();
//        gp.obj[15].worldX = gp.getTileSize()*1;
//        gp.obj[15].worldY = gp.getTileSize()*1;

    }
    public void setNPC2() {
        //1
        gp.getNpc()[0] = new NPC_RedHair(gp);
        gp.getNpc()[0].setWorldX(gp.getTileSize()*3);
        gp.getNpc()[0].setWorldY(gp.getTileSize()*8);

        gp.getNpc()[1] = new NPC_GreenHair(gp);
        gp.getNpc()[1].setWorldX(gp.getTileSize()*4);
        gp.getNpc()[1].setWorldY(gp.getTileSize()*8);

        gp.getDragon()[0] = new SnowHouse(gp);
        gp.getDragon()[0].setWorldX(gp.getTileSize()*9);
        gp.getDragon()[0].setWorldY(gp.getTileSize()*1);

        gp.getObj()[0] = new OBJ_Health();
        gp.getObj()[0].setWorldX(gp.getTileSize()*4);
        gp.getObj()[0].setWorldY(gp.getTileSize()*1);

        gp.getObj()[1] = new OBJ_Key();
        gp.getObj()[1].setWorldX(gp.getTileSize()*47);
        gp.getObj()[1].setWorldY(gp.getTileSize()*17);

        gp.getObj()[2] = new OBJ_Door();
        gp.getObj()[2].setWorldX(gp.getTileSize()*9);
        gp.getObj()[2].setWorldY(gp.getTileSize()*6);

        gp.getObj()[3] = new OBJ_Door();
        gp.getObj()[3].setWorldX(gp.getTileSize()*9);
        gp.getObj()[3].setWorldY(gp.getTileSize()*7);

        gp.getObj()[4] = new OBJ_Key();
        gp.getObj()[4].setWorldX(gp.getTileSize()*20);
        gp.getObj()[4].setWorldY(gp.getTileSize()*14);

        gp.getNpc()[2] = new Bird(gp,60,4);
        gp.getNpc()[2].setWorldX(gp.getTileSize()*25);
        gp.getNpc()[2].setWorldY(gp.getTileSize()*13);

        gp.getNpc()[3] = new Bird(gp,60,4);
        gp.getNpc()[3].setWorldX(gp.getTileSize()*40);
        gp.getNpc()[3].setWorldY(gp.getTileSize()*3);

        gp.getNpc()[4] = new Bird(gp,60,4);
        gp.getNpc()[4].setWorldX(gp.getTileSize()*32);
        gp.getNpc()[4].setWorldY(gp.getTileSize()*17);

        gp.getObj()[5] = new OBJ_Chest();
        gp.getObj()[5].setWorldX(gp.getTileSize()*9);
        gp.getObj()[5].setWorldY(gp.getTileSize()*8);
        //2
        gp.getNpc()[5] = new Bird(gp,70,16);
        gp.getNpc()[5].setWorldX(gp.getTileSize()*6);
        gp.getNpc()[5].setWorldY(gp.getTileSize()*21);

        gp.getNpc()[6] = new Bird(gp,60,16);
        gp.getNpc()[6].setWorldX(gp.getTileSize()*8);
        gp.getNpc()[6].setWorldY(gp.getTileSize()*23);

        gp.getObj()[6] = new OBJ_Key();
        gp.getObj()[6].setWorldX(gp.getTileSize()*12);
        gp.getObj()[6].setWorldY(gp.getTileSize()*26);

        gp.getObj()[7] = new OBJ_Chest();
        gp.getObj()[7].setWorldX(gp.getTileSize()*18);
        gp.getObj()[7].setWorldY(gp.getTileSize()*31);

        gp.getObj()[8] = new OBJ_Door();
        gp.getObj()[8].setWorldX(gp.getTileSize()*17);
        gp.getObj()[8].setWorldY(gp.getTileSize()*31);

        //3
        gp.getNpc()[7] = new Snow(gp);
        gp.getNpc()[7].setWorldX(gp.getTileSize()*29);
        gp.getNpc()[7].setWorldY(gp.getTileSize()*26);

        gp.getFire()[0] = new SnowBall(gp,26,20,"up");
        gp.getFire()[0].setWorldX(gp.getTileSize()*29);
        gp.getFire()[0].setWorldY(gp.getTileSize()*26);

        gp.getFire()[1] = new SnowBall(gp,29,45,"right");
        gp.getFire()[1].setWorldX(gp.getTileSize()*29);
        gp.getFire()[1].setWorldY(gp.getTileSize()*26);

        gp.getFire()[2] = new SnowBall(gp,29,23,"left");
        gp.getFire()[2].setWorldX(gp.getTileSize()*29);
        gp.getFire()[2].setWorldY(gp.getTileSize()*26);

        gp.getFire()[3] = new SnowBall(gp,26,29,"down");
        gp.getFire()[3].setWorldX(gp.getTileSize()*29);
        gp.getFire()[3].setWorldY(gp.getTileSize()*26);



        gp.getNpc()[8] = new Snow(gp);
        gp.getNpc()[8].setWorldX(gp.getTileSize()*41);
        gp.getNpc()[8].setWorldY(gp.getTileSize()*25);

        gp.getFire()[4] = new SnowBall(gp,25,22,"up");
        gp.getFire()[4].setWorldX(gp.getTileSize()*41);
        gp.getFire()[4].setWorldY(gp.getTileSize()*25);

        gp.getFire()[5] = new SnowBall(gp,41,45,"right");
        gp.getFire()[5].setWorldX(gp.getTileSize()*41);
        gp.getFire()[5].setWorldY(gp.getTileSize()*25);

        gp.getFire()[6] = new SnowBall(gp,41,23,"left");
        gp.getFire()[6].setWorldX(gp.getTileSize()*41);
        gp.getFire()[6].setWorldY(gp.getTileSize()*25);

        gp.getFire()[7] = new SnowBall(gp,25,29,"down");
        gp.getFire()[7].setWorldX(gp.getTileSize()*41);
        gp.getFire()[7].setWorldY(gp.getTileSize()*25);

        gp.getObj()[10] = new SpecialKey();
        gp.getObj()[10].setWorldX(gp.getTileSize()*32);
        gp.getObj()[10].setWorldY(gp.getTileSize()*27);

        gp.getObj()[11] = new OBJ_Door();
        gp.getObj()[11].setWorldX(gp.getTileSize()*48);
        gp.getObj()[11].setWorldY(gp.getTileSize()*34);

        gp.getObj()[12] = new OBJ_Door();
        gp.getObj()[12].setWorldX(gp.getTileSize()*48);
        gp.getObj()[12].setWorldY(gp.getTileSize()*35);

        gp.getObj()[13] = new OBJ_Door();
        gp.getObj()[13].setWorldX(gp.getTileSize()*48);
        gp.getObj()[13].setWorldY(gp.getTileSize()*36);

        gp.getObj()[14] = new OBJ_Door();
        gp.getObj()[14].setWorldX(gp.getTileSize()*48);
        gp.getObj()[14].setWorldY(gp.getTileSize()*37);

        gp.getObj()[15] = new OBJ_Door();
        gp.getObj()[15].setWorldX(gp.getTileSize()*48);
        gp.getObj()[15].setWorldY(gp.getTileSize()*38);

        gp.getObj()[16] = new OBJ_Door();
        gp.getObj()[16].setWorldX(gp.getTileSize()*48);
        gp.getObj()[16].setWorldY(gp.getTileSize()*39);

        gp.getObj()[17] = new OBJ_Door();
        gp.getObj()[17].setWorldX(gp.getTileSize()*48);
        gp.getObj()[17].setWorldY(gp.getTileSize()*40);

        gp.getObj()[18] = new OBJ_Door();
        gp.getObj()[18].setWorldX(gp.getTileSize()*48);
        gp.getObj()[18].setWorldY(gp.getTileSize()*41);

        gp.getObj()[19] = new OBJ_Door();
        gp.getObj()[19].setWorldX(gp.getTileSize()*48);
        gp.getObj()[19].setWorldY(gp.getTileSize()*42);

        gp.getObj()[20] = new OBJ_Door();
        gp.getObj()[20].setWorldX(gp.getTileSize()*48);
        gp.getObj()[20].setWorldY(gp.getTileSize()*41);

        gp.getObj()[21] = new OBJ_Chest();
        gp.getObj()[21].setWorldX(gp.getTileSize()*44);
        gp.getObj()[21].setWorldY(gp.getTileSize()*48);

        //4
        gp.getObj()[22] = new OBJ_Chest();
        gp.getObj()[22].setWorldX(gp.getTileSize()*38);
        gp.getObj()[22].setWorldY(gp.getTileSize()*42);

        gp.getObj()[23] = new OBJ_Door();
        gp.getObj()[23].setWorldX(gp.getTileSize()*32);
        gp.getObj()[23].setWorldY(gp.getTileSize()*37);

        gp.getObj()[24] = new OBJ_Key();
        gp.getObj()[24].setWorldX(gp.getTileSize()*1);
        gp.getObj()[24].setWorldY(gp.getTileSize()*42);

        //test
        gp.getObj()[9] = null;
//        gp.obj[9].worldX = gp.getTileSize()*2;
//        gp.obj[9].worldY = gp.getTileSize()*1;

    }
    public void setNPC3() {
        gp.getObj()[0] = new OBJ_Door();
        gp.getObj()[0].setWorldX(gp.getTileSize()*15);
        gp.getObj()[0].setWorldY(gp.getTileSize()*23);

        gp.getObj()[1] = new OBJ_Door();
        gp.getObj()[1].setWorldX(gp.getTileSize()*48);
        gp.getObj()[1].setWorldY(gp.getTileSize()*5);

        gp.getObj()[2] = new OBJ_Key();
        gp.getObj()[2].setWorldX(gp.getTileSize()*5);
        gp.getObj()[2].setWorldY(gp.getTileSize()*20);

        gp.getObj()[3] = new OBJ_Key();
        gp.getObj()[3].setWorldX(gp.getTileSize()*32);
        gp.getObj()[3].setWorldY(gp.getTileSize()*15);

        gp.getObj()[4] = new OBJ_Door();
        gp.getObj()[4].setWorldX(gp.getTileSize()*38);
        gp.getObj()[4].setWorldY(gp.getTileSize()*5);

        gp.getObj()[5] = new OBJ_Key();
        gp.getObj()[5].setWorldX(gp.getTileSize()*42);
        gp.getObj()[5].setWorldY(gp.getTileSize()*13);

        gp.getObj()[6] = new OBJ_Chest();
        gp.getObj()[6].setWorldX(gp.getTileSize()*48);
        gp.getObj()[6].setWorldY(gp.getTileSize()*7);

        gp.getFire()[0] = new Poison(gp,1,4,"right");
        gp.getFire()[0].setWorldX(gp.getTileSize()*1);
        gp.getFire()[0].setWorldY(gp.getTileSize()*5);

        gp.getNpc()[0] = new Scorpia(gp,120);
        gp.getNpc()[0].setWorldX(gp.getTileSize()*1);
        gp.getNpc()[0].setWorldY(gp.getTileSize()*5);

        gp.getNpc()[1] = new Cactus(gp,120);
        gp.getNpc()[1].setWorldX(gp.getTileSize()*3);
        gp.getNpc()[1].setWorldY(gp.getTileSize()*8);

        gp.getNpc()[2] = new Monster1V2(gp,120);
        gp.getNpc()[2].setWorldX(gp.getTileSize()*16);
        gp.getNpc()[2].setWorldY(gp.getTileSize()*21);

        gp.getNpc()[3] = new Monster1V2(gp,120);
        gp.getNpc()[3].setWorldX(gp.getTileSize()*35);
        gp.getNpc()[3].setWorldY(gp.getTileSize()*21);

        gp.getNpc()[4] = new Monster1V2(gp,120);
        gp.getNpc()[4].setWorldX(gp.getTileSize()*20);
        gp.getNpc()[4].setWorldY(gp.getTileSize()*9);

        gp.getObj()[7] = new OBJ_Boots();
        gp.getObj()[7].setWorldX(gp.getTileSize()*48);
        gp.getObj()[7].setWorldY(gp.getTileSize()*6);

//        gp.getObj()[8] = new OBJ_Chest();
//        gp.getObj()[8].setWorldX(gp.getTileSize()*2);
//        gp.getObj()[8].setWorldY(gp.getTileSize()*3);
//
//        gp.getObj()[9] = new OBJ_Boots();
//        gp.getObj()[9].setWorldX(gp.getTileSize()*1);
//        gp.getObj()[9].setWorldY(gp.getTileSize()*3);
    }

    public void miniGame(){
        eTime++;
        cTime++;
        if(eTime == 1) {
            gp.getAlert()[0] = null;
//            gp.getAlert()[0].setWorldX(gp.getTileSize()*16);
//            gp.getAlert()[0].setWorldY( gp.getTileSize()*29);

            gp.getAlert()[1] = null;
//            gp.getAlert()[1].setWorldX(gp.getTileSize()*16);
//            gp.getAlert()[1].setWorldY(gp.getTileSize()*31);

            gp.getAlert()[2] = null;

            gp.getAlert()[3] = new AlertTile(gp);
            gp.getAlert()[3].setWorldX(gp.getTileSize()*16);
            gp.getAlert()[3].setWorldY(gp.getTileSize()*35);

            gp.getAlert()[4] = new AlertTile(gp);
            gp.getAlert()[4].setWorldX(gp.getTileSize()*16);
            gp.getAlert()[4].setWorldY(gp.getTileSize()*37);
        }
        else if(eTime == 2){
            gp.getAlert()[5] = new AlertTile(gp);
            gp.getAlert()[5].setWorldX(gp.getTileSize()*16);
            gp.getAlert()[5].setWorldY(gp.getTileSize()*39);

            gp.getAlert()[6] = new AlertTile(gp);
            gp.getAlert()[6].setWorldX(gp.getTileSize()*16);
            gp.getAlert()[6].setWorldY(gp.getTileSize()*41) ;

            gp.getAlert()[7] = new AlertTile(gp);
            gp.getAlert()[7].setWorldX(gp.getTileSize()*16);
            gp.getAlert()[7].setWorldY(gp.getTileSize()*43) ;
        }
        else if(eTime == 60){
            gp.getAlert()[2] = null;
            gp.getAlert()[3] = null;
            gp.getAlert()[4] = null;
            gp.getAlert()[5] = null;
            gp.getAlert()[6] = null;
            gp.getAlert()[7] = null;


            gp.getFire()[3] = new StrawBall(gp,16,34,"right",5,true);
            gp.getFire()[3].setWorldX(gp.getTileSize()*16);
            gp.getFire()[3].setWorldY(gp.getTileSize()*35);

            gp.getFire()[4] = new StrawBall(gp,16,34,"right",5,true);
            gp.getFire()[4].setWorldX(gp.getTileSize()*16);
            gp.getFire()[4].setWorldY(gp.getTileSize()*37);
        }else if(eTime == 61){
            gp.getFire()[5] = new StrawBall(gp,16,34,"right",5,true);
            gp.getFire()[5].setWorldX(gp.getTileSize()*16);
            gp.getFire()[5].setWorldY(gp.getTileSize()*39);

            gp.getFire()[6] = new StrawBall(gp,16,34,"right",5,true);
            gp.getFire()[6].setWorldX(gp.getTileSize()*16);
            gp.getFire()[6].setWorldY(gp.getTileSize()*41);

            gp.getFire()[7] = new StrawBall(gp,16,34,"right",5,true);
            gp.getFire()[7].setWorldX(gp.getTileSize()*16);
            gp.getFire()[7].setWorldY(gp.getTileSize()*43);
        }
        else if(eTime == 230){
            gp.getFire()[3] = null;
            gp.getFire()[4] = null;
            gp.getFire()[5] = null;
            gp.getFire()[6] = null;
            gp.getFire()[7] = null;

            gp.getAlert()[0] = null;

            gp.getAlert()[1] = null;

            gp.getAlert()[2] = new AlertTile(gp);
            gp.getAlert()[2].setWorldX(gp.getTileSize()*22);
            gp.getAlert()[2].setWorldY(gp.getTileSize()*43);

            gp.getAlert()[3] = new AlertTile(gp);
            gp.getAlert()[3].setWorldX(gp.getTileSize()*23);
            gp.getAlert()[3].setWorldY(gp.getTileSize()*43);

        }else if(eTime == 231){
            gp.getAlert()[4] = new AlertTile(gp);
            gp.getAlert()[4].setWorldX(gp.getTileSize()*24);
            gp.getAlert()[4].setWorldY(gp.getTileSize()*43);

            gp.getAlert()[5] = new AlertTile(gp);
            gp.getAlert()[5].setWorldX(gp.getTileSize()*25);
            gp.getAlert()[5].setWorldY(gp.getTileSize()*43);

            gp.getAlert()[6] = new AlertTile(gp);
            gp.getAlert()[6].setWorldX(gp.getTileSize()*26);
            gp.getAlert()[6].setWorldY(gp.getTileSize()*43);

            gp.getAlert()[7] = new AlertTile(gp);
            gp.getAlert()[7].setWorldX(gp.getTileSize()*27);
            gp.getAlert()[7].setWorldY(gp.getTileSize()*43);
        }
        else if(eTime == 290) {
            gp.getAlert()[2] = null;
            gp.getAlert()[3] = null;
            gp.getAlert()[4] = null;
            gp.getAlert()[5] = null;
            gp.getAlert()[6] = null;
            gp.getAlert()[7] = null;
            gp.getFire()[0] = null;

            gp.getFire()[1] = null;

            gp.getFire()[2] = new StrawBall(gp,  43,29,"up",5,false);
            gp.getFire()[2].setWorldX(gp.getTileSize()*22);
            gp.getFire()[2].setWorldY(gp.getTileSize()*43);

            gp.getFire()[3] = new StrawBall(gp,  43,29,"up",5,false);
            gp.getFire()[3].setWorldX(gp.getTileSize()*23);
            gp.getFire()[3].setWorldY(gp.getTileSize()*43);
        }else if(eTime == 291){
            gp.getFire()[4] = new StrawBall(gp,  43,29,"up",5,false);
            gp.getFire()[4].setWorldX(gp.getTileSize()*24);
            gp.getFire()[4].setWorldY(gp.getTileSize()*43);

            gp.getFire()[5] = new StrawBall(gp,  43,29,"up",5,false);
            gp.getFire()[5].setWorldX(gp.getTileSize()*25);
            gp.getFire()[5].setWorldY(gp.getTileSize()*43);

        }else if(eTime == 292){
            gp.getFire()[6] = new StrawBall(gp,  43,29,"up",5,false);
            gp.getFire()[6].setWorldX(gp.getTileSize()*26);
            gp.getFire()[6].setWorldY(gp.getTileSize()*43);

            gp.getFire()[7] = new StrawBall(gp,  43,29,"up",5,false);
            gp.getFire()[7].setWorldX(gp.getTileSize()*27);
            gp.getFire()[7].setWorldY(gp.getTileSize()*43);
        }
        else if(eTime == 410) {
            for(int i = 0;i<30;i++) {
                if(gp.getFire()[i] != null )gp.getFire()[i] = null;
            }
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getTileSize()*30);
            gp.getAlert()[0].setWorldY(gp.getTileSize()*30);

            gp.getAlert()[1] = new AlertTile(gp);
            gp.getAlert()[1].setWorldX(gp.getTileSize()*31);
            gp.getAlert()[1].setWorldY(gp.getTileSize()*30);

            gp.getAlert()[2] = new AlertTile(gp);
            gp.getAlert()[2].setWorldX(gp.getTileSize()*32);
            gp.getAlert()[2].setWorldY(gp.getTileSize()*30);

            gp.getAlert()[3] = new AlertTile(gp);
            gp.getAlert()[3].setWorldX(gp.getTileSize()*33);
            gp.getAlert()[3].setWorldY(gp.getTileSize()*30);

            gp.getAlert()[4] = new AlertTile(gp);
            gp.getAlert()[4].setWorldX(gp.getTileSize()*34);
            gp.getAlert()[4].setWorldY(gp.getTileSize()*30);

        }else if(eTime == 411){
            gp.getAlert()[5] = new AlertTile(gp);
            gp.getAlert()[5].setWorldX(gp.getTileSize()*30);
            gp.getAlert()[5].setWorldY(gp.getTileSize()*31);

            gp.getAlert()[6] = new AlertTile(gp);
            gp.getAlert()[6].setWorldX(gp.getTileSize()*31);
            gp.getAlert()[6].setWorldY(gp.getTileSize()*31);

            gp.getAlert()[7] = new AlertTile(gp);
            gp.getAlert()[7].setWorldX(gp.getTileSize()*32);
            gp.getAlert()[7].setWorldY(gp.getTileSize()*31);

            gp.getAlert()[8] = new AlertTile(gp);
            gp.getAlert()[8].setWorldX(gp.getTileSize()*33);
            gp.getAlert()[8].setWorldY(gp.getTileSize()*31);
        }else if(eTime == 412){
            gp.getAlert()[9] = new AlertTile(gp);
            gp.getAlert()[9].setWorldX(gp.getTileSize()*34);
            gp.getAlert()[9].setWorldY(gp.getTileSize()*31);

            gp.getAlert()[10] = new AlertTile(gp);
            gp.getAlert()[10].setWorldX(gp.getTileSize()*30);
            gp.getAlert()[10].setWorldY(gp.getTileSize()*40);

            gp.getAlert()[11] = new AlertTile(gp);
            gp.getAlert()[11].setWorldX(gp.getTileSize()*31);
            gp.getAlert()[11].setWorldY(gp.getTileSize()*40);

            gp.getAlert()[12] = new AlertTile(gp);
            gp.getAlert()[12].setWorldX(gp.getTileSize()*32);
            gp.getAlert()[12].setWorldY(gp.getTileSize()*40);

            gp.getAlert()[13] = new AlertTile(gp);
            gp.getAlert()[13].setWorldX(gp.getTileSize()*33);
            gp.getAlert()[13].setWorldY(gp.getTileSize()*40);
        }else if(eTime == 413){
            gp.getAlert()[14] = new AlertTile(gp);
            gp.getAlert()[14].setWorldX(gp.getTileSize()*34);
            gp.getAlert()[14].setWorldY(gp.getTileSize()*40);

            gp.getAlert()[15] = new AlertTile(gp);
            gp.getAlert()[15].setWorldX(gp.getTileSize()*30);
            gp.getAlert()[15].setWorldY(gp.getTileSize()*41);

            gp.getAlert()[16] = new AlertTile(gp);
            gp.getAlert()[16].setWorldX(gp.getTileSize()*31);
            gp.getAlert()[16].setWorldY(gp.getTileSize()*41);

        }else if(eTime == 414){
            gp.getAlert()[17] = new AlertTile(gp);
            gp.getAlert()[17].setWorldX(gp.getTileSize()*32);
            gp.getAlert()[17].setWorldY(gp.getTileSize()*41);

            gp.getAlert()[18] = new AlertTile(gp);
            gp.getAlert()[18].setWorldX(gp.getTileSize()*33);
            gp.getAlert()[18].setWorldY(gp.getTileSize()*41);

            gp.getAlert()[19] = new AlertTile(gp);
            gp.getAlert()[19].setWorldX(gp.getTileSize()*34);
            gp.getAlert()[19].setWorldY(gp.getTileSize()*41);
        }
        else if(eTime == 470) {
            for(int i = 0;i<30;i++) {
                if(gp.getAlert()[i]!=null) gp.getAlert()[i] = null;
            }
            gp.getFire()[0] = new StrawBall(gp,  34,16,"left",7,false);
            gp.getFire()[0].setWorldX(gp.getTileSize()*34);
            gp.getFire()[0].setWorldY(gp.getTileSize()*30);

            gp.getFire()[1] = new StrawBall(gp,  34,16,"left",7,false);
            gp.getFire()[1].setWorldX(gp.getTileSize()*34);
            gp.getFire()[1].setWorldY(gp.getTileSize()*31);

            gp.getFire()[2] = new StrawBall(gp,  30,43,"down",7,false);
            gp.getFire()[2].setWorldX(gp.getTileSize()*30);
            gp.getFire()[2].setWorldY(gp.getTileSize()*30);
        }else if(eTime == 471){
            gp.getFire()[3] = new StrawBall(gp,  30,43,"down",7,false);
            gp.getFire()[3].setWorldX(gp.getTileSize()*31);
            gp.getFire()[3].setWorldY(gp.getTileSize()*30);

            gp.getFire()[4] = new StrawBall(gp,  30,43,"down",7,false);
            gp.getFire()[4].setWorldX(gp.getTileSize()*32);
            gp.getFire()[4].setWorldY(gp.getTileSize()*30);
        }else if(eTime == 472){
            gp.getFire()[5] = new StrawBall(gp,  30,43,"down",7,false);
            gp.getFire()[5].setWorldX(gp.getTileSize()*33);
            gp.getFire()[5].setWorldY(gp.getTileSize()*30);

            gp.getFire()[6] = new StrawBall(gp,  30,43,"down",7,false);
            gp.getFire()[6].setWorldX(gp.getTileSize()*34);
            gp.getFire()[6].setWorldY(gp.getTileSize()*30);
        }else if(eTime == 473){
            gp.getFire()[7] = new StrawBall(gp,  34,16,"left",7,false);
            gp.getFire()[7].setWorldX(gp.getTileSize()*34);
            gp.getFire()[7].setWorldY(gp.getTileSize()*40);

            gp.getFire()[8] = new StrawBall(gp,  34,16,"left",7,false);
            gp.getFire()[8].setWorldX(gp.getTileSize()*34);
            gp.getFire()[8].setWorldY(gp.getTileSize()*41);
        }else if(eTime == 474){
            gp.getFire()[9] = new StrawBall(gp,  43,29,"up",7,false);
            gp.getFire()[9].setWorldX(gp.getTileSize()*31);
            gp.getFire()[9].setWorldY(gp.getTileSize()*43);

            gp.getFire()[10] = new StrawBall(gp,  43,29,"up",7,false);
            gp.getFire()[10].setWorldX(gp.getTileSize()*32);
            gp.getFire()[10].setWorldY(gp.getTileSize()*43);
        }else if(eTime == 475){
            gp.getFire()[11] = new StrawBall(gp,  43,29,"up",7,false);
            gp.getFire()[11].setWorldX(gp.getTileSize()*33);
            gp.getFire()[11].setWorldY(gp.getTileSize()*43);

            gp.getFire()[12] = new StrawBall(gp,  43,29,"up",7,false);
            gp.getFire()[12].setWorldX(gp.getTileSize()*34);
            gp.getFire()[12].setWorldY(gp.getTileSize()*43);

            gp.getFire()[13] = new StrawBall(gp,  43,29,"up",7,false);
            gp.getFire()[13].setWorldX(gp.getTileSize()*30);
            gp.getFire()[13].setWorldY(gp.getTileSize()*43);
        }
        else if(eTime == 590){
            gp.getFire()[0] = null;
            gp.getFire()[1] = null;
            gp.getFire()[2] = null;
            gp.getFire()[3] = null;
            gp.getFire()[4] = null;
            gp.getFire()[5] = null;
            gp.getFire()[6] = null;
            gp.getFire()[7] = null;
            gp.getFire()[8] = null;
            gp.getFire()[9] = null;
            gp.getFire()[10] = null;
            gp.getFire()[11] = null;
            gp.getFire()[12] = null;
            gp.getFire()[13] = null;
        }
        if(eTime == 1000){
            eTime = 0;
        }
        if(cTime == 590) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getTileSize()*24);
            gp.getAlert()[0].setWorldY(gp.getTileSize()*35);

            gp.getAlert()[1] = new AlertTile(gp);
            gp.getAlert()[1].setWorldX(gp.getTileSize()*25);
            gp.getAlert()[1].setWorldY(gp.getTileSize()*35);
        }else if(cTime == 650){
            gp.getAlert()[0] = null;
            gp.getAlert()[1] = null;
            gp.getNpc()[0] = new Demon(gp,80);
            gp.getNpc()[0].setWorldX(24* gp.getTileSize());
            gp.getNpc()[0].setWorldY(gp.getTileSize()*35);

            gp.getNpc()[1] = new Demon(gp,80);
            gp.getNpc()[1].setWorldX(25* gp.getTileSize());
            gp.getNpc()[1].setWorldY(gp.getTileSize()*35);
        }else if(cTime == 950) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getTileSize()*28);
            gp.getAlert()[0].setWorldY(gp.getTileSize()*36);

            gp.getAlert()[1] = new AlertTile(gp);
            gp.getAlert()[1].setWorldX(gp.getTileSize()*28);
            gp.getAlert()[1].setWorldY(gp.getTileSize()*37);
        }else if(cTime == 1100) {
            gp.getAlert()[0] = null;
            gp.getAlert()[1] = null;
            gp.getNpc()[2] = new Monster1V2(gp,120);
            gp.getNpc()[2].setWorldX(gp.getTileSize()*28);
            gp.getNpc()[2].setWorldY(36* gp.getTileSize());

            gp.getNpc()[3] = new Monster1V2(gp,120);
            gp.getNpc()[3].setWorldX(gp.getTileSize()*28);
            gp.getNpc()[3].setWorldY(gp.getTileSize()*37);
        }else if(cTime == 1400) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getTileSize()*18);
            gp.getAlert()[0].setWorldY(gp.getTileSize()*29);

            gp.getAlert()[1] = new AlertTile(gp);
            gp.getAlert()[1].setWorldX(gp.getTileSize()*18);
            gp.getAlert()[1].setWorldY(gp.getTileSize()*43);

            gp.getAlert()[2] = new AlertTile(gp);
            gp.getAlert()[2].setWorldX(gp.getTileSize()*32);
            gp.getAlert()[2].setWorldY(gp.getTileSize()*29);

            gp.getAlert()[3] = new AlertTile(gp);
            gp.getAlert()[3].setWorldX(gp.getTileSize()*32);
            gp.getAlert()[3].setWorldY(gp.getTileSize()*43);
        }else if(cTime == 1460) {
            gp.getAlert()[0] = null;
            gp.getAlert()[1] = null;
            gp.getAlert()[2] = null;
            gp.getAlert()[3] = null;

            gp.getNpc()[4] = new Bird(gp,30,10);
            gp.getNpc()[4].setWorldX(gp.getTileSize()*18);
            gp.getNpc()[4].setWorldY(gp.getTileSize()*29);

            gp.getNpc()[5] = new Bird(gp,30,10);
            gp.getNpc()[5].setWorldX(gp.getTileSize()*18);
            gp.getNpc()[5].setWorldY(gp.getTileSize()*43);

            gp.getNpc()[6] = new Bird(gp,30,10);
            gp.getNpc()[6].setWorldX(gp.getTileSize()*32);
            gp.getNpc()[6].setWorldY(gp.getTileSize()*29);

            gp.getNpc()[7] = new Bird(gp,30,10);
            gp.getNpc()[7].setWorldX(gp.getTileSize()*32);
            gp.getNpc()[7].setWorldY(gp.getTileSize()*43);
        }else if(cTime == 1560) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }
        else if(cTime == 1620) {
            gp.getNpc()[8] = new Snow(gp);
            gp.getNpc()[8].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[8].setWorldY(gp.getAlert()[0].getWorldY());

        } else if(cTime == 1621) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 1720) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 1800) {
            gp.getNpc()[9] = new Snow(gp);
            gp.getNpc()[9].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[9].setWorldY(gp.getAlert()[0].getWorldY());
        }else if(cTime == 1801) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 1900) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 1960) {
            gp.getNpc()[10] = new Snow(gp);
            gp.getNpc()[10].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[10].setWorldY(gp.getAlert()[0].getWorldY());

        }else if(cTime == 1961) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 2060) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 2120) {
            gp.getNpc()[11] = new Snow(gp);
            gp.getNpc()[11].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[11].setWorldY(gp.getAlert()[0].getWorldY());

        }else if(cTime == 2121) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 2220) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 2280) {

        }else if(cTime == 2281) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 2380) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 2440) {
            gp.getNpc()[13] = new Snow(gp);
            gp.getNpc()[13].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[13].setWorldY(gp.getAlert()[0].getWorldY());

        }else if(cTime == 2441) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 2540) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 2640) {
            gp.getNpc()[14] = new Snow(gp);
            gp.getNpc()[14].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[14].setWorldY(gp.getAlert()[0].getWorldY());

        }else if(cTime == 2641) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 2740) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 2800) {
            gp.getNpc()[15] = new Snow(gp);
            gp.getNpc()[15].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[15].setWorldY(gp.getAlert()[0].getWorldY());
        }else if(cTime == 2801) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 2900) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 2960) {
            gp.getNpc()[15] = new Snow(gp);
            gp.getNpc()[15].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[15].setWorldY(gp.getAlert()[0].getWorldY());
        }else if(cTime == 2961) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 3060) {
            gp.getAlert()[0] = new AlertTile(gp);
            gp.getAlert()[0].setWorldX(gp.getPlayer().getWorldX());
            gp.getAlert()[0].setWorldY(gp.getPlayer().getWorldY());
        }else if(cTime == 3120) {
            gp.getNpc()[16] = new Snow(gp);
            gp.getNpc()[16].setWorldX(gp.getAlert()[0].getWorldX());
            gp.getNpc()[16].setWorldY(gp.getAlert()[0].getWorldY());
        }else if(cTime == 3121) {
            gp.getAlert()[0] = null;
        }
        else if(cTime == 3600){
            setEndMiniGame(true);
            resetMap();
            gp.getObj()[0] = new OBJ_Chest();
            gp.getObj()[0].setWorldX(25*gp.getTileSize());
            gp.getObj()[0].setWorldY(36*gp.getTileSize());
        }
    }
    public void setNPC4() {
        gp.getObj()[0] = new OBJ_Key();
        gp.getObj()[0].setWorldX(4*gp.getTileSize());
        gp.getObj()[0].setWorldY(10*gp.getTileSize());

        gp.getObj()[1] = new OBJ_Chest();
        gp.getObj()[1].setWorldX(16*gp.getTileSize());
        gp.getObj()[1].setWorldY(5*gp.getTileSize());

        gp.getObj()[2] = new OBJ_Key();
        gp.getObj()[2].setWorldX(46*gp.getTileSize());
        gp.getObj()[2].setWorldY(27*gp.getTileSize());

        gp.getObj()[3] = new OBJ_Key();
        gp.getObj()[3].setWorldX(7*gp.getTileSize());
        gp.getObj()[3].setWorldY(42*gp.getTileSize());

        gp.getObj()[4] = new OBJ_Door();
        gp.getObj()[4].setWorldX(29*gp.getTileSize());
        gp.getObj()[4].setWorldY(40*gp.getTileSize());

        gp.getObj()[5] = new OBJ_Door();
        gp.getObj()[5].setWorldX(42*gp.getTileSize());
        gp.getObj()[5].setWorldY(42*gp.getTileSize());

        gp.getObj()[6] = new OBJ_Door();
        gp.getObj()[6].setWorldX(16*gp.getTileSize());
        gp.getObj()[6].setWorldY(4*gp.getTileSize());

        gp.getObj()[7] = new OBJ_getBoat();
        gp.getObj()[7].setWorldX(39*gp.getTileSize());
        gp.getObj()[7].setWorldY(11*gp.getTileSize());

        gp.getObj()[8] = new OBJ_getBoat();
        gp.getObj()[8].setWorldX(14*gp.getTileSize());
        gp.getObj()[8].setWorldY(23*gp.getTileSize());

        gp.getObj()[9] = new OBJ_getBoat();
        gp.getObj()[9].setWorldX(39*gp.getTileSize());
        gp.getObj()[9].setWorldY(26*gp.getTileSize());

        gp.getObj()[10] = new OBJ_getBoat();
        gp.getObj()[10].setWorldX(8*gp.getTileSize());
        gp.getObj()[10].setWorldY(37*gp.getTileSize());

        gp.getObj()[11] = new OBJ_getBoat();
        gp.getObj()[11].setWorldX(30*gp.getTileSize());
        gp.getObj()[11].setWorldY(40*gp.getTileSize());

        gp.getObj()[12] = new OBJ_Cat();
        gp.getObj()[12].setWorldX(46*gp.getTileSize());
        gp.getObj()[12].setWorldY(37*gp.getTileSize());

        gp.getObj()[13] = new OBJ_Helicopter();
        gp.getObj()[13].setWorldX(3*gp.getTileSize());
        gp.getObj()[13].setWorldY(16*gp.getTileSize());
    }
    public void resetMap(){
        for(int i = 0;i<gp.getObj().length;i++){
            gp.getObj()[i] = null;
        }
        for(int i = 0;i<gp.getDragon().length;i++){
            gp.getDragon()[i] = null;
            gp.getFire()[i] = null;
        }
        for(int i = 0;i<gp.getDecor().length;i++){
            gp.getDecor()[i] = null;
        }
        for(int i = 0;i<gp.getObj().length;i++){
            gp.getObj()[i] = null;
        }
        for(int i = 0;i<gp.getNpc().length;i++){
            gp.getNpc()[i] = null;
        }
        for(int i = 0;i<gp.getNpc().length;i++){
            gp.getAlert()[i] = null;
        }
    }
}
