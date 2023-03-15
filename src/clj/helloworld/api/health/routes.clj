(ns helloworld.api.health.routes
  (:require [integrant.core :as ig]
            [helloworld.api.health.handler :as handler]))


(defmethod ig/init-key :api/health
  [_ {:keys [path]}]
  [path
   {:get handler/health}])
