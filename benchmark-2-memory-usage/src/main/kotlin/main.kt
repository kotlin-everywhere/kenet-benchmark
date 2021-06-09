import kotlinx.coroutines.*
import org.kotlin.everywhere.net.HttpEngine
import org.kotlin.everywhere.net.createServer
import org.kotlin.everywhere.net.invoke
import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter

fun Long.toMb(): Float {
    return this.toFloat() / 1024 / 1024
}

fun log(write: (String) -> Unit) {
    write("2. memory-usage")
    write("total memory: ${Runtime.getRuntime().totalMemory().toMb()}mb")
    write("max memory: ${Runtime.getRuntime().maxMemory().toMb()}mb")
    write("free memory: ${Runtime.getRuntime().freeMemory().toMb()}mb")
    write("used memory: ${(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()).toMb()}mb")
    write("")
}

fun Api.init(quitDeferred: CompletableDeferred<Unit>) {
    benchmark {
        log(System.out::println)
        FileOutputStream(File("result.txt"), true).use { o ->
            PrintWriter(o).use {
                log(it::println)
            }
        }

    }
    quit.invoke {
        GlobalScope.launch {
            delay(1000)
            quitDeferred.complete(Unit)
        }
        Unit
    }
}

fun main() {
    runBlocking {
        val serverQuitDeferred = CompletableDeferred<Unit>()

        val api = Api().apply {
            init(serverQuitDeferred)
        }
        val server = createServer(api, HttpEngine())
        val serverJob = launch {
            server.launch(5000)
        }

        serverQuitDeferred.await()
        serverJob.cancelAndJoin()
    }
}