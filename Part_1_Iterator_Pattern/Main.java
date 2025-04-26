package Part_1_Iterator_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create episodes
        Episode e1 = new Episode("Episode 1", 1200);
        Episode e2 = new Episode("Episode 2", 1300);
        Episode e3 = new Episode("Episode 3", 1100);
        Episode e4 = new Episode("Episode 4", 1250);
        Episode e5 = new Episode("Episode 5", 1350);

        // Create seasons
        Season season1 = new Season();
        season1.addEpisode(e1);
        season1.addEpisode(e2);
        season1.addEpisode(e3);

        Season season2 = new Season();
        season2.addEpisode(e4);
        season2.addEpisode(e5);

        // Binge iterator across multiple seasons
        List<Season> seasons = new ArrayList<>();
        seasons.add(season1);
        seasons.add(season2);

        BingeIterator bingeIterator = new BingeIterator(seasons);

        System.out.println("Binge Watch Mode:");
        while (bingeIterator.hasNext()) {
            System.out.println(bingeIterator.next().getTitle());
        }

        // Normal traversal
        System.out.println("\nNormal Order:");
        for (Episode e : season1) {
            System.out.println(e.getTitle());
        }

        // Reverse traversal
        System.out.println("\nReverse Order:");
        EpisodeIterator reverseIterator = season1.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next().getTitle());
        }

        // Shuffle traversal
        System.out.println("\nShuffle Order:");
        EpisodeIterator shuffleIterator = season1.shuffleIterator();
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next().getTitle());
        }
    }
}
