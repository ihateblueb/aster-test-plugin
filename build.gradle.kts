import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
	kotlin("jvm") version "2.2.0"
	id("io.ktor.plugin") version "3.3.1"
}

group = "site.remlit.blueb"
version = "1.2-SNAPSHOT"

repositories {
	mavenCentral()
	maven {
		url = uri("https://repo.remlit.site/snapshots")
	}
}

dependencies {
	// Only needed for compilation, all this code will already be present when run by Aster
	compileOnly("site.remlit.blueb:aster:2025.10.2.0-SNAPSHOT")

	// Most dependencies will already be used in Aster.
	// You can choose to include them with implementation, but it's recommended you don't
	compileOnly("ch.qos.logback:logback-classic:1.5.18")
	compileOnly("org.slf4j:slf4j-api:2.0.17")
	compileOnly("io.ktor:ktor-server-core:3.3.1")
}

// Prevent Ktor plugin from trying to make a jar for a standalone application
tasks.withType<ShadowJar> {
	enabled = false
}

kotlin {
	jvmToolchain(21)
}