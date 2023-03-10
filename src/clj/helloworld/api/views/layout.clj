(ns helloworld.api.views.layout
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def ^:const layout-path "public/default.html")

(def layout
  (slurp (io/resource layout-path)))

(defn extend-layout [body]
  (str/replace layout #"\{\{BODY\}\}" body))
