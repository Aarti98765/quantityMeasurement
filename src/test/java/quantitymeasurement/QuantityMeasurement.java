package quantitymeasurement;

import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurement {
    @Test
    public void given0FeetAnd0Feet_shouldReturnEqual() {
        Length feet1 = new Length(Unit.FEET, 0.0);
        Length feet2 = new Length(Unit.FEET, 0.0);
        Assert.assertEquals(feet1, feet2);
    }

    @Test
    public void given0FeetAnd1Feet_whenCheckedReferences_shouldReturnNotEqual() {
        Length feet1 = new Length(Unit.FEET, 0.0);
        Length feet2 = new Length(Unit.FEET, 1.0);
        Assert.assertNotEquals(feet1, feet2);
    }

    @Test
    public void given1InchAnd1Inch_shouldReturnEqual() {
        Length inch1 = new Length(Unit.INCH, 1.0);
        Length inch2 = new Length(Unit.INCH, 1.0);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void given0InchAnd1Inch_shouldReturnNotEqual() {
        Length inch1 = new Length(Unit.INCH, 0.0);
        Length inch2 = new Length(Unit.INCH, 1.0);
        Assert.assertNotEquals(inch1, inch2);
    }

    @Test
    public void given1Feet1Inch_whenCheckedType_shouldReturnNotEqual() {
        Length feet = new Length(Unit.FEET, 1.0);
        Length inch = new Length(Unit.INCH, 1.0);
        Assert.assertNotEquals(feet, inch);
    }

    @Test
    public void givenNullAnd0Feet_shouldReturnNotEqual() {
        Length feet1 = new Length(Unit.FEET,0.0);
        Assert.assertNotEquals(feet1, null);
    }

    @Test
    public void givenNullAnd1Inch_shouldReturnNotEqual() {
        Length inch = new Length(Unit.INCH,1.0);
        Assert.assertNotEquals(inch, null);
    }

    @Test
    public void givenIntValueAnd1Feet_shouldReturnNotEqual() {
        Length feet = new Length(Unit.FEET,1.0);
        Assert.assertNotEquals(feet,10);
    }

    @Test
    public void givenFloatValueAnd0Inch_shouldReturnNotEqual() {
        Length inch = new Length(Unit.INCH,0.0);
        Assert.assertNotEquals(inch,2.1f);
    }

    @Test
    public void given0Feet0Inch_shouldReturnEqual() {
        Length feet = new Length(Unit.FEET,0.0);
        Length inch = new Length(Unit.INCH,0.0);
        boolean compareCheck = Unit.unitConversion(feet, inch);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1Feet1Inch_shouldReturnFalse() {
        Length feet = new Length(Unit.FEET,1.0);
        Length inch = new Length(Unit.INCH,1.0);
        boolean compareCheck = Unit.unitConversion(feet, inch);
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1Feet1Feet_whenCompared_shouldReturnEqualLength() {
        Length feet1 = new Length(Unit.FEET,1.0);
        Length feet2 = new Length(Unit.FEET,1.0);
        boolean compareCheck = Unit.unitConversion(feet1, feet2);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1Feet1Inch_whenCompared_shouldReturnFalse() {
        Length feet = new Length(Unit.FEET,1.0);
        Length inch = new Length(Unit.INCH,1.0);
        boolean compareCheck = Unit.unitConversion(feet, inch);
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1Feet12Inch_whenCompared_shouldReturnTrue() {
        Length feet = new Length(Unit.FEET,1.0);
        Length inch = new Length(Unit.INCH,12.0);
        boolean compareCheck = Unit.unitConversion(feet, inch);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given12Inch1Feet_whenCompared_shouldReturnTrue() {
        Length inch = new Length(Unit.INCH,12.0);
        Length feet = new Length(Unit.FEET,1.0);
        boolean compareCheck = Unit.unitConversion(inch, feet);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenFeetAndYard_when3FeetEqualsToYard_returnTrue() {
        Length value1 = new Length(Unit.FEET, 3.0);
        Length value2 = new Length(Unit.YARD, 1.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenFeetAndYard_when1FeetNotEqualsTo1Yard_returnFalse() {
        Length value1 = new Length(Unit.FEET, 1.0);
        Length value2 = new Length(Unit.YARD, 1.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void givenInchAndYard_when1InchNotEqualsTo1Yard_returnFalse() {
        Length value1 = new Length(Unit.INCH, 1.0);
        Length value2 = new Length(Unit.YARD, 1.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void givenYardAndInch_when1YardEqualsTo36Inch_returnTrue() {
        Length value1 = new Length(Unit.YARD, 1.0);
        Length value2 = new Length(Unit.INCH, 36.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenInchAndYard_when36InchEqualsTo1Yard_returnTrue() {
        Length value1 = new Length(Unit.INCH, 36.0);
        Length value2 = new Length(Unit.YARD, 1.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenYardAndFeet_when1YardEqualsTo3Feet_returnTrue() {
        Length value1 = new Length(Unit.YARD, 1.0);
        Length value2 = new Length(Unit.FEET, 3.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenInchAndCentimetre_when2InchEqualsTo5Centimetre_returnTrue() {
        Length value1 = new Length(Unit.INCH, 2.0);
        Length value2 = new Length(Unit.CENTIMETRE, 5.0);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenInchAndInch_when2InchAddedTo2Inch_returnEqual() {
        Length value1 = new Length(Unit.INCH, 2.0);
        Length value2 = new Length(Unit.INCH, 2.0);
        double addition = Unit.add(value1, value2);
        Assert.assertEquals(4.0, addition, 0.0);
    }

    @Test
    public void givenFeetAndInch_when1FeetAddedTo2Inch_returnEqual() {
        Length value1 = new Length(Unit.FEET, 1.0);
        Length value2 = new Length(Unit.INCH, 2.0);
        double addition = Unit.add(value1, value2);
        Assert.assertEquals(14.0, addition, 0.0);
    }

    @Test
    public void givenFeetAndFeet_when1FeetAddedTo1Feet_returnEqual() {
        Length value1 = new Length(Unit.FEET, 1.0);
        Length value2 = new Length(Unit.FEET, 1.0);
        double addition = Unit.add(value1, value2);
        Assert.assertEquals(24.0, addition, 0.0);
    }

    @Test
    public void givenInchAndCentimetre_when2InchAddedTo2Centimeter_returnEqual() {
        Length value1 = new Length(Unit.INCH, 2.0);
        Length value2 = new Length(Unit.CENTIMETRE, 2.5);
        double addition = Unit.add(value1, value2);
        Assert.assertEquals(3.0, addition, 0.0);
    }

    @Test
    public void givenGallonAndLitre_when1GallonEqualsTo3Liter_returnTrue() {
        Length value1 = new Length(Unit.GALLON, 1.0);
        Length value2 = new Length(Unit.LITRE, 3.78);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenLitreAndMillilitre_when1LitreEqualsTo1000Millilitre_returnTrue() {
        Length value1 = new Length(Unit.LITRE, 1.0);
        Length value2 = new Length(Unit.MILLILITRE, 1000);
        boolean isEqual = Unit.unitConversion(value1, value2);
        Assert.assertTrue(isEqual);
    }
}
