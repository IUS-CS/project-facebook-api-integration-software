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
        assertEquals("Free Admin", TitleObject.getTitle());
    }

}
