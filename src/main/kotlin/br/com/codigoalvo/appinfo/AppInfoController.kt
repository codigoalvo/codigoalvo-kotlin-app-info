package br.com.codigoalvo.appinfo

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppInfoController {

    @Value("\${git.commit.id.abbrev:#{null}}") // Usando SpEL com fallback null
    private val gitCommitHash: String? = null

    @Value("\${app.version}")
    private lateinit var appVersion: String

    @GetMapping("/app-info")
    fun getAppInfo(): Map<String, String> {
        return mapOf(
            "version" to appVersion,
            "commitHash" to (gitCommitHash ?: "not-available")
        )
    }
}