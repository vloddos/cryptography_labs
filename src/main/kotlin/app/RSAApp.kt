package app

import app.view.Main
import tornadofx.App
import tornadofx.launch

class RSAApp : App(Main::class)

fun main(args: Array<String>) {
    launch<RSAApp>(args)
}