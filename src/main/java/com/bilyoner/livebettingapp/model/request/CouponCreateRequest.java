package com.bilyoner.livebettingapp.model.request;

import com.bilyoner.livebettingapp.model.entity.Bet;
import com.bilyoner.livebettingapp.model.entity.Coupon;
import com.bilyoner.livebettingapp.model.entity.Player;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bilyoner.livebettingapp.model.entity.Coupon.CouponBuilder.aCoupon;


public class CouponCreateRequest {

    private Set<BetCreateRequest> betList;
    private Player playerId;
    private float amount;
    private int multiplier;
    private Date creationDate = new Date();

    public Coupon toCoupon(Set<Bet> betList) {
        final var bets = betList
                .stream()
                .map(bet -> BigDecimal.valueOf(bet.getOdds()))
                .reduce(BigDecimal.ONE, BigDecimal::multiply)
                .floatValue();

        return aCoupon()
                .betList(betList.stream().map(Bet::getId).collect(Collectors.toSet()))
                .playerId(playerId)
                .amount(amount)
                .creationDate(creationDate)
                .multiplier(multiplier)
                .build();
    }

    public Set<BetCreateRequest> getBetList() {
        return betList;
    }

    public void setBetList(Set<BetCreateRequest> betList) {
        this.betList = betList;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
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

        CouponCreateRequest that = (CouponCreateRequest) o;

        return new EqualsBuilder().append(getAmount(), that.getAmount()).append(getMultiplier(), that.getMultiplier()).append(getBetList(), that.getBetList()).append(getPlayerId(), that.getPlayerId()).append(getCreationDate(), that.getCreationDate()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getBetList()).append(getPlayerId()).append(getAmount()).append(getMultiplier()).append(getCreationDate()).toHashCode();
    }

    public static final class CouponCreateRequestBuilder {
        private Set<BetCreateRequest> betList;
        private Player playerId;
        private float amount;
        private int multiplier;
        private Date creationDate;

        private CouponCreateRequestBuilder() {
        }

        public static CouponCreateRequestBuilder aCouponCreateRequest() {
            return new CouponCreateRequestBuilder();
        }

        public CouponCreateRequestBuilder betList(Set<BetCreateRequest> betList) {
            this.betList = betList;
            return this;
        }

        public CouponCreateRequestBuilder playerId(Player playerId) {
            this.playerId = playerId;
            return this;
        }

        public CouponCreateRequestBuilder amount(float amount) {
            this.amount = amount;
            return this;
        }

        public CouponCreateRequestBuilder multiplier(int multiplier) {
            this.multiplier = multiplier;
            return this;
        }

        public CouponCreateRequestBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public CouponCreateRequest build() {
            CouponCreateRequest couponCreateRequest = new CouponCreateRequest();
            couponCreateRequest.setBetList(betList);
            couponCreateRequest.setPlayerId(playerId);
            couponCreateRequest.setAmount(amount);
            couponCreateRequest.setMultiplier(multiplier);
            couponCreateRequest.setCreationDate(creationDate);
            return couponCreateRequest;
        }
    }
}
