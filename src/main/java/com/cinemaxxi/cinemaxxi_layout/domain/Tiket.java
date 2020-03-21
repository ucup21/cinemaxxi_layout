/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cinemaxxi.cinemaxxi_layout.domain;

/**
 *
 * @author Yusup
 */
public class Tiket {

    private String label;
    private String status;
    private String tglPesan;

    public Tiket() {
    }

    public Tiket(String label, String status, String tglPesan) {
        this.label = label;
        this.status = status;
        this.tglPesan = tglPesan;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

    public String getTglPesan() {
        return tglPesan;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTglPesan(String tglPesan) {
        this.tglPesan = tglPesan;
    }
}
