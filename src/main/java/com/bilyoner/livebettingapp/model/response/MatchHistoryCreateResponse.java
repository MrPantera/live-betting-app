package com.bilyoner.livebettingapp.model.response;

import com.bilyoner.livebettingapp.model.entity.*;
import com.bilyoner.livebettingapp.repository.MatchHistoryRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bilyoner.livebettingapp.model.response.CouponCreateResponse.CouponCreateResponseBuilder.aCouponCreateResponse;
import static com.bilyoner.livebettingapp.model.response.MatchHistoryCreateResponse.MatchHistoryCreateResponseBuilder.aMatchHistoryResponse;

public class MatchHistoryCreateResponse {
    private Long id;
    private Match matchId;
    private float homeOdds;
    private float drawOdds;
    private float awayOdds;
    private Date creationDate;

    public static MatchHistoryCreateResponse createFrom(MatchHistory matchHistory) {
        return aMatchHistoryResponse()
                .id(matchHistory.getId())
                .matchId(matchHistory.getMatch())
                .homeOdds(matchHistory.getHomeOdds())
                .drawOdds(matchHistory.getDrawOdds())
                .awayOdds(matchHistory.getAwayOdds())
                .creationDate(matchHistory.getCreationDate())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatchId() {
        return matchId;
    }

    public void setMatchId(Match matchId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MatchHistoryCreateResponse that = (MatchHistoryCreateResponse) o;

        return new EqualsBuilder().append(getHomeOdds(), that.getHomeOdds()).append(getDrawOdds(), that.getDrawOdds()).append(getAwayOdds(), that.getAwayOdds()).append(getId(), that.getId()).append(getMatchId(), that.getMatchId()).append(getCreationDate(), that.getCreationDate()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getMatchId()).append(getHomeOdds()).append(getDrawOdds()).append(getAwayOdds()).append(getCreationDate()).toHashCode();
    }


    public static final class MatchHistoryCreateResponseBuilder {
        private Long id;
        private Match matchId;
        private float homeOdds;
        private float drawOdds;
        private float awayOdds;
        private Date creationDate;

        private MatchHistoryCreateResponseBuilder() {
        }

        public static MatchHistoryCreateResponseBuilder aMatchHistoryResponse() {
            return new MatchHistoryCreateResponseBuilder();
        }

        public MatchHistoryCreateResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MatchHistoryCreateResponseBuilder matchId(Match matchId) {
            this.matchId = matchId;
            return this;
        }

        public MatchHistoryCreateResponseBuilder homeOdds(float homeOdds) {
            this.homeOdds = homeOdds;
            return this;
        }

        public MatchHistoryCreateResponseBuilder drawOdds(float drawOdds) {
            this.drawOdds = drawOdds;
            return this;
        }

        public MatchHistoryCreateResponseBuilder awayOdds(float awayOdds) {
            this.awayOdds = awayOdds;
            return this;
        }

        public MatchHistoryCreateResponseBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public MatchHistoryCreateResponse build() {
            MatchHistoryCreateResponse matchHistoryCreateResponse = new MatchHistoryCreateResponse();
            matchHistoryCreateResponse.setId(id);
            matchHistoryCreateResponse.setMatchId(matchId);
            matchHistoryCreateResponse.setHomeOdds(homeOdds);
            matchHistoryCreateResponse.setDrawOdds(drawOdds);
            matchHistoryCreateResponse.setAwayOdds(awayOdds);
            matchHistoryCreateResponse.setCreationDate(creationDate);
            return matchHistoryCreateResponse;
        }
    }
}