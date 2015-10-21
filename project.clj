(defproject es-setup "0.1.0-SNAPSHOT"
  :description "ES migrations & seeding for GeoJSON using Joplin"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [joplin.core "0.3.4"]
                 [joplin.elasticsearch "0.3.4"]]
  :aliases {"migrate"  ["run" "-m" "alias/migrate"]
            "seed"     ["run" "-m" "alias/seed"]
            "rollback" ["run" "-m" "alias/rollback"]
            "reset"    ["run" "-m" "alias/reset"]
            "pending"  ["run" "-m" "alias/pending"]
            "create"   ["run" "-m" "alias/create"]})
