package com.example.project_final

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide


class detail : Fragment() {

    var image:String ?= null
    var title:String ?= null
    var description:String ?= null
    var num:String ?= null

    fun newInstance(image:String,title:String,description: String,num:String): detail {
        val fragment = detail()
        val bundle = Bundle()
        bundle.putString("image",image);
        bundle.putString("title",title);
        bundle.putString("description",description);
        bundle.putString("num",num);
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle != null){
            this.image = bundle.getString("image").toString()
            this.title = bundle.getString("title").toString()
            this.description = bundle.getString("description").toString()
            this.num = bundle.getString("num").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_detail, container, false)
        val image_view : ImageView = view.findViewById(R.id.image_view)
        val title_view : TextView = view.findViewById(R.id.title_view)
        val description_view : TextView = view.findViewById(R.id.description_view)
        val num_view : TextView = view.findViewById(R.id.num_view)
        val button: Button = view.findViewById(R.id.button_open_dialog)
        button.setOnClickListener{
            val builder: AlertDialog.Builder =  AlertDialog.Builder(this.context)
            builder.setMessage("คุณต้องการซื้อบัตรงานนี้ใช่หรือไม่ ?")

            builder.setNegativeButton("รับ",
                DialogInterface.OnClickListener{ dialog, id ->
                    Toast.makeText(this.context,"ขอบคุณครับ", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                })

            builder.setPositiveButton("ไม่ใช่",
                DialogInterface.OnClickListener{ dialog, id ->
                    Toast.makeText(this.context,"ขอบคุณครับ", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                })
            builder.show();

        }
        title_view.text = this.title
        description_view.text = this.description
        num_view.text = this.num
        Glide.with(activity!!.baseContext).load(image).into(image_view)
        return view
    }

}
