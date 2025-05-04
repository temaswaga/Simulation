import java.util.*;

public class PathSearcher {

    public static Stack<Coordinates> pathSearcher(Map map, Coordinates cordsOfSubject) {
        ArrayList<Coordinates> notVisitedNodesArray = new ArrayList<>();
        ArrayList<Coordinates> alreadyVisitedNodesArrayList = new ArrayList<>();

        Stack<Coordinates> path = new Stack<>();
        HashMap<Coordinates, Coordinates> parentsMap = new HashMap<>();

        if (cordsOfSubject != null) {
            notVisitedNodesArray.add(cordsOfSubject);
        }


        while(!notVisitedNodesArray.isEmpty()) {
            Coordinates currentCords = notVisitedNodesArray.getFirst();
            Coordinates[] arrayOfFreeNeighboursCords = freeNeighboursCordsGetter(map, currentCords);
            cordsInArrayListFromArrayPutter(arrayOfFreeNeighboursCords, notVisitedNodesArray, alreadyVisitedNodesArrayList);
            for (Coordinates arrayOfFreeNeighboursCord : arrayOfFreeNeighboursCords) {
                if (arrayOfFreeNeighboursCord != null && !alreadyVisitedNodesArrayList.contains(arrayOfFreeNeighboursCord)) {
                    parentsMap.put(arrayOfFreeNeighboursCord, currentCords); // EROR IS HERE
                }
            }

            if (ifThereIsATargetNearlyCordsGetter(map, currentCords, map.getCreature(map.worldMap, cordsOfSubject)) != null ) {
                path.push(ifThereIsATargetNearlyCordsGetter(map, currentCords, map.getCreature(map.worldMap, cordsOfSubject)));
                if (!currentCords.equals(cordsOfSubject)) {
                    path.push(currentCords);
                }
                while (!currentCords.equals(cordsOfSubject) && parentsMap.get(currentCords) != cordsOfSubject) {
                        path.push(parentsMap.get(currentCords));
                        currentCords = parentsMap.get(currentCords);
                }
                return path;
            }

            alreadyVisitedNodesArrayList.add(notVisitedNodesArray.getFirst());
            notVisitedNodesArray.removeFirst();

        }
        return path;
    }

    public static Coordinates ifThereIsATargetNearlyCordsGetter(Map map, Coordinates checkingCords, Creature creature) {
        if (map == null || map.worldMap == null || checkingCords == null || creature == null) {
            return null;
        }

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
