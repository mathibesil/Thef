package com.prueba.besil.theelectricfactoryprueba.ui.product.presenter

import com.prueba.besil.theelectricfactoryprueba.ui.base.presenter.MVPPresenter
import com.prueba.besil.theelectricfactoryprueba.ui.product.interactor.ProductMVPInteractor
import com.prueba.besil.theelectricfactoryprueba.ui.product.view.ProductMVPView

interface ProductMVPPresenter<V:ProductMVPView, I:ProductMVPInteractor> : MVPPresenter<V,I>{
    fun getProducts()
}