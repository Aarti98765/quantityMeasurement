package quantitymeasurement;

public enum Unit {
    FEET(TypeOfQuantity.LENGTH, 12.0), INCH(TypeOfQuantity.LENGTH, 1), YARD(TypeOfQuantity.LENGTH, 36),
    CENTIMETRE(TypeOfQuantity.LENGTH,0.4) , GALLON(TypeOfQuantity.VOLUME,3.78), LITRE(TypeOfQuantity.VOLUME,1),
    MILLILITRE(TypeOfQuantity.VOLUME,0.001), KILOGRAMS(TypeOfQuantity.WEIGHT,1), GRAMS(TypeOfQuantity.WEIGHT,0.001),
    TONNE(TypeOfQuantity.WEIGHT,1000),
    FAHRENHEIT(TypeOfQuantity.TEMPERATURE) {
        public double converter(double value) {
            return (value - 32) * 5 / 9;
        }
    },
    CELSIUS(TypeOfQuantity.TEMPERATURE) {
        public double converter(double value) {
            return value;
        }
    };
    public double value;
    public final TypeOfQuantity typeOfQuantity;

    Unit(TypeOfQuantity typeOfQuantity) {
        this.typeOfQuantity = typeOfQuantity;
    }

    Unit(TypeOfQuantity typeOfQuantity, double value) {
        this.typeOfQuantity = typeOfQuantity;
        this.value = value;
    }

    public double converter(double value) {
        return 0.0;
    }

    public static boolean compare(QuantityMeasurement firstParameter, QuantityMeasurement secondParameter) throws QuantityMeasurementException {
        if (firstParameter.unit.typeOfQuantity.equals(secondParameter.unit.typeOfQuantity)) {
            if (firstParameter.unit.typeOfQuantity == TypeOfQuantity.TEMPERATURE && secondParameter.unit.typeOfQuantity == TypeOfQuantity.TEMPERATURE) {
                Double firstValue = firstParameter.unit.converter(firstParameter.value);
                Double secondValue = secondParameter.unit.converter(secondParameter.value);
                System.out.println(firstValue);
                System.out.println(secondValue);
                return firstValue.equals(secondValue);
            }
            return Double.compare(firstParameter.value * firstParameter.unit.value,
                    secondParameter.value * secondParameter.unit.value) == 0;
        }
        throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.UNIT_MISMATCH, "Unit is not equal");
    }
}
