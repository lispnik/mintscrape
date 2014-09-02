(defproject mintscrape "1.0"
  :description "Automatically export your entire transaction list from https://mint.com"
  :url "http://github.com/lispnik/mintscrape"
  :license {:name "Public Domain"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.0.0"]]
  :profiles {:uberjar {:aot :all}}
  :main mintscrape.core)
