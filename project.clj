(defproject hello-world "0.1.0-SNAPSHOT"
  
  ;;; Metadata
  :description ""
  :url ""
  :min-lein-version "2.0.0"
  
  ;;; Dependencies, Plugins, and Repositories
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.logging "1.2.4"]
                 [ch.qos.logback/logback-classic "1.4.5"]
                 [com.taoensso/tempura "1.5.3"]
                 [com.taoensso/timbre "6.0.4"]
                 [integrant "0.8.0"]
                 [io.github.clj-kondo/config-rum-rum "1.0.0"]
                 [metosin/reitit "0.6.0"]
                 [metosin/ring-http-response "0.9.3"]
                 [ring/ring-core "1.9.6"]
                 [ring/ring-jetty-adapter "1.9.6"]
                 [rum "0.12.10" :exclusions [cljsjs/react cljsjs/react-dom]]
                 [selmer "1.12.57"]]
  :plugins [[lein-pprint "1.3.2"]]

  ;;; Profiles
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "1.4.1"]
                                  [integrant/repl "0.3.2"]]
                   :source-paths ["env/dev/clj"]
                   :resource-paths ["env/dev/resources"]

                   :jvm-opts ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory"]}
             
             :uberjar {:source-paths ["env/prod/clj"]
                       :resource-paths ["env/prod/resources"]
                       
                       :aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"
                                  "-Dclojure.compiler.elide-meta=[:added :doc :file :line]"
                                  "-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory"]
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
