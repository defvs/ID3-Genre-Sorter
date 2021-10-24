import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.5.21"
	id("org.jetbrains.compose") version "1.0.0-alpha3"
}

group = "dev.defvs"
version = "0.1"

repositories {
	google()
	mavenCentral()
	maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
	implementation(compose.desktop.currentOs)
	implementation("net.jthink:jaudiotagger:3.0.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}

compose.desktop {
	application {
		mainClass = "MainKt"
		nativeDistributions {
			targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
			packageName = "ID3GenreSorter"
			packageVersion = "1.0.0"
		}
	}
}