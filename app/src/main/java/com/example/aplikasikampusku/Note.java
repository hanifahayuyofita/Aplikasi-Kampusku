package com.example.aplikasikampusku;
public class Note {
    private int NIM;
    private String NAMA;
    private String TTL;
    private String JK;
    private String ALAMAT;
    public Note() {}
    public Note(int nim, String nama, String ttl, String jk, String alamat) {
        this.NIM = nim;
        this.NAMA = nama;
        this.TTL = ttl;
        this.JK = jk;
        this.ALAMAT = alamat;
    }

    public int getNIM() { return NIM; }
    public void setNIM(int NIM) { this.NIM = NIM; }
    public String getNAMA() { return NAMA; }
    public void setNAMA(String NAMA) { this.NAMA = NAMA; }
    public String getTTL() { return TTL; }
    public void setTTL(String TTL) { this.TTL = TTL; }
    public String getJK() { return JK; }
    public void setJK(String JK) { this.JK = JK; }
    public String getALAMAT() { return ALAMAT; }
    public void setALAMAT(String ALAMAT) { this.ALAMAT = ALAMAT; }

}