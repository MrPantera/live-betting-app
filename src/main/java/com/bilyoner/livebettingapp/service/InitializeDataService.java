package com.bilyoner.livebettingapp.service;

import com.bilyoner.livebettingapp.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static com.bilyoner.livebettingapp.model.entity.Bet.BetBuilder.aBet;
import static com.bilyoner.livebettingapp.model.entity.Coupon.CouponBuilder.aCoupon;
import static com.bilyoner.livebettingapp.model.entity.Match.MatchBuilder.aMatch;
import static com.bilyoner.livebettingapp.model.entity.MatchHistory.MatchHistoryBuilder.aMatchHistory;
import static com.bilyoner.livebettingapp.model.entity.Player.PlayerBuilder.aPlayer;

@Service
public class InitializeDataService {

    private final BetRepository betRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final MatchHistoryRepository matchHistoryRepository;
    private final CouponRepository couponRepository;

    public InitializeDataService(BetRepository betRepository, PlayerRepository playerRepository, MatchRepository matchRepository, MatchHistoryRepository matchHistoryRepository, CouponRepository couponRepository) {
        this.betRepository = betRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.matchHistoryRepository = matchHistoryRepository;
        this.couponRepository = couponRepository;
    }

    public void initializeData() {
        createDummyData();
    }

    private void createDummyData() {

        final var player1 = aPlayer()
                .name("Ömer")
                .surname("Kaya")
                .accountBalance(999)
                .build();

        final var player2 = aPlayer()
                .name("BİLYONER")
                .surname("TEST")
                .build();

        final var match1 = aMatch()
                .league("Süper Lig")
                .homeTeam("Galatasaray")
                .awayTeam("Fenerbahçe")
                .homeOdds(2.0F)
                .drawOdds(3.0F)
                .awayOdds(2.0F)
                .matchTime(new Date())
                .build();

        final var match2 = aMatch()
                .league("Premier League")
                .homeTeam("Arsenal")
                .awayTeam("Chelsea")
                .homeOdds(1.4F)
                .drawOdds(3.4F)
                .awayOdds(4.5F)
                .matchTime(new Date())
                .build();

        final var match3 = aMatch()
                .league("La Liga")
                .homeTeam("Barcelona")
                .awayTeam("Real Madrid")
                .homeOdds(2.1F)
                .drawOdds(2.8F)
                .awayOdds(2.7F)
                .matchTime(new Date())
                .build();

        final var matchHistory1 = aMatchHistory()
                .match(match1)
                .homeOdds(2.0F)
                .drawOdds(3.0F)
                .awayOdds(2.0F)
                .creationDate(new Date())
                .build();

        final var matchHistory2 = aMatchHistory()
                .match(match3)
                .homeOdds(1.4F)
                .drawOdds(3.4F)
                .awayOdds(4.5F)
                .creationDate(new Date())
                .build();

        final var matchHistory3 = aMatchHistory()
                .match(match2)
                .homeOdds(2.1F)
                .drawOdds(2.8F)
                .awayOdds(2.7F)
                .creationDate(new Date())
                .build();

        final var bet1 = aBet()
                .matchHistory(matchHistory1)
                .prediction("HOME")
                .odds(2.0F)
                .build();

        final var bet2 = aBet()
                .matchHistory(matchHistory1)
                .prediction("DRAW")
                .odds(3.4F)
                .build();

        final var bet3 = aBet()
                .matchHistory(matchHistory1)
                .prediction("AWAY")
                .odds(2.7F)
                .build();

        final var coupon1 = aCoupon()
                .betList(Set.of(1L, 2L))
                .amount(100F)
                .playerId(player1)
                .creationDate(new Date())
                .multiplier(25)
                .build();


        final var coupon2 = aCoupon()
                .betList(Set.of(3L))
                .amount(50F)
                .playerId(player2)
                .creationDate(new Date())
                .multiplier(1)
                .build();

        playerRepository.saveAll(List.of(player1, player2));
        matchRepository.saveAll(List.of(match1, match2, match3));
        matchHistoryRepository.saveAll(List.of(matchHistory1, matchHistory2, matchHistory3));
        betRepository.saveAll(List.of(bet1, bet2, bet3));
        couponRepository.saveAll(List.of(coupon1, coupon2));
    }
}
