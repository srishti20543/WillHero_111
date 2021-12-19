package gui.willhero;

abstract class Weapons {
    private String name;
    private int level;
    private boolean unlocked;
    private int damage;

    Weapons(String name, int damage, int level, boolean unlocked){
        this.name = name;
        this.damage = damage;
        this.level = level;
        this.unlocked = unlocked;
    }

    abstract public void setLevel();
}