package com.smafolo.android.coviditalia;

//TODO Subclass provincia from regione and reuse same adapter


public class Provincia {

    private String mNome;
    private String mSiglaProvincia;
    private String mData;
    private int mCodiceRegione;
    private int mCodiceProvincia;
    private int mTotaleCasi;

    public Provincia(String mNome, String mSiglaProvincia, String mData, int mCodiceRegione, int mCodiceProvincia, int mTotaleCasi) {
        this.mNome = mNome;
        this.mSiglaProvincia = mSiglaProvincia;
        this.mData = mData;
        this.mCodiceRegione = mCodiceRegione;
        this.mCodiceProvincia = mCodiceProvincia;
        this.mTotaleCasi = mTotaleCasi;
    }

    public Provincia(String mNome, int mTotaleCasi) {
        this.mNome = mNome;
        this.mTotaleCasi = mTotaleCasi;
    }

    public String getmNome() {
        return mNome;
    }

    public String getmSiglaProvincia() {
        return mSiglaProvincia;
    }

    public String getmData() {
        return mData;
    }

    public int getmCodiceRegione() {
        return mCodiceRegione;
    }

    public int getmCodiceProvincia() {
        return mCodiceProvincia;
    }

    public int getmTotaleCasi() {
        return mTotaleCasi;
    }
}
