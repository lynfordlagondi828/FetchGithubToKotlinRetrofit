package com.example.fetchgithubtokotlinretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout.VERTICAL
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchgithubtokotlinretrofit.R
import com.example.fetchgithubtokotlinretrofit.UserAdapter
import com.example.fetchgithubtokotlinretrofit.model.Users
import com.example.fetchgithubtokotlinretrofit.repository.Repository
import com.example.fetchgithubtokotlinretrofit.viewmodel.MainViewModel
import com.example.fetchgithubtokotlinretrofit.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { UserAdapter(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = recyclerView
        recyclerView.apply {
            recyclerView.adapter = myAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)

        }

        val repository = Repository()

        val viewMdodelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewMdodelFactory).get(MainViewModel::class.java)
        viewModel.getAllUsers()

        viewModel.myAllUsers.observe(this, Observer { response ->
            if (response.isSuccessful){

                response.body()?.let { myAdapter.setListData(it as ArrayList<Users>) }
                recyclerView.adapter = myAdapter
            } else {
                Toast.makeText(this,response.code(),Toast.LENGTH_LONG).show()
            }
        })

    }
}