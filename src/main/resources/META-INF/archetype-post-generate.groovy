import java.io.File
import java.net.URL
import java.nio.file.Paths

import org.slf4j.Logger
import org.slf4j.LoggerFactory

def log = LoggerFactory.getLogger('com.github.bentaljaard.quarkus-microservice-archetype')
log.info "Downloading OpenAPI spec from ${request.properties['openapi-url']}..."
def encoding = 'UTF-8'
def url = new URL(request.properties['openapi-url'])
def apiText = url.getText(encoding)



log.info "Writing OpenAPI definition to openapi.yaml file..."

def fileDir = Paths.get(request.outputDirectory, request.artifactId, 'src/main/resources/META-INF').toFile()
def fileName = 'openapi.yaml'
def file = new File(fileDir, fileName)
fileDir.mkdirs();
file.setText(apiText, encoding)

// run("mvn compile")