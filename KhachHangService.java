package service;

import java.util.ArrayList;

import model.KhachHang;

public interface KhachHangService {

    public ArrayList<KhachHang> getList();

    public void themKH(KhachHang kh);

    public void suaKH(String ma, KhachHang kh);

    public void xoaKH(String makh);

    public ArrayList<KhachHang> getSearch(int min, int max);

    public ArrayList<KhachHang> getKhachVIP();
}
