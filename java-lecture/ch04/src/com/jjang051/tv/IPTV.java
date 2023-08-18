package com.jjang051.tv;

public class IPTV extends ColorTV {
    private String ipAddress;

    public IPTV(int size, int nColor, String ipAddress) {
        super(size, nColor);
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override

    void showInfo() {
        System.out.printf("ip주소 %s 이고 %d 인치 %d 컬러 TV입니다.", this.getIpAddress(), this.getSize(), this.getnColor());
    }

    public static void main(String[] args) {
        new IPTV(64, 256, "127.0.0.1").showInfo();
    }

}
