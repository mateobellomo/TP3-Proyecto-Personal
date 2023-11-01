package com.proyecto.personal.mb.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.models.PaginateResponse
import com.proyecto.personal.mb.models.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.proyecto.personal.mb.service.ActivityServiceApiBuilder


class Fragment4 : Fragment() {

    private lateinit var activityText: TextView
    private lateinit var typeText: TextView
    lateinit var vista: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_4, container, false)

        activityText = vista.findViewById(R.id.activity_text)
        typeText = vista.findViewById(R.id.type_text)

        loadPokemon()
        Thread.sleep(800) // Esto es para que primero carguen el pokemon y no la vista sino la info cae tarde

        return vista
    }

    fun loadPokemon() {
        val service = ActivityServiceApiBuilder.create()

        service.getPokemon().enqueue(object : Callback<PaginateResponse<Pokemon>> {
            override fun onResponse(
                call: Call<PaginateResponse<Pokemon>>,
                response: Response<PaginateResponse<Pokemon>>
            ) {

                if (response.isSuccessful) {
                    val responsePokemon = response.body()

                    activityText.text = responsePokemon?.count.toString()
                    typeText.text = responsePokemon?.results?.get(1)?.name.toString()
                }
            }

            override fun onFailure(call: Call<PaginateResponse<Pokemon>>, t: Throwable) {
                Log.e("Example", t.stackTraceToString())
            }
        })
    }


}