package com.bilyoner.livebettingapp.service;

import com.bilyoner.livebettingapp.model.entity.Bet;
import com.bilyoner.livebettingapp.model.entity.Coupon;
import com.bilyoner.livebettingapp.model.entity.Player;
import com.bilyoner.livebettingapp.model.exception.BusinessException;
import com.bilyoner.livebettingapp.model.request.CouponCreateRequest;
import com.bilyoner.livebettingapp.model.request.PlayerCreateRequest;
import com.bilyoner.livebettingapp.model.response.CouponCreateResponse;
import com.bilyoner.livebettingapp.repository.CouponRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bilyoner.livebettingapp.model.entity.Match.MatchBuilder.aMatch;
import static com.bilyoner.livebettingapp.model.entity.Player.PlayerBuilder.aPlayer;

@Service
public class CouponService {

    private final CouponRepository couponRepository;
    private final BetService betService;
    private final PlayerService playerService;

    public CouponService(CouponRepository couponRepository, BetService betService, PlayerService playerService) {
        this.couponRepository = couponRepository;
        this.betService = betService;
        this.playerService = playerService;
    }
    public List<CouponCreateResponse> getCoupons() {
        List<Coupon> coupons = couponRepository.findAll();

        return coupons
                .stream()
                .map(coupon -> CouponCreateResponse.createFrom(coupon, getBets(coupon)))
                .collect(Collectors.toList());
    }

    public CouponCreateResponse getCoupon(Long id) {
        final var coupon = couponRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Coupon not found"));
        final var betList = getBets(coupon);

        return CouponCreateResponse.createFrom(coupon, betList);
    }

    private Set<Bet> getBets(Coupon coupon) {
        return coupon.getBetList().stream()
                .map(betService::getBetById)
                .collect(Collectors.toSet());
    }

    public Coupon getCouponById(Long id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Coupon not found"));
    }

    @Transactional
    public void save(CouponCreateRequest request) throws InterruptedException {
        assertMaximumMultiplier(request);

        final var betList = request.getBetList()
                .stream()
                .map(betService::save)
                .collect(Collectors.toSet());

        couponRepository.save(request.toCoupon(betList));
    }

    private void assertMaximumMultiplier(CouponCreateRequest request) {
        if (request.getMultiplier() > 500 ) {
            throw new BusinessException("Çoklu kupon miktarı 500'den fazla olamaz.");
        }
    }
}
