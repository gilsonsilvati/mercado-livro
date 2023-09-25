import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "com.mercadolivro"
version = "0.0.1-SNAPSHOT"

val flywayVersion = "9.16.0"
val springDocVersion = "2.2.0"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenLocal()
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.1.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")

	implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")

	implementation("org.flywaydb:flyway-core:$flywayVersion")
	implementation("org.flywaydb:flyway-mysql:$flywayVersion")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springDocVersion")

	runtimeOnly("com.mysql:mysql-connector-j:8.0.32")

	testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
