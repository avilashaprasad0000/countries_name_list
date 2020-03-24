package com.example.countries_name_list;

public class countrynamemodalclass {
    String c_name,c_code,c_capital;

    public countrynamemodalclass(String c_name, String c_code,String c_capital) {
        this.c_name = c_name;
        this.c_code=c_code;
        this.c_capital=c_capital;
    }

    public String getC_capital() {
        return c_capital;
    }

    public void setC_capital(String c_capital) {
        this.c_capital = c_capital;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
