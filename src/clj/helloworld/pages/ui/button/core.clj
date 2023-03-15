(ns helloworld.pages.ui.button.core
  (:require [rum.core :as rum]))


(rum/defc button-lang []
  [:button.flex.justify-center.items-center.w-8.h-8.ml-auto.border.border-lime-600.text-sm.text-lime-600
   {:type "button"}
   "Ru"])
