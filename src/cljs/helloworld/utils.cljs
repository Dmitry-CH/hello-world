(ns helloworld.utils
  (:require [promesa.core :as p]))


(defn preloadFonts [family]
  (p/promise (fn [resolve _]
               (.load js/WebFont (clj->js {:typekit {:id family}
                                           :active resolve})))))
