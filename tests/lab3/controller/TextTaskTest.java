package lab3.controller;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Алексей on 07.06.2017.
 */
public class TextTaskTest {

    static ITextTask textTask;

    @BeforeClass
    public void setUpStatic(){
        textTask = ITextTask.create();
    }

    @Test
    public void textReplacePositive() throws Exception {
        StringBuffer result = textTask.textReplace(new StringBuffer("abcd, ffff: g, gg; dsgs. AA gk; ssss."));
        Assert.assertEquals("ssss, ffff: g, gg; dsgs. AA gk; abcd.", result.toString());
    }

    @Test
    public void textReplaceNegative() throws Exception {
        StringBuffer result = textTask.textReplace(new StringBuffer("abcd, ffff: g, gg; dsgs. AA gk; ssss."));
        Assert.assertNotEquals("ssss, ffff: g, gg; dsgs. A gk; abcd.", result.toString());
    }

}