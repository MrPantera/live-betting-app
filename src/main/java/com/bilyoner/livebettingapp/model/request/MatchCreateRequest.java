package com.bilyoner.livebettingapp.model.request;

import com.bilyoner.livebettingapp.model.entity.Match;

import java.util.Date;

import static com.bilyoner.livebettingapp.model.entity.Match.MatchBuilder.aMatch;


public class MatchCreateRequest {

    private String league;
    private String homeTeam;
    private String awayTeam;
    private float homeOdds;
    private float awayOdds;
    private Date matchTime;

    public Match toMatch() {
        return aMatch()
                .league(league)
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .homeOdds(homeOdds)
                .awayOdds(awayOdds)
                .matchTime(matchTime)
                .build();
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public float getHomeOdds() {
        return homeOdds;
    }

    public void setHomeOdds(float homeOdds) {
        this.homeOdds = homeOdds;
    }

    public float getAwayOdds() {
        return awayOdds;
    }

    public void setAwayOdds(float awayOdds) {
        this.awayOdds = awayOdds;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }


    public static final class MatchCreateRequestBuilder {

        private String league;
        private String homeTeam;
        private String awayTeam;
        private float homeOdds;
        private float awayOdds;
        private Date matchTime;

        private MatchCreateRequestBuilder() {
        }

        public static MatchCreateRequestBuilder anMatchCreateRequest() {
            return new MatchCreateRequestBuilder();
        }

        public MatchCreateRequestBuilder league(String league) {
            this.league = league;
            return this;
        }

        public MatchCreateRequestBuilder homeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public MatchCreateRequestBuilder awayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public MatchCreateRequestBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchCreateRequestBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchCreateRequestBuilder matchTime(Date matchTime) {
            this.matchTime = matchTime;
            return this;
        }

        public MatchCreateRequest build() {
            MatchCreateRequest matchCreateRequest = new MatchCreateRequest();
            matchCreateRequest.setLeague(league);
            matchCreateRequest.setHomeTeam(homeTeam);
            matchCreateRequest.setAwayTeam(awayTeam);
            matchCreateRequest.setHomeOdds(homeOdds);
            matchCreateRequest.setAwayOdds(awayOdds);
            matchCreateRequest.setMatchTime(matchTime);
            return matchCreateRequest;
        }
    }

}
