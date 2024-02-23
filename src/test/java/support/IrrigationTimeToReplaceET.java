package support;

public class IrrigationTimeToReplaceET {
    private Integer min;
    private Integer hrs;

    public IrrigationTimeToReplaceET(Integer min, Integer hrs) {
        this.min = min;
        this.hrs = hrs;
    }

    // Getter and setter methods
    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getHrs() {
        return hrs;
    }

    public void setHrs(Integer hrs) {
        this.hrs = hrs;
    }

    @Override
    public String toString() {
        return "IrrigationTimeToReplaceET{" +
                "min=" + min +
                ", hrs=" + hrs +
                '}';
    }
}