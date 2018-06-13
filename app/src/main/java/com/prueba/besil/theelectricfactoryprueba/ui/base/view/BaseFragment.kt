package com.prueba.besil.theelectricfactoryprueba.ui.base.view

import android.content.Context
import android.location.Location
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment(), MVPView {

    private var parentActivity: BaseActivity? = null
    //private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun hideProgress() {
//        if (progressDialog != null && progressDialog?.isShowing!!) {
//            progressDialog?.cancel()
//        }
    }

    override fun showProgress() {
        hideProgress()
       // progressDialog = CommonUtil.showLoadingDialog(this.context)
    }

    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()
}