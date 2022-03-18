package kmm.rickandmorty.app

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}