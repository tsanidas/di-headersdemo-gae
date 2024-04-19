# Headers Demo backend
For use with client demo apps to demonstrates behavior with values of 'Cache-Control' response headers on mobile app frontends.
For more info and explanations of how 'Cache-Control' response header values affect
your apps, see [Use Your Headers](https://blog.diveinsoft.com/2024/04/for-on-device-caching-use-your-headers.html)

This is a simple Spring Boot app that is deployed in Google Cloud's "App Engine" environment.
Using Spring's `ResponseEntity` API, I'm able to set the cache control headers in code.

## Executing Locally
You must first download the Google Cloud SDK, but then can use standard Maven commands to build and start the local server.

`mvn spring-boot:run`

will start the app on port 8080.

