package com.example.be_duantn.repository.mua_hang_oneline_repository.hoa_don_repository;

import com.example.be_duantn.entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan, UUID> {
}