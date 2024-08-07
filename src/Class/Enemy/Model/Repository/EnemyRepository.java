package Class.Enemy.Model.Repository;

import Class.Character.model.entity.Character;
import Class.Enemy.Controller.EnemyController;
import Class.Enemy.Model.Entity.Enemy;
import Class.Player.controller.PlayerControler;
import Class.Player.model.repository.PlayerRepository;
import Class.Superpower.Model.Entity.Superpower;
import Class.Superpower.Model.Repository.SuperpowerRepository;
import Intefaces.Combat;

import java.util.ArrayList;
import java.util.List;

public class EnemyRepository implements Combat {
    public List<Enemy> enemyList;

    public EnemyRepository() {
        enemyList = new ArrayList();
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public void addEnemys(int level) {
        String[] names = new String[3];
        names[0] = "𝕸𝖆𝖙𝖊𝖎𝖈𝖔𝖕𝖚𝖑𝖚𝖘";
        names[1] = "𝕷𝖊𝖎𝖙𝖊𝖘 𝕯𝖚𝖑𝖘𝖚𝖘";
        names[2] = "𝓐𝖘𝖆𝖘𝖆𝖉𝖔𝖑𝖔𝓴𝖚𝖘";
        for (int i = 0; i < 3; i++) {
            if (level == 1) {
                Enemy enemy = new Enemy(names[i], 8, 6);
                this.enemyList.add(enemy);
            } else if (level == 2) {
                Enemy enemy = new Enemy(names[i], 6, 4);
                this.enemyList.add(enemy);
            } else {
                Enemy enemy = new Enemy(names[i], 4, 2);
                this.enemyList.add(enemy);
            }
        }

    }

    public Enemy returnEnemy() {
        for (Enemy e : this.enemyList) {
            if (!e.getDead()) {
                return e;
            } else {
                e = null;

            }
        }
        return null;
    }

    @Override
    public void fight(EnemyController enemyController, PlayerControler playerControler, boolean critico) {
        if (critico) {
            playerControler.returnPlayer().setCurrentHp((playerControler.returnPlayer().getCurrentHp() - enemyController.returnEnemy().getMaxDamage()) + (playerControler.returnPlayer().getArmour()/4) );
            if(playerControler.returnPlayer().getCurrentHp() <= 0) playerControler.returnPlayer().setDead(true);
        } else {
            playerControler.returnPlayer().setCurrentHp((playerControler.returnPlayer().getCurrentHp() - enemyController.returnEnemy().getCurrentDamage()) +(playerControler.returnPlayer().getArmour()/4) );
            if(playerControler.returnPlayer().getCurrentHp() <= 0) playerControler.returnPlayer().setDead(true);
        }

    }

    public boolean upgradeSuperpower(Superpower superpower, SuperpowerRepository superpowerRepository) {

        if (superpower.getId().equals(0)) {
            if (superpower.getLevel() != 5) {
                superpower.setLevel(superpower.getLevel() + 5);
                if (this.returnEnemy().getCurrentDamage() + 5 < this.returnEnemy().getMaxDamage()) {
                    this.returnEnemy().setCurrentDamage(this.returnEnemy().getCurrentDamage() + 5);
                    return true;
                }
            } else {
                return false;
            }
        } else if (superpower.getId().equals(1)) {
            if (superpower.getLevel() != 5) {
                superpower.setLevel(superpower.getLevel() + 1);
                if (this.returnEnemy().getCurrentDamage() + 5 < this.returnEnemy().getMaxDamage()) {
                    this.returnEnemy().setCurrentDamage(this.returnEnemy().getCurrentDamage() + 5);
                    return true;
                }
            } else {
                return false;
            }
        } else if (superpower.getId().equals(2)) {
            if (superpower.getLevel() != 5) {
                superpower.setLevel(superpower.getLevel() + 1);
                if (this.returnEnemy().getCurrentHp() + 10 < this.returnEnemy().getMaxHP()) {
                    this.returnEnemy().setCurrentHp(this.returnEnemy().getCurrentHp() + 10);
                    return true;
                }
            } else {
                return false;
            }
        } else if (superpower.getId().equals(3)) {
            if (superpower.getLevel() != 5) {
                superpower.setLevel(superpower.getLevel() + 1);
                this.returnEnemy().setArmour(this.returnEnemy().getArmour() + 2);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
//    public boolean UseMaxLevel(){
//        // if(this.returnPlayer().superpowerRepository.);
//        for(Superpower s: this.returnEnemy().superpowerRepository.superpowerList){
//
//            if (s.getLevel() == 5) {
//                if (s.getId().equals(0)){
//                    s.setLevel(0);
//                    s.setMaxDamage(s.getMaxDamage() + 5);
//                    System.out.println("entro a fuego");
//                    return true;
//                }
//                if (s.getId().equals(1)){
//                    s.setLevel(0);
//                    s.setMaxDamage(s.getMaxDamage() + 5);
//                    return true;
//                }
//                if (s.getId().equals(2)){
//                    s.setLevel(0);
//                    s.setMaxHP(s.getMaxHP() + 5);
//                    return true;
//                }
//                if (s.getId().equals(3)){
//                    s.setLevel(0);
//                    // tendria que ser automatico cuando quieren pegarle
//                    return true
//                }
//
//            }
//        }
//        return false;
//    }

}
