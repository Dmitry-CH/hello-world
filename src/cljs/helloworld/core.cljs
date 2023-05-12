(ns helloworld.core
  (:require [helloworld.type-flourish :refer [flourish! flourish-fx *lang*]]
            [helloworld.utils :refer [parse-cookie]]))


(def default-lang "ru")

(def start (.now js/Date))
(def elapsed (atom 0))


(defn time-counter [el]
  (let [#_#_start (.now js/Date)
        #_#_elapsed (atom 0)]

    (js/setInterval (fn []
                      (swap! elapsed (fn [_]
                                       (- (.now js/Date) start)))
                      (set! (.-innerHTML el)
                            (.toFixed (/ @elapsed 1000) 3)))
                    100)))


(defn- current-lang []
  (let [cookies (.-cookie js/document)
        lang (:lang (parse-cookie cookies) default-lang)]
    lang))


(defn- run [lang]
  ;; Hide loading screen
  (when-some [el (.querySelector js/document ".loading")]
    (.removeAttribute el "class"))

  ;; Run time counter
  (when-some [el (.querySelector js/document "#js-time")]
    (time-counter el))

  ;; Run text effect
  (when-some [el (.querySelector js/document "#js-splitting")]
    (set! *lang* lang)
    (flourish-fx :fx1 (flourish! el))))


;; -------------------------
;; Init app

(defn ^:export init! []
  (.addEventListener js/document
                     "DOMContentLoaded"
                     (fn [_]
                       (run (current-lang))))

  (.addEventListener (.-body js/document)
                     "htmx:load"
                     (fn [_]
                       (run (current-lang)))))
