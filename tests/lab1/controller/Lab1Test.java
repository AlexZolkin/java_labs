package lab1.controller;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Алексей on 07.06.2017.
 */
public class Lab1Test {
    @Test
    public void calculateTaskPositive() throws Exception {
        ILab1<Integer> lab1 = new Lab1<>();
        Assert.assertEquals(Integer.valueOf(-3), lab1.calculateTask(2, 3));
    }

    @Test
    public void calculateTaskNegative() throws Exception {
        ILab1<Integer> lab1 = new Lab1<>();
        Assert.assertNotEquals(Integer.valueOf(-8), lab1.calculateTask(3, 4));
    }
}