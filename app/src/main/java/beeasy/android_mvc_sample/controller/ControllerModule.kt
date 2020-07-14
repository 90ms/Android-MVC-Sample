package beeasy.android_mvc_sample.controller

import beeasy.android_mvc_sample.model.ModelModule

object ControllerModule {
    fun dataController() = DataController(ModelModule.dataAccessLayer)
}