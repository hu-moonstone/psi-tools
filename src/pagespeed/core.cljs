(ns pagespeed.core
  (:require [clojure.string :as str]
            [cljs.nodejs :as node]))

(enable-console-print!)

(def https
  (node/require "https"))

(def config
  (node/require "config"))

(defn -main [& args]
  (let [url (first args)
        strategy (first (rest args))]
    (.get https #js {:host "www.googleapis.com",
                     :path (str "/pagespeedonline/v4/runPagespeed"
                                "?url=" url
                                "&key=" config.key
                                "&strategy=" strategy)}
          (fn [res]
            (if (= res.statusCode 200)
              (.on res "data" (fn [d]
                                (.write process.stdout d)))))))
  )
(set! *main-cli-fn* -main)
