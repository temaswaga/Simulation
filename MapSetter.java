import java.util.HashMap;
import java.util.Random;

public class MapSetter {

    public static void mapSetter(Map map) {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                Random random = new Random();
                int randomVariable = random.nextInt(1000);
                if (randomVariable < 30) {
                    map.worldMap.put(new Coordinates(i, j), new Dog());
                } else if (randomVariable > 30 && randomVariable < 60) {
                    map.worldMap.put(new Coordinates(i, j), new Cat());
                } else if (randomVariable > 60 && randomVariable < 260) {
                    map.worldMap.put(new Coordinates(i, j), new Tree());
                } else if (randomVariable > 260 && randomVariable < 340) {
                    map.worldMap.put(new Coordinates(i, j), new Fish());
                } else if (randomVariable > 340 && randomVariable < 440) {
                    map.worldMap.put(new Coordinates(i, j), new Rock());
                }
            }
        }
    }
}
