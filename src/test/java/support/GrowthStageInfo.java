package support;

public class GrowthStageInfo {
    private String name;
    private double etcReplacementRatio;

    public GrowthStageInfo(String name, double etcReplacementRatio) {
        this.name = name;
        this.etcReplacementRatio = etcReplacementRatio;
    }

    public String getName() {
        return name;
    }

    public double getEtcReplacementRatio() {
        return etcReplacementRatio;
    }
}
