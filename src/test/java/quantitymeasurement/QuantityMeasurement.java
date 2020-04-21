package quantitymeasurement;

import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurement {
    @Test
    public void given0FeetAnd0Feet_shouldReturnEqual() {
        Length feet1 = new Length(Length.Unit.FEET, 0.0);
        Length feet2 = new Length(Length.Unit.FEET, 0.0);
        Assert.assertEquals(feet1, feet2);
    }

    @Test
    public void given0FeetAnd1Feet_shouldReturnNotEqual() {
        Length feet1 = new Length(Length.Unit.FEET, 0.0);
        Length feet2 = new Length(Length.Unit.FEET, 1.0);
        Assert.assertNotEquals(feet1, feet2);
    }

    @Test
    public void given1InchAnd1Inch_shouldReturnEqual() {
        Length inch1 = new Length(Length.Unit.INCH, 1.0);
        Length inch2 = new Length(Length.Unit.INCH, 1.0);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void given0InchAnd1Inch_shouldReturnNotEqual() {
        Length inch1 = new Length(Length.Unit.INCH, 0.0);
        Length inch2 = new Length(Length.Unit.INCH, 1.0);
        Assert.assertNotEquals(inch1, inch2);
    }

    @Test
    public void given1Feet1Inch_shouldReturnNotEqual() {
        Length feet = new Length(Length.Unit.FEET, 1.0);
        Length inch = new Length(Length.Unit.INCH, 1.0);
        Assert.assertNotEquals(feet, inch);
    }

    @Test
    public void givenNullAnd0Feet_shouldReturnNotEqual() {
        Length feet1 = new Length(Length.Unit.FEET,0.0);
        Assert.assertNotEquals(feet1, null);
    }

    @Test
    public void givenNullAnd1Inch_shouldReturnNotEqual() {
        Length inch = new Length(Length.Unit.INCH,1.0);
        Assert.assertNotEquals(inch, null);
    }

    @Test
    public void givenIntValueAnd1Feet_shouldReturnNotEqual() {
        Length feet = new Length(Length.Unit.FEET,1.0);
        Assert.assertNotEquals(feet,10);
    }

    @Test
    public void givenFloatValueAnd0Inch_shouldReturnNotEqual() {
        Length inch = new Length(Length.Unit.INCH,0.0);
        Assert.assertNotEquals(inch,2.1f);
    }

    @Test
    public void given0Feet0Inch_shouldReturnEqual() {
        Length feet = new Length(Length.Unit.FEET,0.0);
        Length inch = new Length(Length.Unit.INCH,0.0);
        boolean compareCheck = feet.compare(inch);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1Feet1Inch_shouldReturnFalse() {
        Length feet = new Length(Length.Unit.FEET,1.0);
        Length inch = new Length(Length.Unit.INCH,1.0);
        boolean compareCheck = feet.compare(inch);
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1Feet12Inch_shouldReturnTrue() {
        Length feet = new Length(Length.Unit.FEET,1.0);
        Length inch = new Length(Length.Unit.INCH,12.0);
        boolean compareCheck = feet.compare(inch);
        Assert.assertTrue(compareCheck);
    }
}
