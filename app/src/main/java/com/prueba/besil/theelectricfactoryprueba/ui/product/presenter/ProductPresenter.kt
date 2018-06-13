package com.prueba.besil.theelectricfactoryprueba.ui.product.presenter

import com.prueba.besil.theelectricfactoryprueba.data.network.util.NoConnectivityException
import com.prueba.besil.theelectricfactoryprueba.ui.base.presenter.BasePresenter
import com.prueba.besil.theelectricfactoryprueba.ui.product.interactor.ProductMVPInteractor
import com.prueba.besil.theelectricfactoryprueba.ui.product.view.ProductMVPView
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class ProductPresenter<V : ProductMVPView, I : ProductMVPInteractor> @Inject internal constructor(interactor: I) : BasePresenter<V, I>(interactor), ProductMVPPresenter<V, I> {
    override fun getProducts() {
        interactor?.getProducts()
                ?.subscribe({
                    getView()?.updateProducts(it)
                }, { error : Throwable ->
                    if (error is java.net.SocketTimeoutException || error is java.net.ConnectException) getView()?.showMessage("No se pudo conectar con servidor")
                    if (error is NoConnectivityException) getView()?.showMessage("Sin conexión a internet")
                    try {
                        error as HttpException
                        val jObjError = JSONObject(error.response().errorBody()!!.string())
                        getView()?.showMessage(jObjError.getString("messages"))
                    } catch (e: Exception) {
                        getView()?.showMessage("Error al obtener datoes.")
                    }
                    loadersOff()
                })
    }
    private fun loadersOff() {
        getView()?.loadProgress(false)
        getView()?.swipeRefreshOff()
    }
}