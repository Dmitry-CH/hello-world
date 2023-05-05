(ns helloworld.views.ui.button.button
  (:require [rum.core :as rum]))


(def classes ["flex"
              "items-center"
              "justify-center"
              "w-8"
              "h-8"
              "border"
              "border-lime-500"
              "text-sm"
              "text-lime-500"
              "hover:scale-125"
              "transition-transform"])


(rum/defc button-square #_#_< rum/static
  ([children]
   (button-square children nil))

  ([children attrs]
   [:button
    (merge {:class classes :type "button"}
           attrs)
    children]))
