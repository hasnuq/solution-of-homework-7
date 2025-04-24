import java.util.Iterator;
import java.util.List;

class ReverseSeasonIterator implements Iterator<Episode>, EpisodeIterator {
    private List<Episode> episodes;
    private int index;

    public ReverseSeasonIterator(Season season) {
        this.episodes = season.getEpisodes();
        this.index = episodes.size() - 1;
    }

    public boolean hasNext() {
        return index >= 0;
    }

    public Episode next() {
        return episodes.get(index--);
    }
}
