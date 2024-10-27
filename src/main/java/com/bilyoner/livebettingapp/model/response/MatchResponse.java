package com.bilyoner.livebettingapp.model.response;

import com.bilyoner.livebettingapp.model.entity.Match;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.bilyoner.livebettingapp.model.response.MatchResponse.MatchResponseBuilder.aMatchResponse;
import java.util.Date;

public class MatchResponse {

    private Long id;
    private String league;
    private String homeTeam;
    private String awayTeam;
    private float homeOdds;
    private float awayOdds;
    private Date matchTime;

    public static MatchResponse createFrom(Match match) {
        return aMatchResponse()
                .id(match.getId())
                .league(match.getLeague())
                .homeTeam(match.getHomeTeam())
                .awayTeam(match.getAwayTeam())
                .homeOdds(match.getHomeOdds())
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

        MatchResponse that = (MatchResponse) o;

        return new EqualsBuilder().append(getId(), that.getId()).append(getLeague(), that.getLeague()).append(getHomeTeam(), that.getHomeTeam()).append(getAwayTeam(), that.getAwayTeam()).append(getHomeOdds(), that.getHomeOdds()).append(getAwayOdds(), that.getAwayOdds()).append(getMatchTime(), that.getMatchTime()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getLeague()).append(getHomeTeam()).append(getAwayTeam()).append(getHomeOdds()).append(getAwayOdds()).append(getMatchTime()).toHashCode();
    }

    public static final class MatchResponseBuilder {
        private Long id;
        private String league;
        private String homeTeam;
        private String awayTeam;
        private float homeOdds;
        private float awayOdds;
        private Date matchTime;

        private MatchResponseBuilder() {
        }

        public static MatchResponseBuilder aMatchResponse() {
            return new MatchResponseBuilder();
        }

        public MatchResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public MatchResponseBuilder league(String league) {
            this.league = league;
            return this;
        }

        public MatchResponseBuilder homeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public MatchResponseBuilder awayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public MatchResponseBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchResponseBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchResponseBuilder matchTime(Date matchTime) {
            this.matchTime = matchTime;
            return this;
        }

        public MatchResponse build() {
            MatchResponse matchResponse = new MatchResponse();
            matchResponse.setId(id);
            matchResponse.setLeague(league);
            matchResponse.setHomeTeam(homeTeam);
            matchResponse.setAwayTeam(awayTeam);
            matchResponse.setHomeOdds(homeOdds);
            matchResponse.setAwayOdds(awayOdds);
            matchResponse.setMatchTime(matchTime);

            return matchResponse;
        }
    }
}
