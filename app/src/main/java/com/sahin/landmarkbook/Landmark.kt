package com.sahin.landmarkbook

import java.io.Serializable

// Serizable yapma sebebim intent ile bu sınıfın objelerini gönderiyorum.
class Landmark (val landmarkName : String,val countryName : String,val image : Int) : Serializable{
}