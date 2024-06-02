package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
        int entityRightWorldX = entity.getWorldX() + entity.getSolidArea().x + entity.getSolidArea().width;
        int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
        int entityBottomWorldY = entity.getWorldY() + entity.getSolidArea().y + entity.getSolidArea().height;

        int entityLeftCol = entityLeftWorldX / gp.getTileSize();
        int entityRightCol = entityRightWorldX / gp.getTileSize();
        int entityTopRow = entityTopWorldY / gp.getTileSize();
        int entityBottomRow = entityBottomWorldY / gp.getTileSize();

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / gp.getTileSize();
                entityBottomRow = entityTopRow;
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / gp.getTileSize();
                entityTopRow = entityBottomRow;
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / gp.getTileSize();
                entityLeftCol = entityRightCol;
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / gp.getTileSize();
                entityRightCol = entityLeftCol;
                break;
        }

        tileNum1 = gp.tileM.getMapTileNum()[gp.getCurrentMap()][entityLeftCol][entityTopRow];
        tileNum2 = gp.tileM.getMapTileNum()[gp.getCurrentMap()][entityRightCol][entityBottomRow];

        entity.setCollisionOn(gp.tileM.getTile()[tileNum1].isCollision() || gp.tileM.getTile()[tileNum2].isCollision());
        entity.setSlowOn(gp.tileM.getTile()[tileNum1].isSlowBlock() || gp.tileM.getTile()[tileNum2].isSlowBlock());
        if(gp.getCurrentMap() == 1){
            entity.setFastOn(gp.tileM.getTile()[tileNum1].isFastBlock() || gp.tileM.getTile()[tileNum2].isFastBlock());
        }else if(gp.getCurrentMap() == 2){
            entity.setLooseHeartOn(gp.tileM.getTile()[tileNum1].isLooseHeartBlock() || gp.tileM.getTile()[tileNum2].isLooseHeartBlock());
        }
    }

    public int checkObject(Entity entity, boolean player){
        int index = 999;
        for(int i = 0; i < gp.getObj().length; i++){
            if(gp.getObj()[i] != null){
                // Get Entity's solid area position
                entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;
                // Get object's solid area position
                gp.getObj()[i].getSolidArea().x = gp.getObj()[i].getWorldX() + gp.getObj()[i].getSolidArea().x;
                gp.getObj()[i].getSolidArea().y = gp.getObj()[i].getWorldY() + gp.getObj()[i].getSolidArea().y;

                switch (entity.direction){
                    case "up":
                        entity.getSolidArea().y -= entity.getSpeed();
                        break;
                    case "down":
                        entity.getSolidArea().y += entity.getSpeed();
                        break;
                    case "right":
                        entity.getSolidArea().x += entity.getSpeed();
                        break;
                    case "left":
                        entity.getSolidArea().x -= entity.getSpeed();
                        break;
                }

                // Check collision after movement
                if(entity.getSolidArea().intersects(gp.getObj()[i].getSolidArea())){
                    if(gp.getObj()[i].isCollision()){
                        entity.setCollisionOn(true);
                    }
                    if(player){
                        index = i;
                    }
                }

                // Reset solidArea positions to defaults
                entity.getSolidArea().x = entity.getSolidAreaDefaultX();
                entity.getSolidArea().y = entity.getSolidAreaDefaultY();
                gp.getObj()[i].getSolidArea().x = gp.getObj()[i].getSolidAreaDefaultX();
                gp.getObj()[i].getSolidArea().y = gp.getObj()[i].getSolidAreaDefaultY();
            }
        }
        return index;
    }
    //NPC or Monster
    public int checkEntity(Entity entity, Entity[] target){
        int index = 999;
        for(int i = 0; i < target.length; i++){
            if(target[i] != null){
                // Get Entity's solid area position
                entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;
                // Get object's solid area position
                target[i].getSolidArea().x = target[i].getWorldX() + target[i].getSolidArea().x;
                target[i].getSolidArea().y = target[i].getWorldY() + target[i].getSolidArea().y;

                switch (entity.direction){
                    case "up":
                        entity.getSolidArea().y -= entity.getSpeed();
                        break;
                    case "down":
                        entity.getSolidArea().y += entity.getSpeed();
                        break;
                    case "right":
                        entity.getSolidArea().x += entity.getSpeed();
                        break;
                    case "left":
                        entity.getSolidArea().x -= entity.getSpeed();
                        break;
                }

                // Check collision after movement
                if(entity.getSolidArea().intersects(target[i].getSolidArea())){
                    entity.setCollisionOn(true);
                    index = i;
                }

                // Reset solidArea positions to defaults
                entity.getSolidArea().x = entity.getSolidAreaDefaultX();
                entity.getSolidArea().y = entity.getSolidAreaDefaultY();
                target[i].getSolidArea().x = target[i].getSolidAreaDefaultX();
                target[i].getSolidArea().y = target[i].getSolidAreaDefaultY();
            }
        }
        return index;
    }
    public void checkPlayer(Entity entity){
        // Get Entity's solid area position
        entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
        entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;
        // Get object's solid area position
        gp.getPlayer().getSolidArea().x = gp.getPlayer().getWorldX() + gp.getPlayer().getSolidArea().x;
        gp.getPlayer().getSolidArea().y = gp.getPlayer().getWorldY() + gp.getPlayer().getSolidArea().y;

        switch (entity.direction){
            case "up":
                entity.getSolidArea().y -= entity.getSpeed();
                break;
            case "down":
                entity.getSolidArea().y += entity.getSpeed();
                break;
            case "right":
                entity.getSolidArea().x += entity.getSpeed();
                break;
            case "left":
                entity.getSolidArea().x -= entity.getSpeed();
                break;
        }

        // Check collision after movement
        if(entity.getSolidArea().intersects(gp.getPlayer().getSolidArea())){
            entity.setCollisionOn(true);
            gp.getPlayer().setHeart(gp.getPlayer().getHeart()-1);
            gp.getPlayer().disableKey();
            gp.getPlayer().setWorldX(gp.getPlayer().getSpawnX());
            gp.getPlayer().setWorldY(gp.getPlayer().getSpawnY());
        }

        // Reset solidArea positions to defaults
        entity.getSolidArea().x = entity.getSolidAreaDefaultX();
        entity.getSolidArea().y = entity.getSolidAreaDefaultY();
        gp.getPlayer().getSolidArea().x = gp.getPlayer().getSolidAreaDefaultX();
        gp.getPlayer().getSolidArea().y = gp.getPlayer().getSolidAreaDefaultY();
    }
}

