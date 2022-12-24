package test.segment;

import main.template.MissingValueException;
import main.template.PlainText;
import main.template.Variable;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TestVariableSegment {
    private Map<String, String> variables;

    @Before
    public void setUp(){
        variables = new HashMap<>();
    }
    @Test
    public void variableEvaluateAsIs() throws Exception {
        String name = "name";
        String value = "Reader";
        variables.put(name, value);
        assertEquals(value, new Variable(name).evaluate(variables));
    }
    @Test
    public void missingVariableRaisesException() throws Exception{
        String name = "name";
        try{
            new Variable(name).evaluate(variables);
            fail("Missing variable values should raise an exception");
        }catch(MissingValueException expected){
            assertEquals("No value for ${" + name + "}",
                    expected.getMessage());
        }
    }
}
