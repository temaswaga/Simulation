public abstract class Creature extends Entity {
    public abstract int getSpeed();

    public abstract void makeMove(Map map, Coordinates from, Coordinates to);

    public static boolean isMoveValid(Map map, Coordinates from, Coordinates to) {
        Creature creature = map.getCreature(map.worldMap, from);
        return from.getX() - to.getX() + from.getY() - to.getY() <= creature.getSpeed();
    }
}
