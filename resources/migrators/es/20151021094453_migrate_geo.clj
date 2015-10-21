(ns migrators.es.20151021094453-migrate-geo
  (:use [joplin.elasticsearch.database]))

(defn up [db]
  (create-index (client db)
                "locations"
                :mappings {:location {:properties
                                      {:location {:type "geo_shape"}
                                       :name     {:type  "string"
                                                  :index "not_analyzed"}}}}))

(defn down [db]
  (rollback-index (client db) "locations"))
