import java.util.ArrayList;
import java.util.Scanner;
public class Series
{

    Scanner scanner = new Scanner(System.in);
    ArrayList<SeriesModel> seriesList = new ArrayList<>();
    public void captureSeries()
    {
        {

            System.out.print("Enter the series Id: ");
            String seriesId = scanner.nextLine();
            System.out.print("Enter the series name: ");
            String seriesName = scanner.nextLine();
            System.out.print("Enter the series age restriction: ");
            int seriesAge = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the number of episodes: ");
            int seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());

            if (seriesAge >= 2 && seriesAge <= 18) {
                seriesList.add(new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes));
                System.out.println("Series captured successfully!");
            }
            else
            {
                System.out.println("Please re-enter the series age restriction between 0 and 18.");
            }
        }
    }

    public void searchSeries() {
        System.out.print("Enter the series Id to search: ");
        String searchId = scanner.nextLine();
        System.out.println("----------------------------------------------");
        boolean found = false;
        for (int i = 0; i < seriesList.size(); i++)
        {
            SeriesModel series = seriesList.get(i);
            if (series.getSeriesId().equals(searchId))
            {
                System.out.println("Series with Id: " + searchId + " found!");
                found = true;
                System.out.println("SERIES ID: " + series.getSeriesId());
                System.out.println("SERIES NAME: " + series.getSeriesName());
                System.out.println("SERIES AGE RESTRICTION: " + series.getSeriesAge());
                System.out.println("NUMBER OF EPISODES: " + series.getSeriesNumberOfEpisodes());
                System.out.println("----------------------------------------------");
                break;
            }
        }
        if (!found)
        {
            System.out.println("----------------------------------------------");
            System.out.println("Series with Id: " + searchId + " was not found!");
            System.out.println("----------------------------------------------");
        }
    }

    public void updateSeries()
    {
        System.out.print("Enter the series Id to update: ");
        String updateId = scanner.nextLine();
        for (SeriesModel series : seriesList)
        {
            if (series.getSeriesId().equals(updateId)) {
                System.out.print("Enter the new series name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter the new age restriction (0-18): ");
                int newAgeRestriction = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the new number of episodes: ");
                int newEpisodes = Integer.parseInt(scanner.nextLine());

                if (newAgeRestriction >= 0 && newAgeRestriction <= 18)
                {
                    seriesList.remove(series); // Remove old instance
                    seriesList.add(new SeriesModel(updateId, newName, newAgeRestriction, newEpisodes));
                    System.out.println("----------------------------------------------");
                    System.out.println("Series updated successfully!");
                    System.out.println("----------------------------------------------");
                }
                else
                {
                    System.out.println("Please re-enter the series age restriction between 0 and 18.");
                }
                return;
            }
        }
        System.out.println("Series with series Id: " + updateId + " was not found!");
    }

    public void deleteSeries()
    {
        System.out.print("Enter the series Id to delete: ");
        String deleteId = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(deleteId)) {
                System.out.print("Confirm deletion (y/n): ");
                if (scanner.nextLine().equals("y")) {
                    seriesList.remove(series);
                    System.out.println("----------------------------------------------");
                    System.out.println("Series with series Id: " + deleteId + " was deleted!");
                    System.out.println("----------------------------------------------");
                    return;
                }
                else
                {
                    System.out.println("Going back to main menu...1");
                }
            }
        }
        System.out.println("Series with Id: " + deleteId + " was not found!");
    }

    public void seriesReport()
    {
        for (int i = 0; i < seriesList.size(); i++)
        {
            SeriesModel series = seriesList.get(i);
            System.out.println("Series " + (i + 1));
            System.out.println("----------------------------------------------");
            System.out.println("SERIES ID: " + series.getSeriesId());
            System.out.println("SERIES NAME: " + series.getSeriesName());
            System.out.println("SERIES AGE RESTRICTION: " + series.getSeriesAge());
            System.out.println("NUMBER OF EPISODES: " + series.getSeriesNumberOfEpisodes());
            System.out.println("----------------------------------------------");
        }
    }



    public void exitSeriesApplication()
    {
        System.out.println("Exiting application...");
    }
}
