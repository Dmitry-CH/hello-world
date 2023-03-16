(ns helloworld.core
  (:require [helloworld.type-flourish :refer [flourish! flourish-fx]]))

(defn- dom-loaded [_]
  (when-some [el (.querySelector js/document ".js-splitting")]
    (.log js/console "~~~DOMContentLoaded")

    (flourish-fx :fx3 (flourish! el))))

;; -------------------------
;; Initialize app

(defn ^:export init! []
  (.addEventListener js/document "DOMContentLoaded" dom-loaded))
