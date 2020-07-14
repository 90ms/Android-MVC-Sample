package beeasy.android_mvc_sample.controller

import beeasy.android_mvc_sample.model.DataAccessLayer
import beeasy.android_mvc_sample.view.MainView

class DataController(private val model: DataAccessLayer) {

    private lateinit var view: MainView

    fun bind(mainView: MainView) {
        view = mainView
    }

    fun onButtonClicked() = model.checkAnswer(view.getAnswer())
}