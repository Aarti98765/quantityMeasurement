package quantitymeasurement;

public enum Unit {

    FEET(12.0), INCH(1), YARD(36),
    CENTIMETRE(0.4);

    private final double baseUnitConversion;

    Unit(double baseUnitConversion) {
        this.baseUnitConversion = baseUnitConversion;
    }

    public static boolean compare(Length lengthValue1, Length lengthValue2) {
        return Double.compare(lengthValue1.value * lengthValue1.unit.baseUnitConversion,
                lengthValue2.value * lengthValue2.unit.baseUnitConversion) == 0;
    }

    public static double add(Length lengthValue1, Length lengthValue2) {
        return lengthValue1.value * lengthValue1.unit.baseUnitConversion +
                lengthValue2.value * lengthValue2.unit.baseUnitConversion;
    }
}
