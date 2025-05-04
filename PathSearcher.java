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
            Coordinates[] arrayOfFreeNeighboursCords = CoordinatesUtil.freeNeighboursCordsGetter(map, currentCords);
            CoordinatesUtil.cordsInArrayListFromArrayPutter(arrayOfFreeNeighboursCords, notVisitedNodesArray, alreadyVisitedNodesArrayList);
            for (Coordinates arrayOfFreeNeighboursCord : arrayOfFreeNeighboursCords) {
                if (arrayOfFreeNeighboursCord != null && !alreadyVisitedNodesArrayList.contains(arrayOfFreeNeighboursCord)) {
                    parentsMap.put(arrayOfFreeNeighboursCord, currentCords); // EROR IS HERE
                }
            }

            if (CoordinatesUtil.ifThereIsATargetNearlyCordsGetter(map, currentCords, map.getCreature(map.worldMap, cordsOfSubject)) != null ) {
                path.push(CoordinatesUtil.ifThereIsATargetNearlyCordsGetter(map, currentCords, map.getCreature(map.worldMap, cordsOfSubject)));
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
}
