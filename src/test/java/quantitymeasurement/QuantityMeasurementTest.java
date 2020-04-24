package quantitymeasurement;

import org.junit.Assert;
import org.junit.Test;

public class QuantityMeasurementTest {
    ArithmeticOperation operation = new ArithmeticOperation();

    @Test
    public void given0FeetAnd0Feet_shouldReturnEqual() {
        QuantityMeasurement feet1 = new QuantityMeasurement(0.0, Unit.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(0.0, Unit.FEET);
        Assert.assertEquals(feet1, feet2);
    }

    @Test
    public void given0FeetAnd1Feet_whenCheckedReferences_shouldReturnNotEqual() {
        QuantityMeasurement feet1 = new QuantityMeasurement(0.0, Unit.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(1.0, Unit.FEET);
        Assert.assertNotEquals(feet1, feet2);
    }

    @Test
    public void given1InchAnd1Inch_shouldReturnEqual() {
        QuantityMeasurement inch1 = new QuantityMeasurement(1.0, Unit.INCH);
        QuantityMeasurement inch2 = new QuantityMeasurement(1.0, Unit.INCH);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void given0InchAnd1Inch_shouldReturnNotEqual() {
        QuantityMeasurement inch1 = new QuantityMeasurement(0.0, Unit.INCH);
        QuantityMeasurement inch2 = new QuantityMeasurement(1.0, Unit.INCH);
        Assert.assertNotEquals(inch1, inch2);
    }

    @Test
    public void given1Feet1Inch_whenCheckedType_shouldReturnNotEqual() {
        QuantityMeasurement feet = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement inch = new QuantityMeasurement(0.0, Unit.INCH);
        Assert.assertNotEquals(feet, inch);
    }

    @Test
    public void givenNullAnd0Feet_shouldReturnNotEqual() {
        QuantityMeasurement feet1 = new QuantityMeasurement(0.0, Unit.FEET);
        Assert.assertNotEquals(feet1, null);
    }

    @Test
    public void givenNullAnd1Inch_shouldReturnNotEqual() {
        QuantityMeasurement inch = new QuantityMeasurement(1.0, Unit.INCH);
        Assert.assertNotEquals(inch, null);
    }

    @Test
    public void givenIntValueAnd1Feet_shouldReturnNotEqual() {
        QuantityMeasurement feet = new QuantityMeasurement(1.0, Unit.FEET);
        Assert.assertNotEquals(feet,10);
    }

    @Test
    public void givenFloatValueAnd0Inch_shouldReturnNotEqual() {
        QuantityMeasurement inch = new QuantityMeasurement(0.0, Unit.INCH);
        Assert.assertNotEquals(inch,2.1f);
    }

    @Test
    public void given0Feet0Inch_shouldReturnEqual() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(0.0, Unit.FEET);
        QuantityMeasurement inch = new QuantityMeasurement(0.0, Unit.INCH);
        boolean compareCheck = Unit.compare(feet, inch);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1Feet1Inch_shouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement inch = new QuantityMeasurement(1.0, Unit.INCH);
        boolean compareCheck = Unit.compare(feet, inch);
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1Feet1Feet_whenCompared_shouldReturnEqualLength() throws QuantityMeasurementException {
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(1.0, Unit.FEET);
        boolean compareCheck = Unit.compare(feet1, feet2);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given1Feet1Inch_whenCompared_shouldReturnFalse() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement inch = new QuantityMeasurement(1.0, Unit.INCH);
        boolean compareCheck = Unit.compare(feet, inch);
        Assert.assertFalse(compareCheck);
    }

    @Test
    public void given1Feet12Inch_whenCompared_shouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement feet = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement inch = new QuantityMeasurement(12.0, Unit.INCH);
        boolean compareCheck = Unit.compare(feet, inch);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void given12Inch1Feet_whenCompared_shouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurement inch = new QuantityMeasurement(12.0, Unit.INCH);
        QuantityMeasurement feet = new QuantityMeasurement(1.0, Unit.FEET);
        boolean compareCheck = Unit.compare(inch, feet);
        Assert.assertTrue(compareCheck);
    }

    @Test
    public void givenFeetAndYard_when3FeetEqualsToYard_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(3.0, Unit.FEET);
        QuantityMeasurement value2 = new QuantityMeasurement(1.0, Unit.YARD);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenFeetAndYard_when1FeetNotEqualsTo1Yard_returnFalse() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement value2 = new QuantityMeasurement(1.0, Unit.YARD);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void givenInchAndYard_when1InchNotEqualsTo1Yard_returnFalse() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.INCH);
        QuantityMeasurement value2 = new QuantityMeasurement(1.0, Unit.YARD);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertFalse(isEqual);
    }

    @Test
    public void givenYardAndInch_when1YardEqualsTo36Inch_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.YARD);
        QuantityMeasurement value2 = new QuantityMeasurement(36.0, Unit.INCH);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenInchAndYard_when36InchEqualsTo1Yard_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(36.0, Unit.INCH);
        QuantityMeasurement value2 = new QuantityMeasurement(1.0, Unit.YARD);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenYardAndFeet_when1YardEqualsTo3Feet_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.YARD);
        QuantityMeasurement value2 = new QuantityMeasurement(3.0, Unit.FEET);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenInchAndCentimetre_when2InchEqualsTo5Centimetre_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(2.0, Unit.INCH);
        QuantityMeasurement value2 = new QuantityMeasurement(5.0, Unit.CENTIMETRE);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenInchAndInch_when2InchAddedTo2Inch_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(2.0, Unit.INCH);
        QuantityMeasurement value2 = new QuantityMeasurement(2.0, Unit.INCH);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(4.0, Unit.INCH), result);
    }

    @Test
    public void givenFeetAndInch_when1FeetAddedTo2Inch_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement value2 = new QuantityMeasurement(2.0, Unit.INCH);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(14.0, Unit.INCH), result);
    }

    @Test
    public void givenFeetAndFeet_when1FeetAddedTo1Feet_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement value2 = new QuantityMeasurement(1.0, Unit.FEET);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(24.0, Unit.INCH), result);
    }

    @Test
    public void givenInchAndCentimetre_when2InchAddedTo2Centimeter_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(2.0, Unit.INCH);
        QuantityMeasurement value2 = new QuantityMeasurement(2.5, Unit.CENTIMETRE);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(3.0, Unit.INCH), result);
    }

    @Test
    public void givenGallonAndLitre_when1GallonEqualsTo3Liter_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.GALLON);
        QuantityMeasurement value2 = new QuantityMeasurement(3.78, Unit.LITRE);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenLitreAndMillilitre_when1LitreEqualsTo1000Millilitre_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.LITRE);
        QuantityMeasurement value2 = new QuantityMeasurement(1000.0, Unit.MILLILITRE);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenGallonAndLitre_when1GallonAddedTo3Litre_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.GALLON);
        QuantityMeasurement value2 = new QuantityMeasurement(3.78, Unit.LITRE);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(7.56, Unit.LITRE), result);
    }

    @Test
    public void givenLitreAndMillilitre_when1LitreAddedTo1000Millilitre_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.LITRE);
        QuantityMeasurement value2 = new QuantityMeasurement(1000.0, Unit.MILLILITRE);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(2.0, Unit.LITRE), result);
    }

    @Test
    public void givenKilogramsAndGrams_when1KilogramsEqualsTo1000Grams_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.KILOGRAMS);
        QuantityMeasurement value2 = new QuantityMeasurement(1000.0, Unit.GRAMS);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenTonneAndKilogram_when1TonneEqualsTo1000Kilograms_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.TONNE);
        QuantityMeasurement value2 = new QuantityMeasurement(1000.0, Unit.KILOGRAMS);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenTonneAndGram_when1TonneAddedTo1000Grams_returnEqual() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(1.0, Unit.TONNE);
        QuantityMeasurement value2 = new QuantityMeasurement(1000.0, Unit.GRAMS);
        QuantityMeasurement result = operation.addition(value1, value2);
        Assert.assertEquals(new QuantityMeasurement(1001.0, Unit.KILOGRAMS), result);
    }

    @Test
    public void givenFahrenheitAndCelsius_when212FahrenheitEqualsTo100Celsius_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(212.0, Unit.FAHRENHEIT);
        QuantityMeasurement value2 = new QuantityMeasurement(100.0, Unit.CELSIUS);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }

    @Test
    public void givenFahrenheitAndCelsius_when148FahrenheitEqualsTo100Celsius_returnTrue() throws QuantityMeasurementException {
        QuantityMeasurement value1 = new QuantityMeasurement(-148.0, Unit.FAHRENHEIT);
        QuantityMeasurement value2 = new QuantityMeasurement(-100.0, Unit.CELSIUS);
        boolean isEqual = Unit.compare(value1, value2);
        Assert.assertTrue(isEqual);
    }
}
