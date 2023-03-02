(ns helloworld.api.components.health.routes
  (:require [integrant.core :as ig]
            [helloworld.api.components.health.handler :as handler]))

(defmethod ig/init-key :api.components/health
  [_ {:keys [path]}]
  [path
   {:get handler/health}])
