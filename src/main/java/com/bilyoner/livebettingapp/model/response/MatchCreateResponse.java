package com.bilyoner.livebettingapp.model.response;

import com.bilyoner.livebettingapp.model.entity.Match;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

import static com.bilyoner.livebettingapp.model.response.MatchCreateResponse.MatchCreateResponseBuilder.aMatchResponse;

public class MatchCreateResponse {

    private Long id;
    private String league;
    private String homeTeam;
    private String awayTeam;
    private float homeOdds;
    private float drawOdds;
    private float awayOdds;
    private Date matchTime;

    public static MatchCreateResponse createFrom(Match match) {
        return aMatchResponse()
                .id(match.getId())
                .league(match.getLeague())
                .homeTeam(match.getHomeTeam())
                .awayTeam(match.getAwayTeam())
                .homeOdds(match.getHomeOdds())
                .drawOdds(match.getDrawOdds())
                .awayOdds(match.getAwayOdds())
                .matchTime(match.getMatchTime())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getDrawOdds() {
        return drawOdds;
    }

    public void setDrawOdds(float drawOdds) {
        this.drawOdds = drawOdds;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MatchCreateResponse that = (MatchCreateResponse) o;

        return new EqualsBuilder().append(getHomeOdds(), that.getHomeOdds()).append(getDrawOdds(), that.getDrawOdds()).append(getAwayOdds(), that.getAwayOdds()).append(getId(), that.getId()).append(getLeague(), that.getLeague()).append(getHomeTeam(), that.getHomeTeam()).append(getAwayTeam(), that.getAwayTeam()).append(getMatchTime(), that.getMatchTime()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getLeague()).append(getHomeTeam()).append(getAwayTeam()).append(getHomeOdds()).append(getDrawOdds()).append(getAwayOdds()).append(getMatchTime()).toHashCode();
    }

    public static final class MatchCreateResponseBuilder {
        private Long id;
        private String league;
        private String homeTeam;
        private String awayTeam;
        private float homeOdds;
        private float drawOdds;
        private float awayOdds;
        private Date matchTime;

        private MatchCreateResponseBuilder() {
        }

        public static MatchCreateResponseBuilder aMatchResponse() {
            return new MatchCreateResponseBuilder();
        }

        public MatchCreateResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MatchCreateResponseBuilder league(String league) {
            this.league = league;
            return this;
        }

        public MatchCreateResponseBuilder homeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public MatchCreateResponseBuilder awayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public MatchCreateResponseBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchCreateResponseBuilder drawOdds(float drawOdds) {
            this.drawOdds = drawOdds;
            return this;
        }

        public MatchCreateResponseBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchCreateResponseBuilder matchTime(Date matchTime) {
            this.matchTime = matchTime;
            return this;
        }

        public MatchCreateResponse build() {
            MatchCreateResponse matchCreateResponse = new MatchCreateResponse();
            matchCreateResponse.setId(id);
            matchCreateResponse.setLeague(league);
            matchCreateResponse.setHomeTeam(homeTeam);
            matchCreateResponse.setAwayTeam(awayTeam);
            matchCreateResponse.setHomeOdds(homeOdds);
            matchCreateResponse.setDrawOdds(drawOdds);
            matchCreateResponse.setAwayOdds(awayOdds);
            matchCreateResponse.setMatchTime(matchTime);
            return matchCreateResponse;
        }
    }
}
