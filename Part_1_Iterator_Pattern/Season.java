package Part_1_Iterator_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes;

    public Season() {
        this.episodes = new ArrayList<>();
    }

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    @Override
    public EpisodeIterator iterator() {
        return new SeasonIterator(this);
    }


    public List<Episode> getEpisodes() {
        return episodes;
    }

    public EpisodeIterator reverseIterator() {
        return new ReverseSeasonIterator(this);
    }

    public EpisodeIterator shuffleIterator() {
        return new ShuffleSeasonIterator(this);
    }
}
