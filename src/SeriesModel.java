public class SeriesModel
{
     String seriesID;
     String seriesName;
     String seriesAge;
     String seriesNumberOfEpisodes;

    public SeriesModel(String seriesID, String seriesName, int seriesAge, int seriesNumberOfEpisodes)
    {
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.seriesAge = String.valueOf(seriesAge);
        this.seriesNumberOfEpisodes = String.valueOf(seriesNumberOfEpisodes);
    }

    public String getSeriesId()
    {
        return seriesID;
    }

    public String getSeriesName()
    {
        return seriesName;
    }

    public String getSeriesAge()
    {
        return seriesAge;
    }

    public String getSeriesNumberOfEpisodes()
    {
        return seriesNumberOfEpisodes;
    }

}
