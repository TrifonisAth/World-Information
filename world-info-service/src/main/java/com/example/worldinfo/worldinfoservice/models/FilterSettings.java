package com.example.worldinfo.worldinfoservice.models;

import java.io.Serializable;
import java.util.List;

public class FilterSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int min;
    private final int max;
    private final List<String> regions;

    public FilterSettings(int min, int max, List<String> regions) {
        this.min = min;
        this.max = max;
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "FilterSettings{" +
                "min=" + min +
                ", max=" + max +
                ", regions=" + regions +
                '}';
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public List<String> getRegions() {
        return regions;
    }
}
