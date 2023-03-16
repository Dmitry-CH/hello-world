(ns helloworld.pages.home.view
  (:require [rum.core :as rum] 
            [helloworld.pages.layout :refer [extend-layout]]
            [helloworld.pages.ui.button.core :refer [button-lang]]))


(rum/defc about []
  [:dl.js-splitting.grid.gap-4.uppercase.text-2xl
   {:class "grid-cols-[15ch_1fr] max-w-[50%]"}

   [:dt.font-bold "Name:"]
   [:dd "Dmitry Chekanov"]

   [:dt.font-bold "Profession:"]
   [:dd "Creative Web Developer"]

   [:dt.font-bold "Bio:"]
   [:dd "7 years experience - HTML, CSS, JavaScript. Passion for creativity in the digital space. Constantly seeking new challenges, growth opportunities. Skilled in modern web development frameworks."]])


(rum/defc page []
  [:<>
   [:header.absolute.flex.items-center.w-full.px-6.py-3.pl-16
    [:h2.text-sm.text-lime-500 "Hi! Guest"]
    (button-lang)]

   [:main.flex.grow.items-center.pl-16
    (about)]])


(defn render []
  (-> (rum/render-static-markup (page))
      extend-layout))
