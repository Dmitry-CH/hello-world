(ns helloworld.pages.ui.button.core
  (:require [rum.core :as rum]))


(rum/defc button-square [text]
  [:button.flex.justify-center.items-center.w-8.h-8.ml-auto.border.border-lime-500.text-sm.text-lime-500.hover:scale-125.transition-transform
   {:type "button"}
   text])
