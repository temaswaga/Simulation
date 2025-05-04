import java.util.ArrayList;

public class CoordinatesUtil {
    public static Coordinates ifThereIsATargetNearlyCordsGetter(Map map, Coordinates checkingCords, Creature creature) {

        int[] oneAndZeroArray = new int[]{1, -1, 0, 0};
        int[] zeroAndOneArray = new int[]{0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            Coordinates cordsOfNeighbour = new Coordinates(checkingCords.getX() + oneAndZeroArray[i], checkingCords.getY() + zeroAndOneArray[i]);

            if (creature instanceof Dog) {
                if (map.getEntity(map.worldMap, cordsOfNeighbour) instanceof Cat) {
                    return cordsOfNeighbour;
                }
            } else if (creature instanceof Cat) {
                if (map.getEntity(map.worldMap, cordsOfNeighbour) instanceof Fish) {
                    return cordsOfNeighbour;
                }
            }
        }
        return null;
    }




    public static Coordinates[] freeNeighboursCordsGetter(Map map, Coordinates currentCords) {
        int[] oneAndZeroArray = new int[]{1, -1, 0, 0};
        int[] zeroAndOneArray = new int[]{0, 0, 1, -1};
        Coordinates[] coordinatesOfFreeNeighbours = new Coordinates[4];

        for (int i = 0; i < 4; i++) {
            Coordinates cordsOfNeighbour = new Coordinates(currentCords.getX() + oneAndZeroArray[i], currentCords.getY() + zeroAndOneArray[i]);

            if (cordsOfNeighbour.getX() < 8 && cordsOfNeighbour.getY() < 8 && cordsOfNeighbour.getY() >= 0 && cordsOfNeighbour.getX() >= 0) { // есть граничные случаи
                if (map.getEntity(map.worldMap, cordsOfNeighbour) == null) {
                    coordinatesOfFreeNeighbours[i] = cordsOfNeighbour;
                }
            }
        }
        return coordinatesOfFreeNeighbours;
    }

    public static void cordsInArrayListFromArrayPutter(Coordinates[] arrayOfCoordinates, ArrayList<Coordinates> notVisitedNodesQueue, ArrayList<Coordinates> alreadyVisitedNodesQueue) {
        for (Coordinates currentCoordinate : arrayOfCoordinates) {
            if (!alreadyVisitedNodesQueue.contains(currentCoordinate) && !notVisitedNodesQueue.contains(currentCoordinate) && currentCoordinate != null)
                notVisitedNodesQueue.add(currentCoordinate);
        }
    }
}
