package com.example.sms.Model;

import javax.validation.constraints.NotNull;

/**
 * Created by macbook on 7/8/17.
 */
public class ModelSMS {
    @NotNull
    private String phoneNm;
    @NotNull
    private String message;

    public String getphoneNm(){return phoneNm;}
    public void setphoneNm(String PN){this.phoneNm=PN;}
    public String getmessage(){return message;}
    public void setmessage(String M){this.message=M;}

}
