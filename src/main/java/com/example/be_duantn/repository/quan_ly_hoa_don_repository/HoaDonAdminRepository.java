package com.example.be_duantn.repository.quan_ly_hoa_don_repository;

import com.example.be_duantn.dto.respon.quan_ly_dong_san_pham_respon.SanPhamAdminRespon;
import com.example.be_duantn.dto.respon.quan_ly_dong_san_pham_respon.SanPhamChiTietManThemHoaDonRespon;
import com.example.be_duantn.dto.respon.quan_ly_hoa_don_respon.Hoadonrespon;
import com.example.be_duantn.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface HoaDonAdminRepository extends JpaRepository<HoaDon, UUID> {
    //Lấy số hoá đơn chờ xác nhận
    @Query(value = "SELECT COUNT(DISTINCT dbo.hoadon.Id)\n" +
            "FROM dbo.hoadon\n" +
            "LEFT JOIN dbo.HoaDonChiTiet ON dbo.hoadon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN dbo.HinhThucThanhToan ON dbo.hoadon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE dbo.hoadon.TrangThai = 1;", nativeQuery = true)
    Integer TongSoHoaDonChoXacNhan();

    //Lấy số hoá đơn xác nhận
    @Query(value = "SELECT COUNT(DISTINCT dbo.hoadon.Id)\n" +
            "FROM dbo.hoadon\n" +
            "LEFT JOIN dbo.HoaDonChiTiet ON dbo.hoadon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN dbo.HinhThucThanhToan ON dbo.hoadon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE dbo.hoadon.TrangThai = 2;", nativeQuery = true)
    Integer TongSoHoaDonXacNhan();

    //Lấy số hoá đơn chờ giao
    @Query(value = "SELECT COUNT(DISTINCT dbo.hoadon.Id)\n" +
            "FROM dbo.hoadon\n" +
            "LEFT JOIN dbo.HoaDonChiTiet ON dbo.hoadon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN dbo.HinhThucThanhToan ON dbo.hoadon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE dbo.hoadon.TrangThai = 3;", nativeQuery = true)
    Integer TongSoHoaDonChoGiao();

    //Lấy số hoá đơn đang giao
    @Query(value = "SELECT COUNT(DISTINCT dbo.hoadon.Id)\n" +
            "FROM dbo.hoadon\n" +
            "LEFT JOIN dbo.HoaDonChiTiet ON dbo.hoadon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN dbo.HinhThucThanhToan ON dbo.hoadon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE dbo.hoadon.TrangThai = 4;", nativeQuery = true)
    Integer TongSoHoaDonDangGiao();

    //Lấy số hoá đơn hoàn thành
    @Query(value = "SELECT COUNT(DISTINCT dbo.hoadon.Id)\n" +
            "FROM dbo.hoadon\n" +
            "LEFT JOIN dbo.HoaDonChiTiet ON dbo.hoadon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN dbo.HinhThucThanhToan ON dbo.hoadon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE dbo.hoadon.TrangThai = 5;", nativeQuery = true)
    Integer TongSoHoaDonHoanThanh();

    //Lấy số hoá đơn huỷ
    @Query(value = "SELECT COUNT(DISTINCT dbo.hoadon.Id)\n" +
            "FROM dbo.hoadon\n" +
            "LEFT JOIN dbo.HoaDonChiTiet ON dbo.hoadon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN dbo.HinhThucThanhToan ON dbo.hoadon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE dbo.hoadon.TrangThai = 6;", nativeQuery = true)
    Integer TongSoHoaDonHuy();

    // load all hoá đơn
    @Query(value = "SELECT \n" +
            "    dbo.HoaDon.Id, \n" +
            "    dbo.HoaDon.MaHoaDon, \n" +
            "    dbo.HoaDon.NgayTao, \n" +
            "    dbo.HoaDon.ThanhTien, \n" +
            "    dbo.HoaDon.LoaiHoaDon, \n" +
            "    dbo.HoaDon.TrangThai, \n" +
            "    dbo.HoaDon.TenNguoiNhan, \n" +
            "    dbo.HoaDon.SDTNguoiNhan\n" +
            "FROM     \n" +
            "    dbo.HoaDon \n" +
            "LEFT JOIN\n" +
            "    dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHD\n"
            + "LEFT JOIN\n" +
            "      dbo.HinhThucThanhToan ON dbo.HoaDon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "\tGROUP BY\n" +
            "\tdbo.HoaDon.Id, \n" +
            "    dbo.HoaDon.MaHoaDon, \n" +
            "    dbo.HoaDon.NgayTao, \n" +
            "    dbo.HoaDon.ThanhTien, \n" +
            "    dbo.HoaDon.LoaiHoaDon, \n" +
            "    dbo.HoaDon.TrangThai, \n" +
            "    dbo.HoaDon.TenNguoiNhan, \n" +
            "    dbo.HoaDon.SDTNguoiNhan", nativeQuery = true)
    Page<Hoadonrespon> ShowAllHoaDon(Pageable pageable);

    // hiển thị hoá đơn theo trạng thái
    @Query(value = "SELECT\n" +
            "    dbo.HoaDon.Id,\n" +
            "    dbo.HoaDon.MaHoaDon,\n" +
            "    dbo.HoaDon.NgayTao,\n" +
            "    dbo.HoaDon.ThanhTien,\n" +
            "    dbo.HoaDon.LoaiHoaDon,\n" +
            "    dbo.HoaDon.TrangThai,\n" +
            "    dbo.HoaDon.TenNguoiNhan,\n" +
            "    dbo.HoaDon.SDTNguoiNhan\n" +
            "FROM\n" +
            "    dbo.HoaDon\n" +
            "LEFT JOIN\n" +
            "    dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHD\n" +
            "LEFT JOIN\n" +
            "    dbo.HinhThucThanhToan ON dbo.HoaDon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE\n" +
            "    dbo.HoaDon.TrangThai = :trangthai\n" +
            "GROUP BY\n" +
            "    dbo.HoaDon.Id,\n" +
            "    dbo.HoaDon.MaHoaDon,\n" +
            "    dbo.HoaDon.NgayTao,\n" +
            "    dbo.HoaDon.ThanhTien,\n" +
            "    dbo.HoaDon.LoaiHoaDon,\n" +
            "    dbo.HoaDon.TrangThai,\n" +
            "    dbo.HoaDon.TenNguoiNhan,\n" +
            "    dbo.HoaDon.SDTNguoiNhan", nativeQuery = true)
    Page<Hoadonrespon> LocHoaDonTheoTrangThai(Pageable pageable, @Param("trangthai") Integer trangthai);


    // Lọc theo Mã hd
    @Query(value = "SELECT\n" +
            "    dbo.HoaDon.Id,\n" +
            "    dbo.HoaDon.MaHoaDon,\n" +
            "    dbo.HoaDon.NgayTao,\n" +
            "    dbo.HoaDon.ThanhTien,\n" +
            "    dbo.HoaDon.LoaiHoaDon,\n" +
            "    dbo.HoaDon.TrangThai,\n" +
            "    dbo.HoaDon.TenNguoiNhan,\n" +
            "    dbo.HoaDon.SDTNguoiNhan\n" +
            "FROM\n" +
            "    dbo.HoaDon\n" +
            "LEFT JOIN\n" +
            "    dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHD\n"
            + "LEFT JOIN\n" +
            "      dbo.HinhThucThanhToan ON dbo.HoaDon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE\n" +
            "    dbo.HoaDon.MaHoaDon LIKE '%' + :mahoadon + '%'\n" +
            "GROUP BY\n" +
            "    dbo.HoaDon.Id,\n" +
            "    dbo.HoaDon.MaHoaDon,\n" +
            "    dbo.HoaDon.NgayTao,\n" +
            "    dbo.HoaDon.ThanhTien,\n" +
            "    dbo.HoaDon.LoaiHoaDon,\n" +
            "    dbo.HoaDon.TrangThai,\n" +
            "    dbo.HoaDon.TenNguoiNhan,\n" +
            "    dbo.HoaDon.SDTNguoiNhan;\n", nativeQuery = true)
    Page<Hoadonrespon> TimKiemTheoMa(Pageable pageable, @Param("mahoadon") String mahoadon);

    // hiển thị hoá đơn theo loại hoá đơn
    @Query(value = "SELECT\n" +
            "    dbo.HoaDon.Id,\n" +
            "    dbo.HoaDon.MaHoaDon,\n" +
            "    dbo.HoaDon.NgayTao,\n" +
            "    dbo.HoaDon.ThanhTien,\n" +
            "    dbo.HoaDon.LoaiHoaDon,\n" +
            "    dbo.HoaDon.TrangThai,\n" +
            "    dbo.HoaDon.TenNguoiNhan,\n" +
            "    dbo.HoaDon.SDTNguoiNhan\n" +
            "FROM\n" +
            "    dbo.HoaDon\n" +
            "LEFT JOIN\n" +
            "    dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHD\n"
            + "LEFT JOIN\n" +
            "      dbo.HinhThucThanhToan ON dbo.HoaDon.Id = dbo.HinhThucThanhToan.IdHD\n" +
            "WHERE\n" +
            "    dbo.HoaDon.LoaiHoaDon = ?\n" +
            "GROUP BY\n" +
            "    dbo.HoaDon.Id,\n" +
            "    dbo.HoaDon.MaHoaDon,\n" +
            "    dbo.HoaDon.NgayTao,\n" +
            "    dbo.HoaDon.ThanhTien,\n" +
            "    dbo.HoaDon.LoaiHoaDon,\n" +
            "    dbo.HoaDon.TrangThai,\n" +
            "    dbo.HoaDon.TenNguoiNhan,\n" +
            "    dbo.HoaDon.SDTNguoiNhan;\n", nativeQuery = true)
    Page<Hoadonrespon> LocHoaDonTheoLoaiHoaDon(Pageable pageable, @Param("loaihoadon") Integer loaihoadon);

    // hiển thị hoá đơn theo id

    @Query(value = "SELECT dbo.HoaDon.*, dbo.VouCher.MaVouCher, dbo.VouCher.HinhThucGiam, dbo.VouCher.GiaTriGiam AS GiaTriGiamVouCher\n" +
            "FROM dbo.HoaDon LEFT JOIN dbo.VouCher ON dbo.HoaDon.IdVouCher = dbo.VouCher.Id\n" +
            " where dbo.HoaDon.Id= ?", nativeQuery = true)
    Hoadonrespon finByidHD(UUID idHD);
}
