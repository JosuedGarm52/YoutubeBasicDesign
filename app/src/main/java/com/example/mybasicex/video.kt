package com.example.mybasicex

data class video(
    var Titulo : String,
    var Canal : String = "Tu",
    var FechaSubida: String = "01/01/2024",
    var Duracion: Double,
    var todoPublico : Boolean = false,
    var Visual: String = "Publico",
    var img : String = "drawable/avatarimg2.png"
)
