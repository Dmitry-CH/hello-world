(ns helloworld.pages.ui.button.core
  (:require [rum.core :as rum]))


(rum/defc button-square < rum/static
  ([children]
   (button-square children nil))
  
  ([children attrs]
   [:button.flex.items-center.justify-center.w-8.h-8.border.border-lime-500.text-sm.text-lime-500.hover:scale-125.transition-transform
    (merge {:type "button"} attrs)
    children]))
