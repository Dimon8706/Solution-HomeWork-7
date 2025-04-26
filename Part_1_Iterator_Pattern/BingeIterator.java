package Part_1_Iterator_Pattern;

import java.util.Iterator;
import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private EpisodeIterator currentIterator;
    private Iterator<Season> seasonsIterator;
    private EpisodeIterator nextSeasonIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasonsIterator = seasons.iterator();
        if (seasonsIterator.hasNext()) {
            nextSeasonIterator = seasonsIterator.next().iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return nextSeasonIterator.hasNext() || seasonsIterator.hasNext();
    }

    @Override
    public Episode next() {
        if (!nextSeasonIterator.hasNext()) {
            if (seasonsIterator.hasNext()) {
                nextSeasonIterator = seasonsIterator.next().iterator();
            }
        }
        return nextSeasonIterator.next();
    }
}
