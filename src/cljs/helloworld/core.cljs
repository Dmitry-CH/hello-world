(ns helloworld.core
  (:require [helloworld.type-flourish :refer [flourish! flourish-fx *lang*]]
            [helloworld.utils :refer [parse-cookie]]))


(defn time-counter [el]
  (let [start (.now js/Date)
        elapsed (atom 0)]

    (js/setInterval (fn []
                      (swap! elapsed (fn [_]
                                       (- (.now js/Date) start)))
                      (set! (.-innerHTML el)
                            (.toFixed (/ @elapsed 1000) 3)))
                    100)))


(defn- dom-loaded [_]
  (let [cookie (.-cookie js/document)
        lang (:lang (parse-cookie cookie) "ru")]

    (when-some [el (.querySelector js/document ".loading")]
      (.removeAttribute el "class"))

    ;; Run time counter
    (when-some [el (.querySelector js/document "#js-time")]
      (time-counter el))

    ;; Run text effect
    (when-some [el (.querySelector js/document "#js-splitting")]
      (set! *lang* lang)
      (flourish-fx :fx1 (flourish! el)))))


;; -------------------------
;; Init app

(defn ^:export init! []
  (.addEventListener js/document "DOMContentLoaded" dom-loaded))
