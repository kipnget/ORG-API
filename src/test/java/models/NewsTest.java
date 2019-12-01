package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewsInstantiatesCorrectly() throws Exception{
        News news =setupNews();
        assertTrue(news instanceof News);
    }
    @Test
    public void getTitle(){
        News testNews =setupNews();
        assertEquals("organise",testNews.getTitle());
    }

    @Test
    public void getContent() {
        News testNews = setupNews();
        assertEquals("Great service", testNews.getContent());
    }


}
