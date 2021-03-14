package com.example.fragsprojet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream

class Fragment_def : Fragment(), DescAdapter.ItemClicked {

    var mot = view?.findViewById<TextView>(R.id.mot)
    var def = view?.findViewById<TextView>(R.id.def)
    val array = ArrayList<Description>() // création d'une liste de Description


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_def, container, false)
        // Inflate the layout for this fragment
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



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




        }

    override fun OnItemClicked(index: Int) {
        super.OnItemClicked(index)
        mot?.text= array[index].name
        def?.text = array[index].desc

    }
}




