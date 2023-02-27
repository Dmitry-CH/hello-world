(defproject hello-world "0.1.0-SNAPSHOT"
  
  ;;; Metadata
  :description ""
  :url ""
  :min-lein-version "2.0.0"
  
  ;;; Dependencies, Plugins, and Repositories
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [com.taoensso/timbre "6.0.4"]
                 [integrant "0.8.0"]
                 [metosin/reitit "0.6.0"]
                 [metosin/ring-http-response "0.9.3"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]]
  :plugins [[lein-pprint "1.3.2"]]

  ;;; Profiles
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "1.4.1"]]}
             
             :uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"
                                  "-Dclojure.compiler.elide-meta=[:added :doc :file :line]"]
                       :omit-source true
                       :uberjar-name "helloworld-standalone.jar"}}
  
  ;;; Entry Point
  :main ^:skip-aot helloworld.core
  
  ;;; Filesystem Paths
  :source-paths ["src/clj"]
  :resource-paths ["resources"]
  :test-paths ["test/clj"]
  :target-path "target/%s/")

;; https://github.com/technomancy/leiningen/blob/stable/sample.project.clj
