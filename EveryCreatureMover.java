import java.util.ArrayList;

public class EveryCreatureMover {

    public static void everyCreatureMover(Map map) {
        MapRenderer.mapRenderer(map);
        ArrayList<Coordinates> alreadyVisitedAtThisIterrationCordinates = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Coordinates currentCords = new Coordinates(i, j);
                if ((map.getEntity(map.worldMap, currentCords) != null) && (map.getEntity(map.worldMap, currentCords) instanceof Dog || map.getEntity(map.worldMap, currentCords) instanceof Cat) && !alreadyVisitedAtThisIterrationCordinates.contains(currentCords)) {
                        alreadyVisitedAtThisIterrationCordinates.add(MoveOriginator.creatureToMoveOriginator(map, currentCords));
                }
            }
        }
    }


}
