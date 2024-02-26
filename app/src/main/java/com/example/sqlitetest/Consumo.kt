package com.example.sqlitetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.sqlitetest.service.PokemonAPIService
import com.example.sqlitetest.databinding.ActivityConsumoBinding
import com.example.sqlitetest.model.Pokemon
import com.example.sqlitetest.model.Pokemons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Consumo : AppCompatActivity() {
    private lateinit var binding:ActivityConsumoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityConsumoBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val retrofit=Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        binding.button3.setOnClickListener {
            val service=retrofit.create(PokemonAPIService::class.java)
            val pokemonName=binding.editText.text.toString()
            val call = service.getPokemonById()


            call.enqueue(object: Callback<Pokemons>{
                override fun onResponse(call: Call<Pokemons>, response: Response<Pokemons>) {
                    if (response.isSuccessful){
                        val pokemon:Pokemons?=response.body()

                        Toast.makeText(this@Consumo, "Encontrado el pokemon $pokemon", Toast.LENGTH_SHORT).show()
                        val foundPokemon=binding.result
                        foundPokemon.text= pokemon.toString()

                    }else{
                        Toast.makeText(this@Consumo, "Algo salió mal", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Pokemons>, t: Throwable) {
                    //si
                }
            })
        }

    }
}