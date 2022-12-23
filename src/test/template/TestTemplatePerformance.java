package test.template;

import main.Template;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTemplatePerformance {
    private Template template;

    @Before
    public void setUp() throws Exception {
        buildTemplate();
        populateTemplate();
    }
    private void buildTemplate() {
        StringBuffer text = new StringBuffer(50000);
        for (int i = 0, var = 1; i < 1000; i++, var++) {
            text.append(" template ");
            if (i % 1000 / 50 == 0) {
                text.append("${var").append(var).append("}");
            }
        }
        template = new Template(text.toString());
    }
    private void populateTemplate() {
        for (int var = 1; var < 100; var++) {
            template.set("var" + var, "value of var" + var);
        }
    }

    @Test
    public void templateWith1000WordsAnd20Variables() {
        long expected = 500L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        assertTrue("Rendering the template took " + time
                        + "ms while the target was " + expected + "ms",
                time <= expected);
    }
}
