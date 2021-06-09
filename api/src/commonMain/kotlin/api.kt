import org.kotlin.everywhere.net.Kenet
import org.kotlin.everywhere.net.c

class Api : Kenet() {
    val benchmark by c<Unit, Unit>()
    val quit by c<Unit, Unit>()
}