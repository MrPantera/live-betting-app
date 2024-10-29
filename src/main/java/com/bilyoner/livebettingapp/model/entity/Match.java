package com.bilyoner.livebettingapp.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "league")
    private String league;

    @Column(name = "home_team")
    private String homeTeam;

    @Column(name = "away_team")
    private String awayTeam;

    @Column(name = "home_odds")
    private float homeOdds;

    @Column(name = "draw_odds")
    private float drawOdds;

    @Column(name = "away_odds")
    private float awayOdds;

    @Column(name = "match_time")
    private Date matchTime;

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

        Match match = (Match) o;

        return new EqualsBuilder().append(getId(), match.getId()).append(getLeague(), match.getLeague()).append(getHomeTeam(), match.getHomeTeam()).append(getAwayTeam(), match.getAwayTeam()).append(getHomeOdds(), match.getHomeOdds()).append(getAwayOdds(), match.getAwayOdds()).append(getMatchTime(), match.getMatchTime()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getLeague()).append(getHomeTeam()).append(getAwayTeam()).append(getHomeOdds()).append(getAwayOdds()).append(getMatchTime()).toHashCode();
    }

    public static final class MatchBuilder {
        private Long id;
        private String league;
        private String homeTeam;
        private String awayTeam;
        private float homeOdds;
        private float drawOdds;
        private float awayOdds;
        private Date matchTime;

        private MatchBuilder() {
        }

        public static MatchBuilder aMatch() {
            return new MatchBuilder();
        }

        public MatchBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MatchBuilder league(String league) {
            this.league = league;
            return this;
        }

        public MatchBuilder homeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public MatchBuilder awayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public MatchBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchBuilder drawOdds(float drawOdds) {
            this.drawOdds = drawOdds;
            return this;
        }

        public MatchBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchBuilder matchTime(Date matchTime) {
            this.matchTime = matchTime;
            return this;
        }

        public Match build() {
            Match match = new Match();
            match.setId(id);
            match.setLeague(league);
            match.setHomeTeam(homeTeam);
            match.setAwayTeam(awayTeam);
            match.setHomeOdds(homeOdds);
            match.setDrawOdds(drawOdds);
            match.setAwayOdds(awayOdds);
            match.setMatchTime(matchTime);
            return match;
        }
    }
}