package quantitymeasurement;

import java.util.Objects;

 public class Length {
    private final double FEET_TO_INCH = 12.0;
    private final double INCH_TO_FEET = 12.0;
    private final double value;
    private final Unit unit;

    enum Unit{
        FEET, INCH
    };

     public boolean compare(Length that) {
         if (this.unit.equals(Unit.FEET) && that.unit.equals(Unit.FEET))
             return Double.compare(this.value,that.value) == 0;
         if (this.unit.equals(Unit.FEET) && that.unit.equals(Unit.INCH))
             return Double.compare(this.value*FEET_TO_INCH,that.value) == 0;
         if (this.unit.equals(Unit.INCH) && that.unit.equals(Unit.FEET))
             return Double.compare(this.value/INCH_TO_FEET,that.value) == 0;
         return false;
     }

    public Length(Unit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Length length = (Length) o;
         return Double.compare(length.value, value) == 0 && unit == length.unit;
     }
 }
