package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MhsDatabase(this)

        GlobalScope.launch {
            val data = db.mhsDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            } }

        button.setOnClickListener{
            var nama = nama.text.toString()
            var alamat = alamat.text.toString()

        tampilan.setText("Nama Kamu = $nama \nAlamat Kamu = $alamat")

        GlobalScope.launch {
            db.mhsDao().insertAll(MhsEntity(0, "$nama", "$alamat"))
            val data = db.mhsDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            }
        }
        }
    }

    fun insertBtn(view: View){
    }
}
