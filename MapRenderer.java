public class MapRenderer {

    public static void renderer(Map map) {
        System.out.print("0  ");
        for(int i = 0; i < 8; ++i) {
            System.out.print(i + 1 + "  ");
        }

        System.out.print("\n");
        for(int i = 0; i < 8; ++i) {
            System.out.print(i+1 + "  ");

            for(int j = 0; j < 8; ++j) {
                if (map.getEntity(map.worldMap, new Coordinates(i, j)) == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(map.getEntity(map.worldMap, new Coordinates(i, j)) + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}
