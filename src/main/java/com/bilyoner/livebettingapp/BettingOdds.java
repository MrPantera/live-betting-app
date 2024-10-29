package com.bilyoner.livebettingapp;

import java.text.DecimalFormat;
import java.util.Random;

public class BettingOdds {
    private Float homeOdds;
    private Float drawOdds;
    private Float awayOdds;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Float getHomeOdds() {
        return homeOdds;
    }

    public void setHomeOdds(Float homeOdds) {
        this.homeOdds = homeOdds;
    }

    public Float getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(Float drawOdds) {
        this.drawOdds = drawOdds;
    }

    public Float getAwayOdds() {
        return awayOdds;
    }

    public void setAwayOdds(Float awayOdds) {
        this.awayOdds = awayOdds;
    }

    public void calculateRandomOdds() {
        // Random number generator
        Random random = new Random();

        Float homeWinProbability = (float) (0.1 + random.nextFloat());
        Float awayWinProbability = (float) (0.1 + random.nextFloat());
        Float drawProbability = Math.min(random.nextFloat(),(homeWinProbability + awayWinProbability)/2);
        Float totalProbability = homeWinProbability + awayWinProbability + drawProbability;

        homeWinProbability = homeWinProbability/totalProbability;
        drawProbability = drawProbability/totalProbability;
        awayWinProbability = awayWinProbability/totalProbability;

        // Convert probabilities to decimal odds
        Float homeWinOdds = Float.valueOf(df.format((0.8 / homeWinProbability)));
        Float drawOdds = Float.valueOf(df.format((0.8 / drawProbability)));
        Float awayWinOdds = Float.valueOf(df.format((0.8 / awayWinProbability)));

        this.setHomeOdds(homeWinOdds);
        this.setDrawOdds(drawOdds);
        this.setAwayOdds(awayWinOdds);
    }
}