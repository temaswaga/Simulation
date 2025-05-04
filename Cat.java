public class Cat extends Creature {
    public final static String CAT_SYMBOL = "\uD83D\uDC31" ;
    private final int speed = 1;

    @Override
    public String toString() {
        return CAT_SYMBOL;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void makeMove(Map map, Coordinates from, Coordinates to) {
        Entity goingToMoveCordsEntity = map.getEntity(map.worldMap , to);
        if (goingToMoveCordsEntity == null || goingToMoveCordsEntity instanceof Fish ) {
            map.worldMap.remove(from);
            map.worldMap.put(to, this);
        }
    }
}
