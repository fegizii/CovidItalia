package com.smafolo.android.coviditalia;

/**
 * {@link Regione} represents a single italian region. Fields are created based on the data published by Protezione Civile
 */


public class Regione {

    private String mName;
    private String mdata;
    private int mCodiceRegione;
    private int mRicoverati_con_sintomi;
    private int mterapia_intensiva;
    private int mTotaleOspedalizzati;
    private int mIsolamentoDomiciliare;
    private int mTotalePositivi;
    private int mVariazioneTotalePositivi;
    private int mNuoviPositivi;
    private int mDimessiGuariti;
    private int mDeceduti;
    private int mTotaleCasi;
    private int mTamponi;
    private int mCasiTestati;


    /**
     * This constructor is for the basic view
     *
     * @param name           is the name of the regione
     * @param totalePositivi is the total number of positive cases
     * @param nuoviPositivi  is the new number of positive cases
     */
    public Regione(String name, int totalePositivi, int nuoviPositivi) {
        mName = name;
        mTotalePositivi = totalePositivi;
        mNuoviPositivi = nuoviPositivi;
    }



    public String getName() {
        return mName;
    }

    public int getTotalePositivi() {
        return mTotalePositivi;
    }

    public int getNuoviPositivi() {
        return mNuoviPositivi;
    }
}
