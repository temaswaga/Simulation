public abstract class Creature extends Entity {
    public abstract int getSpeed(Creature creature);

    public abstract void makeMove(Map map, Coordinates from, Coordinates to);
}
