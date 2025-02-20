package com.example.otp.service;

import com.example.otp.model.Coupon;
import com.example.otp.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    // Add or update coupon
    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    // Get all coupons
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    // Get coupon by ID
    public Coupon getCouponById(Long id) {
        return couponRepository.findById(id).orElse(null);
    }

    // Delete coupon by ID
    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }
}

