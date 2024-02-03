package com.example.worldinfo.worldinfoservice.models.responses.actions;

public class RangeActionParam extends ActionParam{
    private final int min;
    private final int max;

    public RangeActionParam(String name, String type, String description, int min, int max) {
        super(name, type, description);
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "RangeActionParam{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
