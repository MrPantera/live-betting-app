package com.bilyoner.livebettingapp.model.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "bet")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_bet", referencedColumnName = "id")
    private MatchHistory matchHistory;

    @Column(name = "prediction")
    private String prediction;

    @Column(name = "odds")
    private Float odds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(MatchHistory matchHistory) {
        this.matchHistory = matchHistory;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public Float getOdds() {
        return odds;
    }

    public void setOdds(Float odds) {
        this.odds = odds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        return new EqualsBuilder().append(getId(), bet.getId()).append(getMatchHistory(), bet.getMatchHistory()).append(getPrediction(), bet.getPrediction()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getMatchHistory()).append(getPrediction()).toHashCode();
    }

    public static final class BetBuilder {
        private Long id;
        private MatchHistory matchHistory;
        private String prediction;
        private Float odds;

        private BetBuilder() {
        }

        public static BetBuilder aBet() {
            return new BetBuilder();
        }

        public BetBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BetBuilder matchHistory(MatchHistory matchHistory) {
            this.matchHistory = matchHistory;
            return this;
        }

        public BetBuilder prediction(String prediction) {
            this.prediction = prediction;
            return this;
        }

        public BetBuilder odds(Float odds) {
            this.odds = odds;
            return this;
        }

        public Bet build() {
            Bet bet = new Bet();
            bet.setId(id);
            bet.setMatchHistory(matchHistory);
            bet.setPrediction(prediction);
            bet.setOdds(odds);
            return bet;
        }
    }
}
