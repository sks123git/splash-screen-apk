package layout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.splashscreen.R

class GridAdapter(var nameList: ArrayList<String>,
                               var imageList: ArrayList<Int>,
                               var context: Context
    ): BaseAdapter() {

        override fun getCount(): Int {
            return nameList.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.tile_view,parent,false)

            var countryName: TextView = view.findViewById(R.id.textView)
            var countryFlag: ImageView = view.findViewById(R.id.imageView)

            countryName.text = nameList[position]
            countryFlag.setImageResource(imageList.get(position))
            return view
        }

    }