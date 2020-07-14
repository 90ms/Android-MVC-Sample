package beeasy.android_mvc_sample.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import beeasy.android_mvc_sample.R
import beeasy.android_mvc_sample.controller.ControllerModule.dataController
import beeasy.android_mvc_sample.model.ModelModule
import beeasy.android_mvc_sample.model.observer.AccessObserver
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity(), MainView , AccessObserver {

    private val TAG = MainActivity::class.java.simpleName

    private val model = ModelModule.dataAccessLayer
    private val controller = dataController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        controller.bind(this)

        button.setOnClickListener {
            controller.onButtonClicked()
        }
    }

    override fun onStart() {
        super.onStart()
        model.register(this)
    }

    override fun onStop() {
        super.onStop()
        model.unregister(this)
    }

    override fun getAnswer(): String = edit_answer.text.toString()

    override fun onSuccess() {
        val data = queryAccount()
        showMessage("Success!")

        text_description.text =
            "${data.author} \n\n ${data.since} \n\n ${data.email} \n\n ${data.url} \n\n ${data.detailDescription}"

    }

    override fun onFail() {
        showMessage("Fail")
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun queryAccount() = model.getCurrentAccount()
}