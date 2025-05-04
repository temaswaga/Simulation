import java.util.*;

public class RoadSearcher {

    public static Stack<Coordinates> pathFinder(Map map, Coordinates cordsOfSubject) {
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

            if (nearlyTargetCordsGetter(map, currentCords, map.getCreature(map.worldMap, cordsOfSubject)) != null ) {
                path.push(nearlyTargetCordsGetter(map, currentCords, map.getCreature(map.worldMap, cordsOfSubject)));
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

    public static Coordinates nearlyTargetCordsGetter(Map map, Coordinates checkingCords, Creature creature) {
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

        public static Coordinates creatureMover(Map map, Coordinates currentCords) {
        if (map.isThereAnEntity(map.worldMap, currentCords)) {
            Entity entity = map.getEntity(map.worldMap, currentCords);
            if (entity instanceof Cat || entity instanceof Dog) {
                Stack<Coordinates> path = RoadSearcher.pathFinder(map, currentCords);
                if (!path.empty()) {
                    map.getCreature(map.worldMap, currentCords).makeMove(map, currentCords, path.peek());
                    return path.peek();
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
