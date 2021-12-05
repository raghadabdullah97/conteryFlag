package com.example.contreyandflag.network

data class FlagPhoto(val name:String,val flag: String)
data class CountryResPONSE(val error : Boolean ,  val msg :String , val data : List<FlagPhoto> )
