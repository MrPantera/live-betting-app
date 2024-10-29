package com.bilyoner.livebettingapp.model.request;

import com.bilyoner.livebettingapp.model.entity.Match;
import com.bilyoner.livebettingapp.model.entity.MatchHistory;

import java.util.Date;

import static com.bilyoner.livebettingapp.model.entity.MatchHistory.MatchHistoryBuilder.aMatchHistory;


public class MatchHistoryCreateRequest {

    private Long matchId;
    private float homeOdds;
    private float drawOdds;
    private float awayOdds;
    private Date creationDate;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
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

    public MatchHistory toMatchHistory(Match match) {
        return aMatchHistory()

                .build();
    }

    public static final class MatchHistoryCreateRequestBuilder {
        private Long matchId;
        private float homeOdds;
        private float drawOdds;
        private float awayOdds;
        private Date creationDate;

        private MatchHistoryCreateRequestBuilder() {
        }

        public static MatchHistoryCreateRequestBuilder aMatchHistoryCreateRequest() {
            return new MatchHistoryCreateRequestBuilder();
        }

        public MatchHistoryCreateRequestBuilder matchId(Long matchId) {
            this.matchId = matchId;
            return this;
        }

        public MatchHistoryCreateRequestBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchHistoryCreateRequestBuilder drawOdds(float drawOdds) {
            this.drawOdds = drawOdds;
            return this;
        }

        public MatchHistoryCreateRequestBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchHistoryCreateRequestBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public MatchHistoryCreateRequest build() {
            MatchHistoryCreateRequest matchHistoryCreateRequest = new MatchHistoryCreateRequest();
            matchHistoryCreateRequest.setMatchId(matchId);
            matchHistoryCreateRequest.setHomeOdds(homeOdds);
            matchHistoryCreateRequest.setDrawOdds(drawOdds);
            matchHistoryCreateRequest.setAwayOdds(awayOdds);
            matchHistoryCreateRequest.setCreationDate(creationDate);
            return matchHistoryCreateRequest;
        }
    }
}
