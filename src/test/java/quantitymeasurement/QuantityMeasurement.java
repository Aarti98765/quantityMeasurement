package quantitymeasurement;

import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurement {
    @Test
    public void given0FeetAnd0Feet_shouldReturnEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(0.0);
        Assert.assertEquals(feet1,feet2);
    }

    @Test
    public void given0FeetAnd1Feet_shouldReturnNotEqual() {
        Feet feet1 = new Feet(0.0);
        Feet feet2 = new Feet(1.0);
        Assert.assertNotEquals(feet1,feet2);
    }

    @Test
    public void given1InchAnd1Inch_shouldReturnEqual() {
        Inch inch1 = new Inch(1.0);
        Inch inch2 = new Inch(1.0);
    }

   @Test
    public void given0InchAnd1Inch_shouldReturnNotEqual() {
        Inch inch1 = new Inch(0.0);
        Inch inch2 = new Inch(1.0);
        Assert.assertNotEquals(inch1,inch2);
    }
}