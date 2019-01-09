package com.example.com.myapplication.model;

import com.example.com.myapplication.api.Api;
import com.example.com.myapplication.contract.ProductContract;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class ProductModel implements ProductContract.IProductModel {


    @Override
    public void getProductList(HashMap<String, String> params, final IProductCallback callback) {
        OkhttpUtils.getInstance().doPost(Api.PRODUCT_URL, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callback.failure("失败");
            }

            @Override
            public void success(String result) {
                if (result != null) {
                    callback.successlogin(result);
                }
            }
        });
    }

    @Override
    public void getRegList(HashMap<String, String> params, IProductCallback callback) {

    }

    public interface IProductCallback {
        void failure(String msg);//失败

        void successlogin(String result);//成功登陆

        void successreg(String result);//成功注册
    }
}
