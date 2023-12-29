package com.sahin.landmarkbook

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahin.landmarkbook.databinding.ActivityMainBinding
// Global değişken ile de verileri gönderebiliriz ama tercih etmeyiz.
//var chosenLandmark : Landmark? = null
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize
        landmarkList = ArrayList<Landmark>()

       // Data -> Verilerin girilmesi sınıf oluşturma sebebi her landmark için aynı değişkenler gerekli bu yüzden bunu
       // Uygulayoruz eğer sınıf açılmasaydı her biri için 3 özellik yani toplamda 12 özellik kullanmış olacaktım.
       // Bu da belleğimizin verimliliği için iyi bir şey değil.

       // Data -> Verilerin girilmesi.
       val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
       val colosseum = Landmark("Colosseum","Italy",R.drawable.colosseum)
       val eiffel = Landmark("Eiffel","France",R.drawable.eiffel)
       val londonBridge = Landmark("London Bridge","UK",R.drawable.london)


        // yukarıdaki görsel verisi int olarak tutulduğu için intent yapmak normal ama bitmap olsaydı
        // veri büyük olsaydı intent ile yollamak mantıksız olurdu.
        // Bitmapta görsel hangi tipe ait ise öyle kaydeder,örneğin(jpg,png) vb.
        // Inefficient -> Verimsiz
        //val pisaBitmap = BitmapFactory.decodeResource(resources,R.drawable.pisa)


        // Added Liste
        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        // Adapter-> Layout && Data birbirine bağlar.
        // Kotlinde text halindeki veri için simple_list_item_1 kullanılır.

        // Mapping -> Bir veriyi başka bir veriye benzetme veya çevirmedir.

        /*
        // Listview verimsizdir çünkü  listedeki her veri için xml oluşturur.
        // fakat RecyclerView ise kullanıcının gördüğü kadar oluşturur ve verimlidir.
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark ->landmark.landmarkName  })

        binding.listView.adapter = adapter
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val intent = Intent(this@MainActivity,DetailsActivity::class.java)
            // İntent ile sınıf objelerini yollamak istersek o sınıfı Serizable yap.
            intent.putExtra("landmark",landmarkList.get(position))
            startActivity(intent)
        }

         */
                                            // alt alta göstermek için kullanılır.
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // adapter bağlanması gerekli çünkü adapterde yazdığımız kodlar xml ile bütünleşip gösteriliyor.
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter



    }
}