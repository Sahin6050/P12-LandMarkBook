package com.sahin.landmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sahin.landmarkbook.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    // Viewholder ilk oluştuğunda ne olcak.layout ile bağlama işlemi yapılır.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    // Kaç adet oluşturmak ister isek buraya yazarız.
    override fun getItemCount(): Int {
        return landmarkList.size
    }

    // Bağlandıktan sonra ne olacağını yazarız.
    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        //Recyclera bağlanan texte isimleri göster.
        holder.binding.textView.text = "${landmarkList.get(position).landmarkName}"

        // Hangi veriye tıklandıysa diğer sayfaya verileri gönder ve kullan.
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //chosenLandmark = landmarkList.get(position)
            //intent.putExtra("landmark",landmarkList.get(position))
            mySinleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)

        }
    }

}