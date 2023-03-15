(ns helloworld.pages.home.view
  (:require [rum.core :as rum] 
            [helloworld.pages.layout :refer [extend-layout]]
            [helloworld.pages.ui.button.core :refer [button-lang]]))


(rum/defc about []
  [:dl.js-splitting.grid.gap-4.grid-cols-2.uppercase.text-2xl
   {:class "max-w-[50%]"}

   [:dt.font-bold "Name:"]
   [:dd "Dmitry Chekanov"]

   [:dt.font-bold "Profession:"]
   [:dd "Creative Web Developer"]

   [:dt.font-bold "Bio:"]
   [:dd "7 years experience"]

   [:dt.font-bold "Projects:"]
   [:dd "Hello World"]])


(rum/defc page []
  [:<>
   [:header.absolute.flex.w-full.px-6.py-3.pl-16
    (button-lang)]

   [:main.flex.grow.items-center.pl-16
    (about)]])


(defn render []
  (-> (rum/render-static-markup (page))
      extend-layout))
