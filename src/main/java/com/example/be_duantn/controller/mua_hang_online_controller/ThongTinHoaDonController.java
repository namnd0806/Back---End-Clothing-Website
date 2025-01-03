package com.example.be_duantn.controller.mua_hang_online_controller;

import com.example.be_duantn.service.mua_hang_online_service.Impl.ThongTinHoaDonSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/ol/thong-tin/hoa-don-khach-hang")
public class ThongTinHoaDonController {
    @Autowired
    ThongTinHoaDonSeviceImpl thongTinHoaDonSevice;

    // ToDo load thông tin hóa đơn của khách hàng
    @GetMapping("/load-hoa-don")
    public ResponseEntity<?> LoadTTHoaDonKhachHang(@RequestParam("idkh") UUID idkh, @RequestParam("trangthai") Integer trangthai){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.LoadTTHoaDonKhachHang(idkh, trangthai));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi load thông tin hóa đơn của khách hàng !");
        }
    }

    // ToDo load thông tin sản phẩm trong hóa đơn của khách hàng
    @GetMapping("/load-san-pham")
    public ResponseEntity<?> LoadTTSPHoaDonKhachHang(@RequestParam("idhoadon") UUID idhoadon){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.LoadTTSPHoaDonKhachHang(idhoadon));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi load thông tin sản phẩm trong hóa đơn của khách hàng !");
        }
    }

    // ToDo tìm kiếm thông tin hóa đơn của khách theo mahoadon, tennguoinhan, tensanpham
    @GetMapping("/tim-kiem-hoa-don")
    public ResponseEntity<?> TimKiemHoaDonKhachHang(@RequestParam("idkh") UUID idkh, @RequestParam("keyword") String keyword, Integer trangthai){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.TimKiemHoaDonKhachHang(idkh, keyword, trangthai));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi tìm thông tin hóa đơn của khách hàng !");
        }
    }

    // ToDo Find thông tin hóa đơn chi tiết
    @GetMapping("/find-hoa-don/chi-tiet")
    public ResponseEntity<?> FinTTHoaDonCTKhachHang(@RequestParam("idhoadon") UUID idhoadon){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.FinTTHoaDonCTKhachHang(idhoadon));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi find thông tin hóa đơn chi tiết của khách hàng !");
        }
    }

    // ToDo Find hình thức thanh toán hóa đơn của khách hàng
    @GetMapping("/find-hinh-thuc/thanh-toan")
    public ResponseEntity<?> FinTTHinhThucTT(@RequestParam("idhoadon") UUID idhoadon){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.FinTTHinhThucTT(idhoadon));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi find thông tin httt của khách hàng !");
        }
    }

    // ToDo Find thông tin sản phẩm trong hóa đơn chi tiết
    @GetMapping("/find-san-pham-hdct")
    public ResponseEntity<?> FinTTSPHDCTKhachHang(@RequestParam("idhoadon") UUID idhoadon){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.FinTTSPHoaDonCTKhachHang(idhoadon));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi find thông tin sp trong hdct của khách hàng !");
        }
    }

    // ToDo Find thông tin lịch sử các ngày của hóa đơn
    @GetMapping("/find-lich-su-ngay")
    public ResponseEntity<?> FindLichSuNgayHD(@RequestParam("idhoadon") UUID idhoadon){
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.FindLichSuNgayHD(idhoadon));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi find lịch sử ngày hóa đơn của khách hàng !");
        }
    }

    // ToDo hủy hóa đơn khách hàng online
    @PutMapping("/huy-don-hang-online")
    public ResponseEntity<?> HuyHoaDonTaiQuay(@RequestParam("idhoadon") UUID idhoadon) {
        try {
            return ResponseEntity.ok(thongTinHoaDonSevice.HuyDonHangKhachHang(idhoadon));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khách hàng hủy đơn hàng online !");
        }
    }
}
