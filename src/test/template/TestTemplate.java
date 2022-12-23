package test.template;

import main.template.MissingValueException;
import main.template.Template;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTemplate {
    private Template template;
    @Before
    public void setUp() throws Exception{
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multipleVariables() throws Exception{
        asserTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception{
        template.set("doesnotexist", "Hi");
        asserTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void missingValueRaisesException() throws Exception{
        try{
            new Template("${foo}").evaluate();
            fail("evaluate() should throw an exception if a variable was left without value");
        } catch (MissingValueException expected){
            assertEquals("No value for ${foo}", expected.getMessage());
        }
    }

    @Test
    public void variableGetProcessedJustOnce() throws Exception{
        template.set("one", "${one}");
        template.set("two", "${two}");
        template.set("three", "${three}");
        asserTemplateEvaluatesTo("${one}, ${two}, ${three}");
    }

    private void asserTemplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }


}
