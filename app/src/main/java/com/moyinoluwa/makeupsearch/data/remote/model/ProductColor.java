package com.moyinoluwa.makeupsearch.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by moyinoluwa on 3/10/17.
 */

public class ProductColor implements Parcelable {

    @SerializedName("hex_value")
    @Expose
    private String hexValue;
    @SerializedName("colour_name")
    @Expose
    private String colourName;

    /**
     * No args constructor for use in serialization
     */
    public ProductColor() {
    }

    public ProductColor(String hexValue, String colourName) {
        super();
        this.hexValue = hexValue;
        this.colourName = colourName;
    }

    public ProductColor(Parcel source) {
        hexValue = source.readString();
        colourName = source.readString();
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hexValue);
        dest.writeString(colourName);
    }

    public static final Parcelable.Creator<ProductColor> CREATOR = new Parcelable
            .Creator<ProductColor>() {

        @Override
        public ProductColor createFromParcel(Parcel source) {
            return new ProductColor(source);
        }

        @Override
        public ProductColor[] newArray(int size) {
            return new ProductColor[0];
        }
    };
}
