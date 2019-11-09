package testbase;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.SearchPage;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@RunWith(Parameterized.class)
public class TestSearch {
    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        app.App.start();

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"alibaba", 100f},
                {"xiaomi", 8f},
                {"jd", 33f}
        });
    }

    @Parameterized.Parameter(0)
    public String stock;

    @Parameterized.Parameter(1)
    public Float price;

    @Before
    public void before() {
        searchPage = app.App.toSearch();
    }

    @Test
    public void search() {
        assertThat(searchPage.search(stock).getCurrentPrice(), greaterThanOrEqualTo(price));
        System.out.println(searchPage.search(stock).getCurrentPrice());
    }

    @After
    public void after() {
        searchPage.cancel();
    }

    @AfterClass
    public static void exit() {
        app.App.tearDown();
    }
}
