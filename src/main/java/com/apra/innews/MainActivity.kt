package com.apra.innews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<news>
    private lateinit var imageId : Array<Int>
    private lateinit var  heading: Array<String>
    lateinit var news : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.i,R.drawable.j,R.drawable.k)
        heading = arrayOf("candidate Biden called Saudi Arabia a famous Location for Tourist","candidate Biden called Saudi Arabia a famous Location for Tourist","candidate Biden called Saudi Arabia a famous Location for Tourist"
            ,"candidate Biden called Saudi Arabia a famous Location for Tourist","candidate Biden called Saudi Arabia a famous Location for Tourist","candidate Biden called Saudi Arabia a famous Location for Tourist"
            ,"candidate Biden called Saudi Arabia a famous Location for Tourist","candidate Biden called Saudi Arabia a famous Location for Tourist","candidate Biden called Saudi Arabia a famous Location for Tourist",
            "candidate Biden called Saudi Arabia a famous Location for Tourist")

        news = arrayOf(
            getString(R.string.news_a),getString(R.string.news_b),getString(R.string.news_c),getString(R.string.news_d),getString(R.string.news_e),getString(R.string.news_g)
            ,getString(R.string.news_i),getString(R.string.news_j),
        )



        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserData()

    }

    private fun getUserData(){
        for (i in imageId.indices){
            val news = news(imageId[i],heading[i])
            newArrayList.add(news)
        }
        val adapter=MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClicklistener(object :MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
             //   Toast.makeText(this@MainActivity,"you clicked on item no.$position",Toast.LENGTH_SHORT).show()

                val intent = Intent( this@MainActivity,NewsActivity::class.java)
                intent.putExtra( "heading",newArrayList[position].heading)
                intent.putExtra("imageId",newArrayList[position].titleImage)
                intent.putExtra("news",news[position])
                startActivity(intent)

            }
        })
    }
}