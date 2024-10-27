package com.bilyoner.livebettingapp.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "")
    private Bet bets;


}