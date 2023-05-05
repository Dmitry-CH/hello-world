(ns user
  "Userspace functions you can run by default in your local REPL."
  (:require [clojure.tools.namespace.repl :as repl]
            [integrant.core :as ig]
            [integrant.repl :refer [go halt reset reset-all]]
            [helloworld.config :refer [system-config]]))


(require 'helloworld.core)


;; ...
(defn dev-prep! []
  (integrant.repl/set-prep! (fn []
                              (-> (system-config)
                                  ig/prep))))

(dev-prep!)


(repl/set-refresh-dirs "src/clj")

(def refresh repl/refresh)

(comment
  (go)
  (halt)
  (reset)
  (reset-all)
  (refresh)
  :rcf)
