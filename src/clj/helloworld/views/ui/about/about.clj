(ns helloworld.views.ui.about.about
  (:require [rum.core :as rum]))


(rum/defc about
  "UI список описаний.
   
   Usage:
   ```
   (about {:name {:title \"...\"
                  :value \"...\"}})
   ```"
  [map]
  [:dl#js-splitting.grid.gap-0.lg:gap-4.text-base.lg:text-2xl.uppercase
   {:class "grid-cols-[1fr] lg:grid-cols-[15ch_1fr] lg:max-w-[50%]"}

   (for [[_ val] map]
     [:<>
      [:dt.font-bold (:title val)]
      [:dd.mb-3.lg:mb-0.last:mb-0 (:value val)]])])
