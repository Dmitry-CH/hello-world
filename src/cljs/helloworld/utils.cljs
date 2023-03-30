(ns helloworld.utils
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [promesa.core :as p]))


(defn parse-cookie [cookie]
  (when-not (empty? cookie)
    (walk/keywordize-keys
     (into {} (as-> cookie c
                (str/split c #";")
                (map #(-> %
                          str/trim
                          (str/split #"=" 2)) c))))))


(defn preload-fonts! [id]
  (p/promise (fn [resolve _]
               (.load js/WebFont (clj->js {:typekit {:id id}
                                           :active resolve})))))
