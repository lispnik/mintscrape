# mintscrape

Automatically export your entire transaction list from https://mint.com.

Create a configuration file `~/.mintscrape` and include something like:

    yourusername
    yourpassword

The username should be on the first line, and the password should be on the second.

Create a standalone jar:

    lein uberjar
    java -jar target/mintscrape-1.0-standalone.jar

or run from Leiningen:

    lein run

The latest release of the standalone JAR can be found at https://github.com/lispnik/mintscrape/releases/latest

## License

Public Domain
