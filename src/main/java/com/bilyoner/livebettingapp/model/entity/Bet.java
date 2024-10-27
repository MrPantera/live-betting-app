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
    private Match match;

    @Column(name = "prediction")
    private String prediction;

    @Column(name = "odds")
    private String odds;

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

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        return new EqualsBuilder().append(getId(), bet.getId()).append(getMatch(), bet.getMatch()).append(getPrediction(), bet.getPrediction()).append(getOdds(), bet.getOdds()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getMatch()).append(getPrediction()).append(getOdds()).toHashCode();
    }

    public static final class BetBuilder {
        private Long id;
        private Match match;
        private String prediction;
        private String odds;

        private BetBuilder() {
        }

        public static BetBuilder aBet() {
            return new BetBuilder();
        }

        public BetBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BetBuilder match(Match match) {
            this.match = match;
            return this;
        }

        public BetBuilder prediction(String prediction) {
            this.prediction = prediction;
            return this;
        }

        public BetBuilder odds(String odds) {
            this.odds = odds;
            return this;
        }

        public Bet build() {
            Bet Match = new Bet();
            Match.setId(id);
            Match.setMatch(match);
            Match.setPrediction(prediction);
            Match.setOdds(odds);

            return Match;
        }
    }

}
