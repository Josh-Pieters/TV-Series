import java.util.ArrayList;
import java.util.Scanner;

public class Series
{
    // Scanner for user input
    Scanner scanner = new Scanner(System.in);
    // ArrayList to store series objects
    ArrayList<SeriesModel> seriesList = new ArrayList<>();

    // Method to capture new series information
    public void captureSeries()
    {
        {
            // Get series details from user
            System.out.print("Enter the series Id: ");
            String seriesId = scanner.nextLine();
            System.out.print("Enter the series name: ");
            String seriesName = scanner.nextLine();
            System.out.print("Enter the series age restriction: ");
            int seriesAge = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the number of episodes: ");
            int seriesNumberOfEpisodes = Integer.parseInt(scanner.nextLine());

            // Validate age restriction
            if (seriesAge >= 2 && seriesAge <= 18) {
                // Add new series to the list
                seriesList.add(new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes));
                System.out.println("Series captured successfully!");
            }
            else
            {
                // Show error message for invalid age
                System.out.println("Please re-enter the series age restriction between 0 and 18.");
            }
        }
    }

    // Method to search for a series by ID
    public void searchSeries() {
        System.out.print("Enter the series Id to search: ");
        String searchId = scanner.nextLine();
        System.out.println("----------------------------------------------");
        boolean found = false;

        // Loop through all series to find matching ID
        for (int i = 0; i < seriesList.size(); i++)
        {
            SeriesModel series = seriesList.get(i);
            if (series.getSeriesId().equals(searchId))
            {
                // Display found series details
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
        // Show message if series not found
        if (!found)
        {
            System.out.println("----------------------------------------------");
            System.out.println("Series with Id: " + searchId + " was not found!");
            System.out.println("----------------------------------------------");
        }
    }

    // Method to update existing series information
    public void updateSeries()
    {
        System.out.print("Enter the series Id to update: ");
        String updateId = scanner.nextLine();

        // Search for series to update
        for (SeriesModel series : seriesList)
        {
            if (series.getSeriesId().equals(updateId)) {
                // Get new details from user
                System.out.print("Enter the new series name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter the new age restriction (0-18): ");
                int newAgeRestriction = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the new number of episodes: ");
                int newEpisodes = Integer.parseInt(scanner.nextLine());

                // Validate new age restriction
                if (newAgeRestriction >= 0 && newAgeRestriction <= 18)
                {
                    // Remove old series and add updated version
                    seriesList.remove(series);
                    seriesList.add(new SeriesModel(updateId, newName, newAgeRestriction, newEpisodes));
                    System.out.println("----------------------------------------------");
                    System.out.println("Series updated successfully!");
                    System.out.println("----------------------------------------------");
                }
                else
                {
                    // Show error for invalid age
                    System.out.println("Please re-enter the series age restriction between 0 and 18.");
                }
                return;
            }
        }
        // Show message if series not found
        System.out.println("Series with series Id: " + updateId + " was not found!");
    }

    // Method to delete a series
    public void deleteSeries()
    {
        System.out.print("Enter the series Id to delete: ");
        String deleteId = scanner.nextLine();

        // Search for series to delete
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(deleteId)) {
                // Ask for confirmation before deleting
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
                    // Cancel deletion if user says no
                    System.out.println("Going back to main menu...1");
                }
            }
        }
        // Show message if series not found
        System.out.println("Series with Id: " + deleteId + " was not found!");
    }

    // Method to display all series in a report format
    public void seriesReport()
    {
        // Loop through all series and display their details
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

    // Method to exit the application
    public void exitSeriesApplication()
    {
        System.out.println("Exiting application...");
    }
}