package com.haiercash.stream.sender.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wangjy
 * @date 2018/5/19
 */
public class CustInfo {

    private String CustNo;

    private String CustName;

    private String IdNo;

    public String getCustNo() {
        return CustNo;
    }

    public void setCustNo(String custNo) {
        CustNo = custNo;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getIdNo() {
        return IdNo;
    }

    public void setIdNo(String idNo) {
        IdNo = idNo;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
