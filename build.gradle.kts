plugins {
	kotlin("jvm") version "2.2.0"
}

group = "site.remlit.blueb"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	maven {
		url = uri("https://repo.remlit.site/releases")
	}
	maven {
		url = uri("https://repo.remlit.site/snapshots")
	}
}

dependencies {
	// Only needed for compilation, all this code will already be present when run by Aster
	compileOnly("site.remlit.blueb:aster:2025.9.1.0-SNAPSHOT")
}

kotlin {
	jvmToolchain(21)
}