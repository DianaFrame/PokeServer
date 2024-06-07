package ermolaev

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class BootAppStarter {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(BootAppStarter::class.java, *args)
        }
    }
}

