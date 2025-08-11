import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String choice;
        String input;
        Series series = new Series();


        System.out.println("LATEST SERIES - 2025");
        System.out.println("************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        input = sc.nextLine();

        if (input.equals("1"))
        {
            boolean running = true;
            while (running)
            {
                System.out.println("\nPlease select one of the following menu items:");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series.");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application.");

                System.out.print("Enter your choice: ");
                choice = sc.nextLine();

                if (choice.equals("1"))
                {
                    System.out.println("**********************************************");
                    System.out.println("CAPTURE A NEW SERIES");
                    System.out.println("**********************************************");
                    series.captureSeries();
                }
                else if (choice.equals("2"))
                {
                    series.searchSeries();
                }
                else if (choice.equals("3"))
                {
                    series.updateSeries();
                }
                else if (choice.equals("4"))
                {
                    series.deleteSeries();
                }
                else if (choice.equals("5"))
                {
                    series.seriesReport();
                }
                else if (choice.equals("6"))
                {
                    series.exitSeriesApplication();
                    running = false;
                }
                else
                {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}