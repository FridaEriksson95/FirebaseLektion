package com.example.firebaselektion

//dataklasser har inbyggda to string metoder, vill man ha snyggare skapar man endast en class och lägger in toString
data class Person(val name: String, val phone : String) {

    //tom constructor för att undvika krasch
    constructor() : this("", "")
}