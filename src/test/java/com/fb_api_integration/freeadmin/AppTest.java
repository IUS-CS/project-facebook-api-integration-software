package com.fb_api_integration.freeadmin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void TitleTest()
    {
     GuiForm TitleObject = new GuiForm();
        TitleObject.setTitle("Free Admin");
        assertEquals("Free Admin", TitleObject.getTitle());
    }

    @Test
    public void RootPanelTest()
    {
        GuiForm RootObject = new GuiForm();
        RootObject.getRootPane();
        assertTrue(true);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

}
