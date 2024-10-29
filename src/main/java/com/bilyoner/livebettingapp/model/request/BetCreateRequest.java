package com.bilyoner.livebettingapp.model.request;

import com.bilyoner.livebettingapp.model.entity.Bet;
import com.bilyoner.livebettingapp.model.entity.MatchHistory;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static com.bilyoner.livebettingapp.model.entity.Bet.BetBuilder.aBet;


public class BetCreateRequest {
    private Long matchHistoryId;
    private String prediction;

    public Bet toBet(MatchHistory matchHistory, Float odds) {
        return aBet()
                .matchHistory(matchHistory)
                .prediction(prediction)
                .odds(odds)
                .build();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BetCreateRequest that = (BetCreateRequest) o;

        return new EqualsBuilder().append(getMatchHistoryId(), that.getMatchHistoryId()).append(getPrediction(), that.getPrediction()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getMatchHistoryId()).append(getPrediction()).toHashCode();
    }

    public static final class BetCreateRequestBuilder {
        private Long matchHistoryId;
        private String prediction;

        private BetCreateRequestBuilder() {
        }

        public static BetCreateRequestBuilder aBetCreateRequest() {
            return new BetCreateRequestBuilder();
        }

        public BetCreateRequestBuilder matchHistoryId(Long matchHistoryId) {
            this.matchHistoryId = matchHistoryId;
            return this;
        }

        public BetCreateRequestBuilder prediction(String prediction) {
            this.prediction = prediction;
            return this;
        }

        public BetCreateRequest build() {
            BetCreateRequest betCreateRequest = new BetCreateRequest();
            betCreateRequest.setMatchHistoryId(matchHistoryId);
            betCreateRequest.setPrediction(prediction);
            return betCreateRequest;
        }
    }
}
