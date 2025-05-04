public class Cat extends Creature {
    public final static String CAT_SYMBOL = "\uD83D\uDC31" ;

    @Override
    public String toString() {
        return CAT_SYMBOL;
    }

    @Override
    public int getSpeed(Creature creature) {
        return 1;
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
