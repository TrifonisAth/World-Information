package com.example.worldinfo.worldinfoservice.models.responses.actions;

public class RangeActionParam extends ActionParam{
    private final int min;
    private final int max;
    private final int step;

    public RangeActionParam(String name, String type, String description, int min, int max, int step) {
        super(name, type, description);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    @Override
    public String toString() {
        return "RangeActionParam{" +
                "min=" + min +
                ", max=" + max +
                ", step=" + step +
                '}';
    }

    public int getStep() {
        return step;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
