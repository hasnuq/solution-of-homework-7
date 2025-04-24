public class Demo {
    public static void main(String[] args) {
        Series series = new Series();

        Season s1 = new Season();
        s1.addEpisode(new Episode("S1E1", 1200));
        s1.addEpisode(new Episode("S1E2", 1250));

        Season s2 = new Season();
        s2.addEpisode(new Episode("S2E1", 1300));
        s2.addEpisode(new Episode("S2E2", 1350));

        series.addSeason(s1);
        series.addSeason(s2);

        System.out.println("Normal:");
        for (Episode e : s1) {
            System.out.println(e);
        }

        System.out.println("\nReverse:");
        ReverseSeasonIterator reverseIt = new ReverseSeasonIterator(s1);
        while (reverseIt.hasNext()) {
            System.out.println(reverseIt.next());
        }

        System.out.println("\nShuffle:");
        ShuffleSeasonIterator shuffleIt = new ShuffleSeasonIterator(s1, 42);
        while (shuffleIt.hasNext()) {
            System.out.println(shuffleIt.next());
        }

        System.out.println("\nBinge:");
        BingeIterator binge = new BingeIterator(series);
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}
