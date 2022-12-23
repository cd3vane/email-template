package test.template;

import main.template.TemplateParse;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestTemplateParse {

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        TemplateParse parse = new TemplateParse();
        List<String> segments = parse.parse("");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("", segments.get(0));
    }

    @Test
    public void templateWithOnlyPlainText() throws Exception {
        TemplateParse parse = new TemplateParse();
        List<String> segments = parse.parse("plain text only");
        assertEquals("Number of segments", 1, segments.size());
        assertEquals("plain text only", segments.get(0));
    }
}
