(ns mintscrape.core
  (:gen-class)
  (:require [clj-http.client :as client]
            [clojure.java.io :as io]))

(defn config-file []
  (io/file (System/getProperty "user.home") ".mintscrape"))

(defn read-config
  ([config-file]
     (with-open [reader (clojure.java.io/reader config-file)]
       (binding [*in* reader]
         (let [username (read-line)
               password (read-line)]
           {:username username
            :password password}))))
  ([]
     (read-config (config-file))))

(defn -main [& args]
  (let [config (read-config)]
    (binding [clj-http.core/*cookie-store* (clj-http.cookies/cookie-store)]
      (client/get "https://wwws.mint.com/login.event")
      (client/post "https://wwws.mint.com/loginUserSubmit.xevent"
                   {:form-params {"username" (:username config)
                                  "password" (:password config)
                                  "task" "L"
                                  "browser" "firefox"
                                  "browserVersion" "32"
                                  "os" "mac"}
                    :force-redirects true})
      (client/get "https://wwws.mint.com/transaction.event")
      (let [body (:body (client/get "https://wwws.mint.com/transactionDownload.event?queryNew=&offset=0&filterType=cash&comparableType=8"))]
        (print body)
        (flush)))))
