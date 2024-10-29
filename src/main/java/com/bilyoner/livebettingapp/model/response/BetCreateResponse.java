package com.bilyoner.livebettingapp.model.response;

import com.bilyoner.livebettingapp.model.entity.Bet;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.bilyoner.livebettingapp.model.response.BetCreateResponse.BetCreateResponseBuilder.aBetCreateResponse;

public class BetCreateResponse {

    private Long id;
    private Long matchHistoryId;
    private String prediction;
    private Float odds;

    public static BetCreateResponse createFrom(Bet bet) {
        return aBetCreateResponse()
                .id(bet.getId())
                .matchHistoryId(bet.getMatchHistory().getId())
                .prediction(bet.getPrediction())
                .odds(bet.getOdds())
                .build();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchHistoryId() {
        return matchHistoryId;
    }

    public void setMatchHistoryId(Long matchHistoryId) {
        this.matchHistoryId = matchHistoryId;
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

        BetCreateResponse that = (BetCreateResponse) o;

        return new EqualsBuilder().append(getId(), that.getId()).append(getMatchHistoryId(), that.getMatchHistoryId()).append(getPrediction(), that.getPrediction()).append(getOdds(), that.getOdds()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getMatchHistoryId()).append(getPrediction()).append(getOdds()).toHashCode();
    }

    public static final class BetCreateResponseBuilder {
        private Long id;
        private Long matchHistoryId;
        private String prediction;
        private Float odds;

        private BetCreateResponseBuilder() {
        }

        public static BetCreateResponseBuilder aBetCreateResponse() {
            return new BetCreateResponseBuilder();
        }

        public BetCreateResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BetCreateResponseBuilder matchHistoryId(Long matchHistoryId) {
            this.matchHistoryId = matchHistoryId;
            return this;
        }

        public BetCreateResponseBuilder prediction(String prediction) {
            this.prediction = prediction;
            return this;
        }

        public BetCreateResponseBuilder odds(Float odds) {
            this.odds = odds;
            return this;
        }

        public BetCreateResponse build() {
            BetCreateResponse betCreateResponse = new BetCreateResponse();
            betCreateResponse.setId(id);
            betCreateResponse.setMatchHistoryId(matchHistoryId);
            betCreateResponse.setPrediction(prediction);
            betCreateResponse.setOdds(odds);
            return betCreateResponse;
        }
    }
}
