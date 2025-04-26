package Part_1_Iterator_Pattern;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private Random random;
    private int position;

    public ShuffleSeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
        this.random = new Random(42); // Fixed seed for repeatable results
        Collections.shuffle(episodes, random);
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(position++);
    }
}
