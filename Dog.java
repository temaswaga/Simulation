public class Dog extends Creature {
    public final static String DOG_SYMBOL = "\uD83D\uDC36";
    private final int speed = 1;

    @Override
    public String toString() {
        return DOG_SYMBOL;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void makeMove(Map map, Coordinates from, Coordinates to) {
        Entity target = map.worldMap.get(to);
        if (target == null || target instanceof Cat) {
            map.worldMap.remove(from);
            map.worldMap.put(to, this);
        }
    }
}
