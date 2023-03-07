(ns helloworld.api.components.home.templates.page
  (:require [rum.core :as rum]
            [helloworld.view :refer [extend-layout]]))

(rum/defc title [s]
  [:h1 s])

(rum/defc page []
  [:main.flex.justify-center.items-center.h-screen.bg-black.text-4xl.text-white
   (title "Hello World!")])

(defn render []
  (->> (rum/render-static-markup (page))
       extend-layout))
