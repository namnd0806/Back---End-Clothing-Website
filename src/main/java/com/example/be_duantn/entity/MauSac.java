package com.example.be_duantn.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "mausac")
public class MauSac {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id")
    private UUID idmausac;

    @Column(name = "tenmausac")
    private String tenmausac;

    @Column(name = "mota")
    private String mota;

    @Column(name = "trangthai")
    private Integer trangthai;

    @OneToMany(mappedBy = "mausac", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<SanPhamChiTiet> sanphamchitiet;
}
