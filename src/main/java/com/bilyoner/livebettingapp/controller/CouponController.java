package com.bilyoner.livebettingapp.controller;

import com.bilyoner.livebettingapp.model.entity.Coupon;
import com.bilyoner.livebettingapp.model.request.CouponCreateRequest;
import com.bilyoner.livebettingapp.model.response.CouponCreateResponse;
import com.bilyoner.livebettingapp.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/coupons")
@RestController
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }
    @GetMapping()
    public List<CouponCreateResponse> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/{id}")
    public CouponCreateResponse getCoupons(@PathVariable Long id) {
        return couponService.getCoupon(id);
    }

    @PostMapping()
    public void save(@RequestBody CouponCreateRequest request) throws InterruptedException {
        couponService.save(request);
    }
}