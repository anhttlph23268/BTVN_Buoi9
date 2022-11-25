/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.KhachHang;
import repository.KhachHangRepository;
import service.KhachHangService;

/**
 *
 * @author ACER
 */
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository repo;

    public KhachHangServiceImpl() {
        this.repo = new KhachHangRepository();
    }

    @Override
    public ArrayList<KhachHang> getList() {
        return this.repo.getAll();
    }

    @Override
    public void themKH(KhachHang kh) {
        this.repo.Insert(kh);
    }

    @Override
    public void suaKH(String ma, KhachHang kh) {
        this.repo.Update(ma, kh);
    }

    @Override
    public void xoaKH(String makh) {
        this.repo.Delete(makh);
    }

    @Override
    public ArrayList<KhachHang> getSearch(int min, int max) {
        return this.repo.getSearch(min, max);
    }

    @Override
    public ArrayList<KhachHang> getKhachVIP() {
        return this.repo.getKhachVip();
    }
}
