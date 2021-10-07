package com.masdiq.firebasewithphp

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.iid.FirebaseInstanceId
import com.masdiq.firebasewithphp.retrofit.PostsResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buat dapet token
        val refreshToken = FirebaseInstanceId.getInstance().token
        Log.d(ContentValues.TAG, "Refresh token $refreshToken")

        btn_submit_create.setOnClickListener {
            createPost()
        }
    }

    private fun createPost() {
        with(RetrofitClient) {
            instance.createData(
                tv_title.text.toString(),
                tv_subtitle.text.toString()
            ).enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    val responseText = "Notification Success"
                    tv_status_create.text = responseText
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    tv_status_create.text = t.message
                }
            })
        }
    }
}