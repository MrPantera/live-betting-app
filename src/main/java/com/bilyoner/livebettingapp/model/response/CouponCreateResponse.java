package com.bilyoner.livebettingapp.model.response;

import com.bilyoner.livebettingapp.model.entity.Bet;
import com.bilyoner.livebettingapp.model.entity.Coupon;
import com.bilyoner.livebettingapp.model.entity.Player;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bilyoner.livebettingapp.model.response.CouponCreateResponse.CouponCreateResponseBuilder.aCouponCreateResponse;

public class CouponCreateResponse {

    private Long id;
    private Set<BetCreateResponse> betList;
    private Player playerId;
    private Date creationDate;
    private float amount;
    private int multiplier;

    public static CouponCreateResponse createFrom(Coupon coupon, Set<Bet> betList) {
        return aCouponCreateResponse()
                .id(coupon.getId())
                .betList(betList.stream().map(BetCreateResponse::createFrom).collect(Collectors.toSet()))
                .playerId(coupon.getPlayerId())
                .creationDate(coupon.getCreationDate())
                .amount(coupon.getAmount())
                .multiplier(coupon.getMultiplier())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BetCreateResponse> getBetList() {
        return betList;
    }

    public void setBetList(Set<BetCreateResponse> betList) {
        this.betList = betList;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CouponCreateResponse that = (CouponCreateResponse) o;

        return new EqualsBuilder().append(getAmount(), that.getAmount()).append(getMultiplier(), that.getMultiplier()).append(getId(), that.getId()).append(getBetList(), that.getBetList()).append(getPlayerId(), that.getPlayerId()).append(getCreationDate(), that.getCreationDate()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getBetList()).append(getPlayerId()).append(getCreationDate()).append(getAmount()).append(getMultiplier()).toHashCode();
    }

    public static final class CouponCreateResponseBuilder {
        private Long id;
        private Set<BetCreateResponse> betList;
        private Player playerId;
        private Date creationDate;
        private float amount;
        private int multiplier;

        private CouponCreateResponseBuilder() {
        }

        public static CouponCreateResponseBuilder aCouponCreateResponse() {
            return new CouponCreateResponseBuilder();
        }

        public CouponCreateResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CouponCreateResponseBuilder betList(Set<BetCreateResponse> betList) {
            this.betList = betList;
            return this;
        }

        public CouponCreateResponseBuilder playerId(Player playerId) {
            this.playerId = playerId;
            return this;
        }

        public CouponCreateResponseBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public CouponCreateResponseBuilder amount(float amount) {
            this.amount = amount;
            return this;
        }

        public CouponCreateResponseBuilder multiplier(int multiplier) {
            this.multiplier = multiplier;
            return this;
        }

        public CouponCreateResponse build() {
            CouponCreateResponse couponCreateResponse = new CouponCreateResponse();
            couponCreateResponse.setId(id);
            couponCreateResponse.setBetList(betList);
            couponCreateResponse.setPlayerId(playerId);
            couponCreateResponse.setCreationDate(creationDate);
            couponCreateResponse.setAmount(amount);
            couponCreateResponse.setMultiplier(multiplier);
            return couponCreateResponse;
        }
    }
}