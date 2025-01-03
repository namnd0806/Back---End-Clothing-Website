package com.example.be_duantn.repository.ban_hang_tai_quay_repository;

import com.example.be_duantn.dto.respon.ban_tai_quay_respon.LoadHDCTTaiQuay;
import com.example.be_duantn.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GiohangChiTietBanTaiQuayRepository extends JpaRepository<GioHangChiTiet, UUID> {
    // finBy ghct theo idgh dùng cho giỏ hàng chi tiết và hóa đơn
    List<GioHangChiTiet> findByGiohang_Idgh(UUID idgh);

    // load giỏ hàng chi tiết tại quầy theo idgh của khác
    @Query(value = "SELECT ghct.Id AS Idghct, ghct.DonGia, ghct.DonGiaKhiGiam, ghct.SoLuong, sp.Id AS Idsp, sp.TenSP, sp.ImageDefaul, ms.TenMauSac, s.TenSize, cl.TenChatLieu, spct.SoLuongTon FROM GioHangChiTiet ghct\n" +
            "       JOIN GioHang gh on gh.Id = ghct.IdGH\n" +
            "       JOIN SanPhamChiTiet spct on spct.Id = ghct.IdSPCT\n" +
            "       JOIN MauSac ms on ms.Id = spct.IdMS\n" +
            "       JOIN Size s on s.Id = spct.IdSize\n" +
            "       JOIN SanPham sp on sp.Id = spct.IdSP\n" +
            "       JOIN ChatLieu cl on cl.Id = sp.IdCL\n" +
            "       Where ghct.SoLuong > 0 AND gh.TrangThai = 1\n" +
            "       AND gh.Id = ?",nativeQuery = true)
    List<LoadHDCTTaiQuay> loadGHCTBanTaiQuay(UUID idgh);

    // finBy ghct theo idgh và idspct bán hàng tại quầy
    GioHangChiTiet findByGiohang_IdghAndSanphamchitiet_Idspct(UUID idgh, UUID idspct);

}
