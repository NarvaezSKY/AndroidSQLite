package com.example.sqlitetest

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlitetest.databinding.ActivityConsumoAllBinding
import com.example.sqlitetest.model.Pokemons
import com.example.sqlitetest.service.PokemonAPIService
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConsumoAll : AppCompatActivity() {
    private lateinit var binding: ActivityConsumoAllBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityConsumoAllBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val retrofit= Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


            val service=retrofit.create(PokemonAPIService::class.java)

            val call = service.getPokemonById()

            call.enqueue(object: Callback<Pokemons> {
                override fun onResponse(call: Call<Pokemons>, response: Response<Pokemons>) {
                    if (response.isSuccessful){
                        val pokemon: Pokemons?=response.body()

                        //Toast.makeText(this@ConsumoAll, "$pokemon", Toast.LENGTH_SHORT).show()
                        binding.si.text=pokemon.toString()
                        Picasso.get()
                            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-vii/ultra-sun-ultra-moon/52.png")
                            .into(binding.imagencitaua)

                    }else{
                        Toast.makeText(this@ConsumoAll, "Algo salió mal", Toast.LENGTH_SHORT).show()
                    }
                }



                override fun onFailure(call: Call<Pokemons>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })

    }
}