public static void main(String[] args) throws InterruptedException {
    Map map = new Map();
    MapSetter.mapSetter(map);

    for (int l = 0; l < 100; l++) {
        EveryCreatureMover.everyCreatureMover(map);
        Thread.sleep(1000);
    }
}