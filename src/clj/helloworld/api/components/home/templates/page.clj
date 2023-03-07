(ns helloworld.api.components.home.templates.page
  (:require [rum.core :as rum]
            [helloworld.view :refer [extend-layout]]))

(rum/defc title [s]
  [:h1 s])

(defn render []
  (->> (rum/render-static-markup (title "Hello World!"))
       extend-layout))
