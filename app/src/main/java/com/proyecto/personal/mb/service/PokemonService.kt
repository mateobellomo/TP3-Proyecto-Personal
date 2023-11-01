package com.proyecto.personal.mb.service

import com.proyecto.personal.mb.models.Activity
import com.proyecto.personal.mb.models.PaginateResponse
import com.proyecto.personal.mb.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    // Aca van todas funciones que tenga la API (GET POST DELETE)
    @GET("api/v2/pokemon")
    fun getPokemon(): Call<PaginateResponse<Pokemon>>

    // Esto es un ejemplo de que PaginateResponse se hizo generico
    // Para poder usarlo para traer otras APIs como el ejemplo de "Activity"
    @GET("api/v2/ability")
    fun getPokemonAbility(): Call<PaginateResponse<Activity>>

}