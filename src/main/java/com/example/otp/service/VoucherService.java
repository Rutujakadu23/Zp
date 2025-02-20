package com.example.otp.service;

import com.example.otp.model.Voucher;
import com.example.otp.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    // Add or update voucher
    public Voucher saveVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    // Get all vouchers
    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    // Get voucher by ID
    public Voucher getVoucherById(Long id) {
        return voucherRepository.findById(id).orElse(null);
    }

    // Delete voucher by ID
    public void deleteVoucher(Long id) {
        voucherRepository.deleteById(id);
    }
}
