(ns helloworld.core
  (:require [helloworld.type-shuffle :refer [shuffle shuffle-effect]]))

(defn- dom-loaded [_]
  (when-some [el (.querySelector js/document ".js-splitting")]
    (shuffle-effect :fx3 (shuffle el))))

;; -------------------------
;; Initialize app

(defn ^:export init! []
  (.addEventListener js/document "DOMContentLoaded" dom-loaded))
