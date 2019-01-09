package com.example.com.myapplication.contract;

import com.example.com.myapplication.Bean.ProductBean;
import com.example.com.myapplication.Bean.RegBean;
import com.example.com.myapplication.model.ProductModel;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.HashMap;

public class ProductContract {
    //presentera
    abstract class ProductPresenter extends BasePresenter<IProductModel, iProductView> {
        public IProductModel getModel() {
            return new ProductModel();
        }

        public abstract void getProductList(HashMap<String, String> params);
    }

    //model的接口
    public interface IProductModel extends IBaseModel {
        void getProductList(HashMap<String, String> params, ProductModel.IProductCallback callback);

        void getRegList(HashMap<String, String> params, ProductModel.IProductCallback callback);
    }

    //view的接口
    public interface iProductView extends IBaseView {
        void successProduct(ProductBean productBean);

        void successReg(RegBean regBean);

        void failureProduct(String error);

        void failureReg(String error);
    }
}
