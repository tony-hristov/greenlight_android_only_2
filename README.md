# GL sample project wqith reference to me.greenlight:partner:2.2.1

To run it, open in Android studio, make the following modifications and run.

- in file greenlight_android_only/settings.gradle

Change maven references to pull your version of Greenlight SDK:

```js
        maven {
            url "https://dl.cloudsmith.io/DisKsZFvs1ikaJJc/alkami/vendor/maven/"
            credentials {
                username = "USERNAME"
                password = "abcd..."
            }
        }
```

- in file greenlight_android_only/app/src/main/java/com/example/greenlight_android_only/Constants.kt

Change the user JWT token with a fresh token:

```js
const val TOKEN_VALUE = "eyJhbGciOiJIUzM4NCIsInR5cCI6Ikp..."
```

- in file greenlight_android_only/app/build.gradle

Toggle `minifyEnabled` as needed:

```js
        debug {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
```


