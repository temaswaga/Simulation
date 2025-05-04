public class Dog extends Creature {
    public final static String DOG_SYMBOL = "\uD83D\uDC36";

    @Override
    public String toString() {
        return DOG_SYMBOL;
    }

    @Override
    public int getSpeed(Creature creature) {
        return 1;
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
