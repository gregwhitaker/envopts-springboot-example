# envopts-springboot-example
An example of using [EnvOpts](https://github.com/gregwhitaker/envopts) in a Spring Boot application.

## Building the Example
Run the following command to build the example application as a Docker image:

    ./gradlew clean buildImage

## Running the Example
Follow the steps below to run the example application:

1. Run the following command to start the example application:

        docker run -p 8080:8080 envopts/envopts-springboot-example
        
    Notice how the application starts with the `default` Spring profile and the log lines indicate the application is using the `log4j2.xml` configuration file:
   
         .   ____          _            __ _ _
        /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
       ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
        \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
         '  |____| .__|_| |_|_| |_\__, | / / / /
        =========|_|==============|___/=/_/_/_/
        :: Spring Boot ::        (v2.2.4.RELEASE)
       
       [log4j2.xml] [INFO ] 2020-03-21 22:59:21.649 [main] Application - Starting Application on 6c2a64cf0cce with PID 1 (/opt/envopts-springboot-example/app.jar started by root in /)
       [log4j2.xml] [INFO ] 2020-03-21 22:59:21.655 [main] Application - No active profile set, falling back to default profiles: default
       [log4j2.xml] [INFO ] 2020-03-21 22:59:23.503 [main] NettyWebServer - Netty started on port(s): 8080
       [log4j2.xml] [INFO ] 2020-03-21 22:59:23.510 [main] Application - Started Application in 2.381 seconds (JVM running for 3.699)

2. Next, run the following command to start the application and specify a `local` Spring profile and a different log4j configuration file using the `ENV_OPTS` environment variable:

        docker run -e ENV_OPTS="-Dspring.profiles.active='local',-Dlog4j.configurationFile=log4j2-local.xml" -p 8080:8080 envopts/envopts-springboot-example
        
        
    Notice that the application now starts with the `local` Spring profile and the log lines indicate the application is using the `log4j2-local.xml` configuration file:

          .   ____          _            __ _ _
         /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
        ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
         \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
          '  |____| .__|_| |_|_| |_\__, | / / / /
         =========|_|==============|___/=/_/_/_/
         :: Spring Boot ::        (v2.2.4.RELEASE)
        
        [log4j2-local.xml] [INFO ] 2020-03-21 23:00:51.371 [main] Application - Starting Application on 9c334c1a5c6b with PID 1 (/opt/envopts-springboot-example/app.jar started by root in /)
        [log4j2-local.xml] [INFO ] 2020-03-21 23:00:51.377 [main] Application - The following profiles are active: local
        [log4j2-local.xml] [INFO ] 2020-03-21 23:00:53.212 [main] NettyWebServer - Netty started on port(s): 8080
        [log4j2-local.xml] [INFO ] 2020-03-21 23:00:53.219 [main] Application - Started Application in 2.394 seconds (JVM running for 3.738)

## Bugs and Feedback
For bugs, questions, and discussions please use the [Github Issues](https://github.com/gregwhitaker/envopts-springboot-example/issues).

## License
MIT License

Copyright (c) 2020 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.