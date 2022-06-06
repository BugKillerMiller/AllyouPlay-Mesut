package com.task.step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import com.task.utilities.Driver;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {

        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown() {

        Driver.closeDriver();

    }
}