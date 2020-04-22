package quantitymeasurement;

public enum Unit {

    FEET(12.0), INCH(1), YARD(36),
    CENTIMETRE(0.4);

    private final double baseUnitConversion;

    Unit(double baseUnitConversion) {
        this.baseUnitConversion = baseUnitConversion;
    }

    public static boolean compare(Length l1, Length l2) {
        return Double.compare(l1.value * l1.unit.baseUnitConversion,
                l2.value * l2.unit.baseUnitConversion) == 0;
    }
}
