package com.bilyoner.livebettingapp.model.entity;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "coupon_bet_list",
            joinColumns = @JoinColumn(name = "coupon_id"),
            foreignKey = @ForeignKey(name = "fk_coupon_bet_list")
    )
    @Column(name = "bet_id")
    private Set<Long> betList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "coupon_player", referencedColumnName = "id")
    private Player playerId;

    @Column(name = "creation_date")
    private Date creationDate = new Date();

    @Column(name = "amount")
    private float amount;

    @Column(name = "multiplier")
    private int multiplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Long> getBetList() {
        return betList;
    }

    public void setBetList(Set<Long> betList) {
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

        Coupon coupon = (Coupon) o;

        return new EqualsBuilder().append(getAmount(), coupon.getAmount()).append(getMultiplier(), coupon.getMultiplier()).append(getId(), coupon.getId()).append(getBetList(), coupon.getBetList()).append(getPlayerId(), coupon.getPlayerId()).append(getCreationDate(), coupon.getCreationDate()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).append(getBetList()).append(getPlayerId()).append(getCreationDate()).append(getAmount()).append(getMultiplier()).toHashCode();
    }

    public static final class CouponBuilder {
        private Long id;
        private Set<Long> betList;
        private Player playerId;
        private Date creationDate;
        private float amount;
        private int multiplier;

        private CouponBuilder() {
        }

        public static CouponBuilder aCoupon() {
            return new CouponBuilder();
        }

        public CouponBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CouponBuilder betList(Set<Long> betList) {
            this.betList = betList;
            return this;
        }

        public CouponBuilder playerId(Player playerId) {
            this.playerId = playerId;
            return this;
        }

        public CouponBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public CouponBuilder amount(float amount) {
            this.amount = amount;
            return this;
        }

        public CouponBuilder multiplier(int multiplier) {
            this.multiplier = multiplier;
            return this;
        }

        public Coupon build() {
            Coupon coupon = new Coupon();
            coupon.setId(id);
            coupon.setBetList(betList);
            coupon.setPlayerId(playerId);
            coupon.setCreationDate(creationDate);
            coupon.setAmount(amount);
            coupon.setMultiplier(multiplier);
            return coupon;
        }
    }
}