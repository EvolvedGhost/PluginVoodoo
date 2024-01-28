plugins {
    val kotlinVersion = "1.9.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.16.0"
}

group = "org.AlerHughes"
version = "1.6.2"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}