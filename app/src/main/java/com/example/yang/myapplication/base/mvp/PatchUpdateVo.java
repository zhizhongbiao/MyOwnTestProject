package com.example.yang.myapplication.base.mvp;


import com.example.yang.myapplication.base.mvp.model.BaseVo;

public class PatchUpdateVo extends BaseVo {

    private String patchUpdateUrl;

    public String getPatchUpdateUrl() {
        return patchUpdateUrl;
    }

    public void setPatchUpdateUrl(String patchUpdateUrl) {
        this.patchUpdateUrl = patchUpdateUrl;
    }
}
