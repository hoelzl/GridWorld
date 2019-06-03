plugins {
    java
    application
}

repositories {
    jcenter()
}

val hamcrestVersion = "2.1"
val jUnitVersion = "5.4.2"
val slf4jVersion = "1.7.25"
val textIoVersion = "3.2.0"

dependencies {
    compile("org.beryx:text-io:$textIoVersion")
    compile("org.slf4j:slf4j-api:$slf4jVersion")
    compile("org.slf4j:slf4j-simple:$slf4jVersion")
    testCompile("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$jUnitVersion")
    testImplementation("org.hamcrest:hamcrest-library:$hamcrestVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_12
    targetCompatibility = JavaVersion.VERSION_12
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "gridworld.app.App"
    }
}

application {
    mainClassName = "gridworld.app.App"
}
