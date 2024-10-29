package com.bilyoner.livebettingapp.model.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

@Entity
@Table(name = "match_history")
public class MatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "match_odd_history", referencedColumnName = "id")
    private Match match;

    @Column(name = "home_odds")
    private float homeOdds;

    @Column(name = "draw_odds")
    private float drawOdds;

    @Column(name = "away_odds")
    private float awayOdds;

    @Column(name = "creation_date")
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MatchHistory that = (MatchHistory) o;

        return new EqualsBuilder().append(getHomeOdds(), that.getHomeOdds()).append(getDrawOdds(), that.getDrawOdds()).append(getAwayOdds(), that.getAwayOdds()).append(getId(), that.getId()).append(getMatch(), that.getMatch()).append(getCreationDate(), that.getCreationDate()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getMatch()).append(getHomeOdds()).append(getDrawOdds()).append(getAwayOdds()).append(getCreationDate()).toHashCode();
    }

    public static final class MatchHistoryBuilder {
        private Long id;
        private Match match;
        private float homeOdds;
        private float drawOdds;
        private float awayOdds;
        private Date creationDate;

        private MatchHistoryBuilder() {
        }

        public static MatchHistoryBuilder aMatchHistory() {
            return new MatchHistoryBuilder();
        }

        public MatchHistoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MatchHistoryBuilder match(Match match) {
            this.match = match;
            return this;
        }

        public MatchHistoryBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchHistoryBuilder drawOdds(float drawOdds) {
            this.drawOdds = drawOdds;
            return this;
        }

        public MatchHistoryBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchHistoryBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public MatchHistory build() {
            MatchHistory matchHistory = new MatchHistory();
            matchHistory.setId(id);
            matchHistory.setMatch(match);
            matchHistory.setHomeOdds(homeOdds);
            matchHistory.setDrawOdds(drawOdds);
            matchHistory.setAwayOdds(awayOdds);
            matchHistory.setCreationDate(creationDate);
            return matchHistory;
        }
    }
}