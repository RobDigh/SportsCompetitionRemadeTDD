package result;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {

    Result result = new Result();

    @Test
    public void testAddResult(){
        assertTrue(result.addResult());
    }

    @Test
    public void testGetResultByParticipant(){
        assertTrue(result.getResultByParticipant());
    }

    @Test
    public void testGetResultByEvent(){
        assertTrue(result.getResultByEvent());
    }

    @Test
    public void testGetResultByTeam(){
        assertTrue(result.getResultByTeam());
    }

}