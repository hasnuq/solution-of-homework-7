import java.util.Iterator;

class BingeIterator implements EpisodeIterator {
    private Iterator<Season> seasonIterator;
    private EpisodeIterator currentEpisodeIterator;

    public BingeIterator(Series series) {
        this.seasonIterator = series.getSeasons().iterator();
        this.currentEpisodeIterator = getNextSeasonIterator();
    }

    private EpisodeIterator getNextSeasonIterator() {
        while (seasonIterator.hasNext()) {
            Season nextSeason = seasonIterator.next();
            EpisodeIterator it = new SeasonIterator(nextSeason);
            if (it.hasNext()) return it;
        }
        return null;
    }

    public boolean hasNext() {
        if (currentEpisodeIterator == null) return false;
        if (currentEpisodeIterator.hasNext()) return true;
        currentEpisodeIterator = getNextSeasonIterator();
        return currentEpisodeIterator != null && currentEpisodeIterator.hasNext();
    }

    public Episode next() {
        return currentEpisodeIterator.next();
    }
}
