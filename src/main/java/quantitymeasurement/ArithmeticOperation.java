package quantitymeasurement;

import static quantitymeasurement.TypeOfQuantity.TEMPERATURE;

public class ArithmeticOperation {

    public QuantityMeasurement addition(QuantityMeasurement firstParameter, QuantityMeasurement secondParameter) throws QuantityMeasurementException {
        if(firstParameter.unit.typeOfQuantity == TEMPERATURE && secondParameter.unit.typeOfQuantity == TEMPERATURE)
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.TEMPERATURE_CANNOT_ADD, "Temperature addition");
        if (firstParameter.unit.typeOfQuantity.equals(secondParameter.unit.typeOfQuantity)) {
            double firstValue = firstParameter.value * firstParameter.unit.value;
            double secondValue = secondParameter.value * secondParameter.unit.value;
            double result = firstValue + secondValue;
            switch (secondParameter.unit.typeOfQuantity) {
                case LENGTH:
                    return new QuantityMeasurement(result, Unit.INCH);
                case VOLUME:
                    return new QuantityMeasurement(result, Unit.LITRE);
                case WEIGHT:
                    return new QuantityMeasurement(result, Unit.KILOGRAMS);
            }
        }
        throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.UNIT_MISMATCH, "Unit is not equal");
    }
}
