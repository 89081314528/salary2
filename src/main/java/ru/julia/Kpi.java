package ru.julia;

import java.math.BigDecimal;

public class Kpi {
    private final String name;
    private final BigDecimal kpi;

    public Kpi(String name, BigDecimal kpi) {
        this.name = name;
        this.kpi = kpi;
    }
    public Kpi(String csv) {
        String[] kpi = csv.split(";");
        this.name = kpi[0];
        this.kpi = new BigDecimal(kpi[1]);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getKpi() {
        return kpi;
    }

    @Override
    public String toString() {
        return "Kpi{" +
                "name='" + name + '\'' +
                ", kpi=" + kpi +
                '}';
    }
}
