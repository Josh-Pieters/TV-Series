import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
public class MainTest {
    //<<**ChatGPT helped out with figuring the unit tests out.**>>
    Series series;
    ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception
    {
        series = new Series();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSearchSeries() {
        series.seriesList.add(new SeriesModel("S001", "Test Series", 12, 10));
        provideInput("S001\n");
        series.searchSeries();
        assertTrue(outContent.toString().contains("Series with Id: S001 found!"));
    }

    @Test
    public void testSearchSeries_SeriesNotFound() {
        series.seriesList.add(new SeriesModel("S001", "Test Series", 12, 10));
        provideInput("S002\n");
        series.searchSeries();
        assertTrue(outContent.toString().contains("Series with Id: S002 was not found!"));
    }

    @Test
    public void testUpdateSeries() {
        series.seriesList.add(new SeriesModel("S001", "Old Series", 12, 10));
        provideInput("S001\nNew Series\n13\n15\n");
        series.updateSeries();
        assertTrue(outContent.toString().contains("Series updated successfully!"));
    }

    @Test
    public void testDeleteSeries() {
        series.seriesList.add(new SeriesModel("S001", "Test Series", 12, 10));
        provideInput("S001\ny\n");
        series.deleteSeries();
        assertTrue(outContent.toString().contains("Series with series Id: S001 was deleted!"));
    }

    @Test
    public void testDeleteSeries_SeriesNotFound() {
        series.seriesList.add(new SeriesModel("S001", "Test Series", 12, 10));
        provideInput("S002\nn\n");
        series.deleteSeries();
        assertTrue(outContent.toString().contains("Series with Id: S002 was not found!"));
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        provideInput("S001\nTest Series\n12\n10\n");
        series.captureSeries();
        assertTrue(outContent.toString().contains("Series captured successfully!"));
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        provideInput("S001\nTest Series\n19\n10\n");
        series.captureSeries();
        assertTrue(outContent.toString().contains("Please re-enter the series age restriction between 0 and 18."));
    }

    private void provideInput(String data) {
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        series.scanner = new Scanner(System.in);
    }

}