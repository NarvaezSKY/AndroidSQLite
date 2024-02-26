package com.example.sqlitetest.service

import com.example.sqlitetest.model.Pokemon

import com.example.sqlitetest.model.Pokemons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPIService {
 @GET("pokemon/")
 fun getPokemonById():Call<Pokemons>
}

