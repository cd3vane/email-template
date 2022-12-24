package test.segment;

import main.template.PlainText;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TestPlainTextSegment {

    @Test
    public void plainTextEvaluateAsIs() throws Exception {
        Map<String, String> variables = new HashMap<>();
        String text = "abc def";
        assertEquals(text, new PlainText(text).evaluate(variables));
    }
}
