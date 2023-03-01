(ns helloworld.handler
  (:require [integrant.core :as ig]
            [reitit.ring :as ring]))

(defmethod ig/init-key :handler/ring
  [_ {:keys [router]}]
  (ring/ring-handler
   (ring/router router {})))
