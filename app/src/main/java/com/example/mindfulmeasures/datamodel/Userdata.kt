package com.example.mindfulmeasures.datamodel

class Userdata{
    var img: String? =null
    var little:String? =null
    var large:String? =null

    constructor(){}
    constructor(img:String, little:String, large:String){
        this.img=img
        this.little=little
        this.large=large

    }
}
