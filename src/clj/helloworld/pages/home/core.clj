(ns helloworld.pages.home.core
  (:require [clojure.string :as str]
            [rum.core :as rum]
            [helloworld.pages.layout :refer [layout]]))

(rum/defc title [s]
  [:h1 s])

(defn render-home []
  (->> (rum/render-static-markup (title "Hello World!"))
       (str/replace layout #"\{\{BODY\}\}")))
