(ns helloworld.view
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def ^:const layout-path "public/default.html")

(def layout
  (slurp (io/resource layout-path)))

(defn extend-layout [body]
  (str/replace layout #"\{\{BODY\}\}" body))
