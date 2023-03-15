(ns helloworld.config
  (:require [clojure.java.io :as io]
            [integrant.core :as ig]))


(def ^:const system-filename "system.edn")

(defn system-config []
  (ig/read-string
   (slurp (io/resource system-filename))))
