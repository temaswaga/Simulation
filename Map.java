import java.util.HashMap;
import java.util.Random;

public class Map {
     HashMap<Coordinates, Entity> worldMap = new HashMap<>();

    public boolean isThereAnEntity(HashMap<Coordinates, Entity> map, Coordinates coordinates) {
        return map.get(coordinates) != null;
    }

    public Entity getEntity(HashMap<Coordinates, Entity> map, Coordinates coordinates) {
        return map.get(coordinates);
    }

    public Creature getCreature(HashMap<Coordinates, Entity> map, Coordinates coordinates) {
        return (Creature) map.get(coordinates);
    }
}
