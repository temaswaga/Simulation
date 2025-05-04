public class SimulationStarter {

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        MapSetter.mapSetter(map);

        for (int l = 0; l < 100; l++) {
            MapRenderer.mapRenderer(map);
            EveryCreatureMover.everyCreatureMover(map);
            Thread.sleep(1500);
        }
    }
}