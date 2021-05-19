package com.example.week11.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding> : AppCompatActivity() {
    abstract val LOG_TAG:String
    private  var _binding:ViewBinding?= null
    protected var  binding :VB? = null
    abstract val bindingInflater: (LayoutInflater) ->VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=bindingInflater(layoutInflater)
        binding=_binding as VB?
        setContentView(requireNotNull(_binding).root)
        setUp()
        callback()
    }
    abstract fun setUp()
    abstract fun callback()
    protected fun log(value: Any?){
        Log.v(LOG_TAG,value.toString())
    }

}