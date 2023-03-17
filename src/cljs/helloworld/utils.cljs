(ns helloworld.utils
  (:require [promesa.core :as p]))


(defn parse-cookie [cookie]
  (when-not (empty? cookie)
    {}))


(defn preload-fonts! [id]
  (p/promise (fn [resolve _]
               (.load js/WebFont (clj->js {:typekit {:id id}
                                           :active resolve})))))
