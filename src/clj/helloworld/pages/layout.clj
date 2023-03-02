(ns helloworld.pages.layout
  (:require [clojure.java.io :as io]))

(def ^:const layout-filename "default.html")

(def layout
  "Default layout HTML5 string."
  (slurp (io/resource layout-filename)))
