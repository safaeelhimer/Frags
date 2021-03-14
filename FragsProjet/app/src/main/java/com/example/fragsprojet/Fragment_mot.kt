package com.example.fragsprojet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream

class Fragment_mot : Fragment(), DescAdapter.ItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_mots, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mylist = view?.findViewById<RecyclerView>(R.id.listR)
        val array = ArrayList<Description>() // création d'une liste de Description
        try {
            // recuperation du fichier dictionnaire contenant les mots et les définitions
            val inputStream: InputStream = this.resources.openRawResource(R.raw.dictionnaire)
            val content = inputStream.bufferedReader().use { it.readText() }

            //Devision du contenu selon \n "retour à la ligne", pour avoir comme résultat chaque mot et sa défintion dans une case
            val splited = content.split("\n")

            // Ensuite pour chaque ligne dans splited, on dévise chaque case pour séparer chaque mot de sa définition et cela par ":"
            for (line in splited) {
                if (line != splited[1]) {
                    var word = line.split(":")
                    // word[0] contient le mot
                    // word[1] contient la définition du mot
                    array.add(Description(word[0], word[1]))
                }
            }


            if (mylist != null) {
                mylist.setHasFixedSize(true)
                mylist.layoutManager = LinearLayoutManager(this.activity)
                val adap = DescAdapter(array,this)
                mylist.adapter = adap
            }


        }
        catch(e:Exception){
            println(e.message);
            println("error")
        }

    }
}