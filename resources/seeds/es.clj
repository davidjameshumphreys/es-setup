(ns seeds.es
  (:require [clojurewerkz.elastisch.rest.document :as esd]
            [joplin.elasticsearch.database :refer [client native-client migrate-data-native]]
            [clojure.java.io :as io]
            [cheshire.core :as json]))

(defn- load-files []
  (->> "countries"
       io/resource
       io/file
       file-seq
       (remove  #(.isDirectory %))
       (filter (comp (partial re-matches #"[A-Z]{3}.geo.json") #(.getName %)))))

;;TODO: Maybe move to the bulk API?
(defn run [target & args]
  (doall
   (doseq [f (load-files)
           :let [j  (json/decode-stream (io/reader f))
                 n  (-> j (get "features") first (get "properties") (get "name"))
                 id (-> j (get "features") first (get "id"))
                 json (-> j (get "features") first (get "geometry"))]]
     (println id)
     (try
       (println (esd/put (client (:db target)) "locations" "location" id
                         {:location json
                          :name     n}))
       (catch Exception e
         (println e))))))
