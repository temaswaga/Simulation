import java.util.Stack;

public class MoveOriginator {

    public static Coordinates creatureToMoveOriginator(Map map, Coordinates currentCords) {
        if (map.isThereAnEntity(map.worldMap, currentCords)) {
            Entity entity = map.getEntity(map.worldMap, currentCords);

            if (entity instanceof Cat || entity instanceof Dog) {
                Stack<Coordinates> path = PathSearcher.pathSearcher(map, currentCords);

                if (!path.empty()) {
                    if(Creature.isMoveValid(map, currentCords, path.peek())) {
                        map.getCreature(map.worldMap, currentCords).makeMove(map, currentCords, path.peek());
                        return path.peek();
                    }
                }
            }
        }
        return null;
    }
}
