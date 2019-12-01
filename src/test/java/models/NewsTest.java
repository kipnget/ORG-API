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

    @Test
    public void setContent() {
        News testNews = setupNews();
        testNews.setContent("No free dessert :(");
        assertNotEquals("Great service", testNews.getContent());
    }
    @Test
    public void getWrittenBy(){
        News testNews = setupNews();
        assertEquals("Kim",testNews.getWrittenBy());
    }
    @Test
    public void setWrittenBy(){
        News testNews= setupNews();
        testNews.setWrittenBy("Kim");
        assertEquals("Kim",testNews.getWrittenBy());
    }
    @Test
    public void getDepartmentId() {
        News testNews = setupNews();
        assertEquals(1, testNews.getDepartment_id());
    }

    @Test
    public void setDepartmentId() {
        News testNews = setupNews();
        testNews.setDepartment_id(10);
        assertNotEquals(1, testNews.getDepartment_id());
    }

    @Test
    public void setId() {
        News testNews = setupNews();
        testNews.setId(5);
        assertEquals(5, testNews.getId());
    }

    // helper
    public News setupNews (){
        return new News("organise", "Great service","Kim",1);
    }
}
