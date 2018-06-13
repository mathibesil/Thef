package com.prueba.besil.theelectricfactoryprueba.ui.product.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.prueba.besil.theelectricfactoryprueba.R
import com.prueba.besil.theelectricfactoryprueba.data.network.DTO.ClientDTO
import com.prueba.besil.theelectricfactoryprueba.data.network.DTO.ProductDTO
import com.prueba.besil.theelectricfactoryprueba.ui.base.view.BaseActivity
import com.prueba.besil.theelectricfactoryprueba.ui.client.view.ClientAdapter
import com.prueba.besil.theelectricfactoryprueba.ui.client.view.ClientFragment
import com.prueba.besil.theelectricfactoryprueba.ui.product.interactor.ProductMVPInteractor
import com.prueba.besil.theelectricfactoryprueba.ui.product.presenter.ProductMVPPresenter
import com.prueba.besil.theelectricfactoryprueba.util.addFragment
import com.prueba.besil.theelectricfactoryprueba.util.hideFragment
import com.prueba.besil.theelectricfactoryprueba.util.removeFragment
import com.prueba.besil.theelectricfactoryprueba.util.showFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class ProductActivity : BaseActivity(), ProductMVPView {
    //region vars
    @Inject
    lateinit var presenter: ProductMVPPresenter<ProductMVPView, ProductMVPInteractor>
    @Inject
    lateinit var adapter: ProductAdapter
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        presenter.onAttach(this)
        setSupportActionBar(toolbar_product)
    }

    override fun updateProducts(listProducts: List<ProductDTO>) {
        adapter.productDTOList = listProducts
        adapter.isLoading = false
        adapter.notifyDataSetChanged()
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager?.removeFragment(tag = tag)
    }
    override fun swipeRefreshOff() {
       // home_fragment_swiperefresh.isRefreshing = false
    }
    override fun blockUi() {

    }

    override fun unBlockUi() {

    }

    override fun onFragmentAttached() {
    }
    override fun showMessage(texto: String) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }

    override fun loadProgress(enabled: Boolean) {
        if (enabled)
            pbRestaurantes.visibility = View.VISIBLE
        else
            pbRestaurantes.visibility = View.GONE
    }

}